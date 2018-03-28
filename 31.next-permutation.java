class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length <= 1) {
        	return;
        }
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
        	i--;
        }
        if(i == -1) {
        	reverse(nums, 0, nums.length - 1);
        } else {
        	int j = nums.length - 1;
        	while (nums[j] <= nums[i]) {
        		j--;
        	}
        	swap(nums, i, j);
        	reverse(nums, i + 1, nums.length - 1);
        }
    }
    
    public void swap(int[] nums, int i, int j) {
    	int c = nums[i];
    	nums[i] = nums[j];
    	nums[j] = c;
    }
    
    public void reverse(int[] nums, int i, int j) {
    	while (i < j) {
    		swap(nums, i++, j--);
    	}
    }
}