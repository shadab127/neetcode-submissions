class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;
        Map<Integer,ArrayList<Integer>> adjList = new HashMap<>();
        for(int[] edge : edges){
            adjList.computeIfAbsent(edge[0], x -> new ArrayList<Integer>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1], x -> new ArrayList<Integer>()).add(edge[0]);
        }
        boolean[] visited = new boolean[n];

        boolean cycle = findCycle(adjList, visited, 0, -1);
        if(cycle){
            return false;
        }
        for(boolean visit: visited){
            if(!visit){
                return false;
            }
        }
        return true;
    }
    public boolean findCycle(Map<Integer,ArrayList<Integer>> adjList , boolean[] visited, int curr, int parent){
        visited[curr] = true;
        for(int neighbor : adjList.getOrDefault(curr, new ArrayList<>())){
            if(neighbor != parent && !visited[neighbor]){
                if(findCycle(adjList,visited,neighbor,curr)){
                    return true;
                }
            }
            else if(neighbor != parent && visited[neighbor]){
                return true;
            }
        }
        return false;
    }
}
