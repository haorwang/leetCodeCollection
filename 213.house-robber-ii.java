class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(robRow(nums, 1, nums.length), robRow(nums, 0, nums.length - 1));
    }

    public int robRow(int[] nums, int s, int e) {

        int last = 0;
        int curr = 0;
        for (int i = s; i < e; i++) {
            int newLast = curr;
            curr = Math.max(nums[i] + last, curr);
            last = newLast;
        }
        return curr;
    }
}
