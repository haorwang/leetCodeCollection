class Solution {


    public int numDistinct(String s, String t) {
        int [] dp = new int[s.length() + 1];
        Arrays.fill(dp, 1);

        int max = 0;
        for (int i = 0; i < t.length(); i++) {
            int newDp[] = new int[dp.length];
            for (int j = 1; j <= s.length(); j++) {
                if (s.charAt(j - 1) == t.charAt(i)){
                    newDp[j] = newDp[j - 1] + dp[j - 1];
                } else {
                    newDp[j] = newDp[j - 1];
                }
            }

            dp = newDp;
        }
        return dp[s.length()];
    }
}

