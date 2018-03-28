class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
        	int m = (l + r) / 2;
        	if (nums[m] == target) {
        		return m;
        	} else if (nums[m] >= nums[0]) {
        		if(target >= nums[0] && target < nums[m]) { // target on left
        			r = m - 1;
        		} else { // target on right
        			l = m + 1;
        		}
        	} else { // nums[m] <= nums[nums.length - 1] 
        		if(target <= nums[nums.length - 1] && nums[m] < target) { // target on right
        			l = m + 1;
        		} else { // target on lefrt
        			r = m - 1;
        		}
        	}
        }
        return -1;
    }
}
