class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        int[][] counter = new int[heights.length][heights[0].length];
        for(int i=0;i<heights[0].length;i++){
            if(!visited[0][i]){
                traverse(heights, visited, counter, 0, i);
            }
        }
        for(int i=1;i<heights.length;i++){
            if(!visited[i][0]){
                traverse(heights, visited, counter, i, 0);
            }
        }
        visited = new boolean[heights.length][heights[0].length];
        for(int i=0;i<heights[0].length;i++){
            if(!visited[heights.length-1][i]){
                traverse(heights, visited, counter, heights.length-1, i);
            }
        }
        for(int i=0;i<heights.length-1;i++){
            if(!visited[i][heights[0].length-1]){
                traverse(heights, visited, counter, i, heights[0].length-1);
            }
        }
        List<List<Integer>> values = new ArrayList<>();
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                if(counter[i][j] == 2){
                    values.add(new ArrayList<Integer>(List.of(i,j)));
                }
            }
        }
        return values;
    }
    public void traverse(int[][] heights, boolean[][] visited, int[][] counter, int row, int col){
        visited[row][col] = true;
        counter[row][col]++;

        for(int[] dir: dirs){
            int nr = row + dir[0];
            int nc = col + dir[1];
            if(nr > -1 && nc > -1 && nr < heights.length && nc < heights[0].length && !visited[nr][nc] && heights[row][col] <= heights[nr][nc]){
                traverse(heights, visited, counter, nr, nc);
            }
        }
    }
}
