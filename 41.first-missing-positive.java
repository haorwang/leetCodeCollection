class Solution {
    public int firstMissingPositive(int[] nums) {
        
    	for (int i = 0; i < nums.length; i++) {
    		if (nums[i] > 0 
    				&& nums[i] - 1 < nums.length 
    				&& nums[i] - 1 != i
    				&& nums[nums[i] - 1] != nums[i]) {
    			swap(nums, nums[i] - 1, i);
    			i--;
    		}
        }
    	
    	int res = 1;
    	
    	while (res - 1 < nums.length && nums[res - 1] == res) {
    		res++;
    	}
    	return res;

    }
    
    public void swap(int[] nums, int a, int b) {
    	int c = nums[a];
    	nums[a] = nums[b];
    	nums[b] = c;
    	
    }
}