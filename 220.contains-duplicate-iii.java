class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> tSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long num = tSet.floor((long)nums[i] + (long) t);

            if (num != null && num >= (long)nums[i] - (long)t) {
                return true;
            }
            tSet.add((long)nums[i]);
            if (i >= k) {
                tSet.remove((long)nums[i - k]);
            }
        }
        return false;
    }
}
