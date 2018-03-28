class Solution {
    public int search(int[] nums, int target) {
    	int l = 0, r = nums.length - 1;
		while (l <= r) {
			int m = (l + r) / 2;
			if (nums[m] == target) {
				return m;	
			}
			if (nums[m] >= nums[l]) { //!!!!!!! think about it why [3, 1]
				if (target >= nums[l] && target < nums[m]) {
					r = m - 1;
				} else {
					l = m + 1;
				}
			} else { //nums[m] < nums[l]
				if (target > nums[m] && target <= nums[r]) {
					l = m + 1;
				} else {
					r = m - 1;
				}
			}
		}

		return -1;
    }
}
