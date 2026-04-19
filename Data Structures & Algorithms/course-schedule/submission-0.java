class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int[] prerequisite: prerequisites){
            inDegree[prerequisite[1]]++;
            adjList.computeIfAbsent(prerequisite[0], x -> new ArrayList<>()).add(prerequisite[1]);
        }
        ArrayDeque<Integer> q = new ArrayDeque<>();
        //boolean[] visited = new boolean[numCourses];

        for(int i=0; i<numCourses; i++){
            if(inDegree[i] == 0){
                q.offer(i);
                //visited[i] = true;
            }
        }
        while(!q.isEmpty()){
            int zeroInDegreeNodes = q.size();
            while(zeroInDegreeNodes > 0){
                int currNode = q.poll();
                for(Integer neighbor : adjList.getOrDefault(currNode, new ArrayList<>())){
                    inDegree[neighbor]--;
                    if(inDegree[neighbor] == 0){
                        q.offer(neighbor);
                        //visited[neighbor] = true;
                    }
                }
                zeroInDegreeNodes--;
            }
        }
        for(int degree : inDegree){
            if(degree != 0){
                return false;
            }
        }
        return true;
    }
}
