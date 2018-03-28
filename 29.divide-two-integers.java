/*
class Solution {
	public int divide(int dividend, int divisor) {
		//Reduce the problem to positive long integer to make it easier.
		//Use long to avoid integer overflow cases.
		int sign = 1;
		if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
			sign = -1;
		long ldividend = Math.abs((long) dividend);
		long ldivisor = Math.abs((long) divisor);
		
		//Take care the edge cases.
		if (ldivisor == 0) return Integer.MAX_VALUE;
		if ((ldividend == 0) || (ldividend < ldivisor))	return 0;
		
		long lans = ldivide(ldividend, ldivisor);
		
		int ans;
		if (lans > Integer.MAX_VALUE){ //Handle overflow.
			ans = (sign == 1)? Integer.MAX_VALUE : Integer.MIN_VALUE;
		} else {
			ans = (int) (sign * lans);
		}
		return ans;
	}

	private long ldivide(long ldividend, long ldivisor) {
		// Recursion exit condition
		if (ldividend < ldivisor) return 0;
		
		//  Find the largest multiple so that (divisor * multiple <= dividend), 
		//  whereas we are moving with stride 1, 2, 4, 8, 16...2^n for performance reason.
		//  Think this as a binary search.
		long sum = ldivisor;
		long multiple = 1;
		while ((sum+sum) <= ldividend) {
			sum += sum;
			multiple += multiple;
		}
		//Look for additional value for the multiple from the reminder (dividend - sum) recursively.
		return multiple + ldivide(ldividend - sum, ldivisor);
	}
}
*/

class Solution {
    public static int divide(int dividend, int divisor) {
    	if (dividend == Integer.MIN_VALUE && divisor == -1) {
    		return Integer.MAX_VALUE;
    	}
    	
    	long dd = Math.abs((long) dividend);
    	long dv = Math.abs((long) divisor);
    	
    	int res = 0;
    	while (dd >= dv) {
    		long sum = dv;
    		int mut = 1;
    		while (dd > sum + sum) {
    			sum += sum;
    			mut += mut;
    		}
    		dd -= sum;
    		res += mut;
    	}
    	
    	return ((dividend > 0 && divisor > 0) 
    			|| (dividend < 0 && divisor < 0)) 
    			? res : -res;
  }
}