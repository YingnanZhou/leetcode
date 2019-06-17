
	class Solution {
	    int[] nums;
	    Random r;
	    public Solution(int[] nums) {
	        this.nums = nums;
	        this.r = new Random();
	    }
	    
	// {1,2,3,3,3}  
	// 2 : It's probability of selection is 1 * (1/2) * (2/3) = 1/3
	// 3 : It's probability of selection is (1/2) * (2/3) = 1/3
	// 4 : It's probability of selection is just 1/3
	    
	    public int pick(int target) {
	        int res = -1;
	        int count = 0;
	        for(int i = 0; i < nums.length; i++) {
	            if(nums[i] != target) continue;
	            if(r.nextInt(++count) == 0) 
	                res = i;
	        }
	        return res;
	    }
	}
	/**
	 * Your Solution object will be instantiated and called as such:
	 * Solution obj = new Solution(nums);
	 * int param_1 = obj.pick(target);
	 */

