
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
    	for (int layer = 0; layer < (n + 1/ 2); layer++) {
    		for (int j = layer; j < n - layer; j++, num++) {
    			matrix[layer][j] =  num;
    		}
    		for (int i = layer + 1; i < n - layer; i++, num++) {
    			matrix[i][n - 1 - layer] = num;
    		}
    		for (int j = n - 2 - layer; j >= layer; j--, num++) {
    			matrix[n - 1 - layer][j] = num; 
    		}
    		for (int i = n - 2 - layer; i > layer; i--, num++) {
    			matrix[i][layer] = num;
    		}
    	}
    	return matrix;
    }
}