class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer,List<Integer>> adjList = new HashMap<>();
        for(int[] edge: edges){
            adjList.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int connectedComponent = 0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(adjList,visited,i);   
                connectedComponent++;         
            }
        }
        return connectedComponent;
    }
    public void dfs(Map<Integer,List<Integer>> adjList, boolean[] visited, int curr){
        visited[curr] = true;
        for(int neighbor: adjList.getOrDefault(curr, new ArrayList<>())){
            if(!visited[neighbor]){
                dfs(adjList, visited, neighbor);
            }
        }
    }
}
