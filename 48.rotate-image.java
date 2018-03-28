class Solution {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
        	for (int j = 0; j < (matrix.length + 1) / 2; j++){
        		swap4(i, j, matrix);
        	}
        }
    }
    public void swap4(int i, int j, int[][] matrix) {
    	int i2 = j;
    	int j2 = matrix.length - 1 - i;
    	int i3 = matrix.length - 1 - i;
    	int j3 = matrix.length - 1 - j;
    	int i4 = matrix.length - 1 - j;
    	int j4 = i;
    	int cup = matrix[i][j];
    	matrix[i][j]  = matrix[i4][j4];
    	matrix[i4][j4] = matrix[i3][j3];
    	matrix[i3][j3] = matrix[i2][j2];
    	matrix[i2][j2] = cup;
    }
}