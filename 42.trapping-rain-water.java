
class Solution {
    public int trap(int[] height) {
    	if (height.length < 2) return 0;
        int[] fromLeft = new int[height.length];
        int[] fromRight = new int[height.length];
        
        int max = 0;
        for (int i = 0; i < height.length; i++) {
        	max = Math.max(max, height[i]);
        	fromLeft[i] = max;
        }
        max = 0;
        for (int i = height.length - 1; i >= 0; i--) {
        	max = Math.max(max, height[i]);
        	fromRight[i] = max;
        }
        int res = 0;
        for (int i = 0; i < height.length; i++) {
        	res += Math.min(fromLeft[i], fromRight[i]) - height[i];
        }
        return res;
    }
}