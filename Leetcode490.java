class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Queue<int[]> queue = new LinkedList<>();
        int m = maze.length, n = maze[0].length;

        //visited array
        boolean[][] visited = new boolean[m][n];
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        Set<String> set = new HashSet<>();
        
        int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        
        //standard bfs 
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            if(cur[0] == destination[0] && cur[1] == destination[1]) return true;
            //explore four directions, find the new start places
            for(int[] dir : dirs) {
                int x = cur[0];
                int y = cur[1];
                //move until we hit the illegal places
                while(x >= 0 && y >= 0 && x < m && y < n && maze[x][y] != 1) {
                    x += dir[0];
                    y += dir[1];
                }
                //cause we move one step more in the while loop, we have to move back 
                x -= dir[0];
                y -= dir[1];
               if(!visited[x][y]) {
                    queue.offer(new int[] {x, y});
                    visited[x][y] = true;
               }
                
                
            }
        }
        return false;
    }
}