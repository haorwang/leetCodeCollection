
class Solution {
    public double myPow(double x, int n) {
    	if (n == 0) {
        	return 1;
        } else if (n == 1) {
        	return x;
        }
    	double half = 0.0;
    	if (n < 0) {
    		x = 1 / x;
    		half = myPow(x, - (n / 2));
    	} else {
    		half = myPow(x, n / 2);
    	}
        if (n % 2 == 1 || n % 2 == -1) {
        	return half * half * x;
        } else {
        	return half * half;
        }
    }
}