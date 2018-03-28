class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int[] hoz = new int[grid[0].length];
        hoz[0] = grid[0][0];
        for (int j = 1; j < grid[0].length; j++) {
            hoz[j] = hoz[j - 1] + grid[0][j];
        }

        for (int i = 1; i < grid.length; i++) {
            hoz[0] += grid[i][0];
            for (int j = 1; j < grid[0].length; j++) {
                hoz[j] = grid[i][j] + Math.min(hoz[j - 1], hoz[j]);
            }
        }
        return hoz[grid[0].length - 1];
    }
}
