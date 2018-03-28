class Solution {
    public int findMin(int[] nums) {
    	
		if (nums.length == 0) {
			return -1;	
		}
		if (nums.length == 1) {
			return nums[0];	
		}
		
		int l = 0;
		int r = nums.length - 1;
		
		if (nums[l] < nums[r]) {
			return nums[l];	
		}

		while (l < r) {
			
			int m = (l + r) / 2;
			
		 	if (r - l <= 1) {
				return Math.min(nums[l], nums[r]);	
			}

			if (nums[m] < nums[l]) {
				r = m;	
			} else {
				l = m;	
			}
		}
		
		return -1;
    }
}
