class Solution {
	//use bfs to calculate the total distances to the nearby buildings for every empty cell
    //so we can choose the one with shortest distance
	//distance[i][j] means for empty cell[i][j], the distance to nearby buildings
    int[][] distance;
    int[][] reach;
    int[][] dirs = new int[][] {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public int shortestDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        distance = new int[m][n];
        reach = new int[m][n];
        int buildingNum = 0;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    buildingNum++;
                    bfs(grid, i, j);
                }
            }
        }
        
        int shortest = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
            	//reach[i][j] here to see if we can reach all buildings
                if(grid[i][j] == 0 && reach[i][j] == buildingNum) {
                    shortest = Math.min(shortest, distance[i][j]);
                }
            }
        }
        
        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }
    
    private void bfs(int[][] grid, int x, int y) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        boolean[][] visited = new boolean[m][n];
        int level = 1;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for(int[] dir : dirs) {
                    int nx = cur[0] + dir[0];
                    int ny = cur[1] + dir[1];
                    if(nx < 0 || ny < 0 || nx >= m || ny >= n || grid[nx][ny] != 0 || visited[nx][ny]) 
                        continue;
                    
                    distance[nx][ny] += level;
                    reach[nx][ny]++;
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
            level++;
        }
    }
}