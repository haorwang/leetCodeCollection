class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int max = 0;
        int[] dp = new int[matrix[0].length];

        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == '1') {
                dp[j] = 1;
            }
            max = Math.max(max, dp[j] * dp[j]);
        }


        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == 0) {
                    if (matrix[i][j] == '1') {
                        dp[j] = 1;
                    } else {
                        dp[j] = 0;
                    }
                } else if (matrix[i][j] == '1') {
                    int min = Math.min(dp[j], dp[j - 1]);
                    if (min  == 0) {
                        dp[j] = 1;
                    } else  if (matrix[i - min][j - min] == '1') {
                        dp[j] = 1 + min;
                    } else {
                        dp[j] = min;
                    }
                } else {
                    dp[j] = 0;
                }
                max = Math.max(max, dp[j] * dp[j]);
                //System.out.print(dp[j]);
            }
            //System.out.println();
        }

        return max;
    }

}
