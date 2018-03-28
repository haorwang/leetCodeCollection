class Solution {
    public int maximalRectangle(char[][] matrix) {

        if (matrix.length == 0) {
            return 0;
        }
        int maxArea = 0;

        int[] left = new int[matrix[0].length];
        int[] right = new int[matrix[0].length];
        Arrays.fill(right, matrix[0].length);
        int[] height =  new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {

            int lastLeftInd = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    left[j] = 0;
                    lastLeftInd = j + 1;
                } else {
                    left[j] = Math.max(left[j], lastLeftInd);
                }
            }

            int lastRightInd = matrix[0].length;
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                if (matrix[i][j] == '0') {
                    right[j] = matrix[0].length;
                    lastRightInd = j;
                } else {
                    right[j] = Math.min(right[j], lastRightInd);
                }
            }

            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    height[j] = 0;
                } else {
                    height[j]++;

                    int area = (right[j] - left[j]) * height[j];
                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        return maxArea;
    }
}
