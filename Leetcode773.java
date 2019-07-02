class Solution {
    public int slidingPuzzle(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j]);
            }
        }
        String start = sb.toString();
        
        int[] change = new int[]{-1, 1, -3, 3};
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int count = 0;
        
        queue.offer(start);
        visited.add(start);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String s = queue.poll();
                if(s.equals("123450")) return count;
                
                int index = s.indexOf('0');
                for(int j = 0; j < 4; j++) {
                    int other = index + change[j];
                    if(other < 0 || other > 5 || index == 2 && other == 3 || index == 3 && other == 2) continue;
                    
                    char[] ch = s.toCharArray();
                    ch[index] = ch[other];
                    ch[other] = '0';
                    
                    String newS = String.valueOf(ch);
                    if(visited.add(newS)) queue.offer(newS);
                }
            }
            count++;
        }
        return -1;
    }
}