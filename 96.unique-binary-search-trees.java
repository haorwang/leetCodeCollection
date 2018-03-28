class Solution {
    /*
        f(0) = 1;
        f(1) = 1;

        f(n) = f(0)*f(n - 1) + f(1)*f(n - 2) + f(2)*f(n - 3) + .......+ f(n - 1)*f(0);
    */

    public int numTrees(int n) {
        if (n < 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <=i; j++) {
                int right = dp[j - 1];
                int left = dp[i - j];
                dp[i] += right*left;
            }
        }
        return dp[n];

    }
}