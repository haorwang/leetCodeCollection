class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        if (matrix[0].length == 0) {
            return false;
        }
        int l = 0;
        int r = matrix.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (matrix[m][0] == target) {
                return true;
            } else if (matrix[m][0] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        if (r == -1) {
            return false;
        }

        int rowNum = r;
        l = 0;
        r = matrix[0].length - 1;


        while (l <= r) {
            int m = (l + r) / 2;
            if (matrix[rowNum][m] == target) {
                return true;
            } else if (matrix[rowNum][m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return false;
    }
}