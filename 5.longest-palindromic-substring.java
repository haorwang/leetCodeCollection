class Solution {
    public String longestPalindrome(String s) {
    	int max = Integer.MIN_VALUE;
    	int resLeft = 0;
    	int resRight = 0;
    	for (int i = 0; i < s.length(); i++){
    		//odd
    		int l = i;
    		int r = i;
    		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
    			l--;
    			r++;
    		}
    		l++;
    		if (r - l > max) {
    			max = r - l;
    			resLeft = l;
    			resRight = r;
    		}
    		
    		//even
    		l = i;
    		r = i+1;
    		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
    			l--;
    			r++;
    		}
    		l++;
    		if (r - l > max) {
    			max = r - l;
    			resLeft = l;
    			resRight = r;
    		}
    	}
    	return s.substring(resLeft, resRight);
    }
}