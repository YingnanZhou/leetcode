class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
         queue.offer(0);
         visited.add(0);
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            // if(visited.contains(cur)) continue;
            // visited.add(cur);
            for(int i : rooms.get(cur)) {
                if(visited.add(i))
                    queue.offer(i);
            }
        }
     return rooms.size() == visited.size();   
    }
}