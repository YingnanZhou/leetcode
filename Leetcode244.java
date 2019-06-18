class WordDistance {
    Map<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<>();
        //put every word and its corresponding indices in to map
        for(int i = 0; i < words.length; i++) {
            if(!map.containsKey(words[i]))
                map.put(words[i], new ArrayList<Integer>()); 
            
            map.get(words[i]).add(i);         
        }
    }
    
    public int shortest(String word1, String word2) {
        //here list1 and list2 are sorted
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int res = Integer.MAX_VALUE;
        int i = 0, j = 0;
        
        while(i < list1.size() && j < list2.size()) {
            int index1 = list1.get(i), index2 = list2.get(j);
            res = Math.min(res, Math.abs(index2 - index1));
            if(index1 < index2) i++;
            else j++;
        }
        return res;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */