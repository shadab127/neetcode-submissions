class Solution {
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public int numIslands(char[][] grid) {
        int islands = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    traverse(grid,visited,i,j);
                    islands++;
                }
            }
        }
        return islands;
    }
    public void traverse(char[][] grid, boolean[][] visited, int row, int col){
        visited[row][col] = true;
        for(int[] dir: dirs){
            int nr = row + dir[0];
            int nc = col + dir[1];
            if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && !visited[nr][nc]  && grid[nr][nc] == '1'){
                traverse(grid, visited, nr, nc);
            }
        }
    }
}
