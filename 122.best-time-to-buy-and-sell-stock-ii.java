class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int lastLow = prices[0];
        int lastHigh = prices[0];
        int value = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                value += lastHigh - lastLow;
                lastHigh = prices[i];
                lastLow = prices[i];
            } else {
                lastHigh = prices[i];
            }
        }
        value += lastHigh - lastLow;
        return value;
    }
}