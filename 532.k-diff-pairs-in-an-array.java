class Solution {
    public int findPairs(int[] nums, int k) {

        if (nums.length == 0 || k < 0) {
            return 0;
        }

        Arrays.sort(nums);

        int cnt = 0;
        int l = 0;
        int r = 1;


        while (r < nums.length) {
            if (nums[r] - nums[l] == k) {
                cnt++;
                r++;
                l++;
                while (r < nums.length && nums[r - 1] == nums[r]
                        && l < nums.length && nums[l - 1] == nums[l]) {
                    l++;
                    r++;
                }
            } else if (nums[r] - nums[l] < k) {
                r++;
                while (r < nums.length && nums[r - 1] == nums[r]) {
                    r++;
                }
            } else {
                l++;
                while (l < nums.length && nums[l - 1] == nums[l]) {
                    l++;
                }
            }
            if (l == r) {
                r++;
            }
        }

        return cnt;
    }
}
