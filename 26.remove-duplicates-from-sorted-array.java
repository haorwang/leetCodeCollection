class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
        	return 0;
        }
    	int curr = 0;
        int	prevVal = nums[0] + 1;
    	for (int i = 0; i < nums.length; i++) {
        	if (nums[i] != prevVal) {
        		nums[curr++] = nums[i];
        		prevVal = nums[i];
        	}
        }
    	return curr;
    }
}
