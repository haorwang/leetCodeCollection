class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int last = 0;
        int curr = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int oldCurr = curr;
            curr = Math.max(last + nums[i], curr);
            last = oldCurr;
        }
        return curr;
    }
}
