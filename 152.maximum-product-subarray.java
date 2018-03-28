class Solution {
    public int maxProduct(int[] nums) {
		
		if (nums.length == 0) {
			return 0;
		}
		
		int maxPrev = nums[0];
		int minPrev = nums[0];

		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int maxTemp = Math.max(nums[i], Math.max(maxPrev * nums[i], minPrev * nums[i]));
			int minTemp = Math.min(nums[i], Math.min(maxPrev * nums[i], minPrev * nums[i]));

			maxPrev = maxTemp;
			minPrev = minTemp;

			max = Math.max(max, maxTemp);
		}
		return max;
	}		
}
