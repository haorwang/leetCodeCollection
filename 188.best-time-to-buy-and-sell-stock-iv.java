class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k == 0) {
            return k;
        }
        if (k * 2 >= prices.length) {
            int res = 0;
            for (int i =  1; i < prices.length; i++) {
                res += Math.max(prices[i] - prices[i - 1], 0);
            }
            return res;
        }
        int buys[] = new int[k];
        int sells[] = new int[k];
        Arrays.fill(buys, Integer.MIN_VALUE);
        for (int i = 0; i < prices.length; i++) {
            for (int j = k - 1; j >= 0; j--) {
                sells[j] = Math.max(sells[j], buys[j] + prices[i]);
                if (j == 0) {
                    buys[j] = Math.max(buys[j], - prices[i]);
                } else {
                    buys[j] = Math.max(buys[j], sells[j - 1] - prices[i]);
                }
            }
        }
        return sells[sells.length - 1];
    }
}
