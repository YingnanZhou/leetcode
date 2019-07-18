class Solution {
    public int[][] updateMatrix(int[][] matrix) {
       Queue<int[]> queue = new LinkedList<>();
        int m = matrix.length, n = matrix[0].length;
        //we put every 0 into the queue, use BFS level by level, so we can make sure every 1 are first reached by the nearst 0
        //we set 1s to max value to avoid visiting again
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) 
                    queue.offer(new int[]{i, j});
                else matrix[i][j] = Integer.MAX_VALUE;
            }
        }
        //direction array
        int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        
        int level = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for(int[] dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if(x < 0 || y < 0 || x >= m || y >= n || matrix[x][y] != Integer.MAX_VALUE)
                        continue;
                    matrix[x][y] = level;
                    queue.offer(new int[]{x, y});
                }
            }
            level++;
        }
        return matrix;
    }
}