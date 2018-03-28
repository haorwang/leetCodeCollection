class Solution {
    public int jump(int[] nums) {
    	int maxReach = nums[0];
    	int lastReach = 0;
    	int currCnt = 0;
    	for (int i = 1; i < nums.length; i++) {
    		
    		if (i == lastReach + 1) {
    			currCnt++;
    			lastReach = maxReach;
    		}
    		
    		maxReach = Math.max(maxReach, nums[i] + i);
    	}
    	return currCnt;
    }
}