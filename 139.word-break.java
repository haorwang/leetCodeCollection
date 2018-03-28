class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (String word : wordDict) {
                if (i - word.length() < -1) {
                    continue;
                }
                if (s.substring(i - word.length() + 1, i + 1).equals(word) && dp[i - word.length() + 1]) {
                    dp[i + 1] = true;
                    continue;
                }
            }
        }
        return dp[s.length()];
    }
}
