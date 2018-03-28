class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int minSum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
        	sum += num;
        	max = Math.max(max, sum - minSum);
        	minSum = Math.min(minSum, sum);
        }
        return max;
    }
}