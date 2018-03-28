class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = (r + l) / 2;

            if (nums[m] == target) {
                return true;
            }

            if (nums[m] == nums[l] && nums[m] == nums[r]) {
                l++;
                r--;
            } else if (nums[m] == nums[l]) {
                l = m + 1;
            } else if (nums[m] == nums[r]) {
                r = m - 1;
            } else if (nums[m] > nums[0]) { // l
                if (target >= nums[0] && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (target <= nums[nums.length - 1] && target > nums[m]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return false;
    }
}
