class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (s == 0) return 0;
        if (nums.length == 0)  return 0;

        int l = 0, r = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while(r < nums.length) {
            sum+=nums[r];
            r++;
            while (sum >= s && l <= r) {
                min = Math.min(min, r - l);
                sum-=nums[l];
                l++;
            }
        }
        return (min == Integer.MAX_VALUE) ? 0 : min;
    }
}
