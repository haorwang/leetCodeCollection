
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        
        if (matrix.length == 0) {
        	return res;
        }
        
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bot = matrix.length - 1;
        while (left <= right && top <= bot) {
        	for (int j = left; j <= right; j++) {
        		res.add(matrix[top][j]);
        	}
        	top++;
        	if (top > bot) {
        		break;
        	}
        	for (int i = top; i <= bot; i++) {
        		res.add(matrix[i][right]);
        	}
        	right--;
        	if (right < left) {
        		break;
        	}
        	for (int j = right; j >= left; j--) {
        		res.add(matrix[bot][j]);
        	}
        	bot--;
        	for (int i = bot; i >= top; i--) {
        		res.add(matrix[i][left]);
        	}
        	left++;
        }
        return res;
    }
}