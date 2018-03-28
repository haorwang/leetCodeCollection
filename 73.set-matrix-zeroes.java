class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0) {
            return;
        }

        boolean fr = false;
        boolean fc = false;

        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                fr = true;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                fc = true;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 0; j < matrix[0].length; j++) {
            if (fr) {
                matrix[0][j] = 0;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (fc) {
                matrix[i][0] = 0;
            }
        }
    }
}