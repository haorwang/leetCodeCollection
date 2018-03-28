
class Solution {
    public int minDistance(String word1, String word2) {

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[0][0] = 0;

        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                if (i!= word1.length() && j != word2.length()) {
                    if (word1.charAt(i) == word2.charAt(j)) {
                        dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j]);
                    } else {
                        dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j] + 1); //replace
                    }
                }
                if (i != word1.length()) {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1); //del
                }
                if (j != word2.length()) {
                    dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1); //inser
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}