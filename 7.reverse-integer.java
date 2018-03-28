class Solution {
    public int reverse(int x) {
    	// case negtive min -8463847412 not handled
    	
    	int sign = (x < 0) ? -1 : 1;
    	x = Math.abs(x);
    	long res = 0;
    	while (x > 0) {
    		res = res * 10 + x % 10;
    		x = x / 10;
    	}
    	return ((res > Integer.MAX_VALUE) ? 0 : (int) res) * sign;
    }
}
