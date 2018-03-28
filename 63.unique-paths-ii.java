class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) {
            return 0;
        }

        int[] hoz = new int[obstacleGrid[0].length];

        for (int j = 0; j < obstacleGrid[0].length; j++) {
            if (obstacleGrid[0][j] == 1) {
                break;
            }
            hoz[j] = 1;
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    hoz[j] = 0;
                } else if (j > 0) {
                    hoz[j] += hoz[j - 1];
                }
            }
        }

        return hoz[obstacleGrid[0].length - 1];
    }
}