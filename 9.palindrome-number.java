class Solution {
    public boolean isPalindrome(int x) {
    	if (x < 0) return false;
    	int xCopy = x;
    	long reverse = 0;
    	while (xCopy > 0) {
    		reverse = reverse * 10 + xCopy % 10;
    		xCopy = xCopy / 10;
    	}
    	return x == reverse;
    }
}