class Solution {
	/*
	 * fabulous solution	
	 * 
	 * bool dp[i, j]:
	 * 	i: ind for s: [0, s.length()]
	 * 	j: ind for p: [0, p.length()]
	 *
	 * dp[i, j]: s.substring(0, i) matches p.substring(0, j)
	 *
	 *	dp[0, 0] = true;
	 *	init row i = 0;
	 *	init col j = 0; 
	 *
	 *	for i: [1, s.length()]
	 *		for j: [1, p.length()]
	 *		
	 *
	 * 		if p.charAt(j-1) = '.';
	 *  		dp[i, j] = dp[i-1, j-1]
	 * 		else if p.charAt(j-1) = '*'
	 *  		if(p.charAt(i-1) == s.charAt(j-2) || p.charAt(j-1)=='.')
	 *  			dp[i, j] = dp[i, j-1] || dp[i, j-2] || dp[i-1, j]
	 *  		else
	 *  			dp[i, j] = dp[i, j-2]
	 * 		else if p.charAt(j-1) == s.charAt(i-1)
	 * 			dp[i, j] = dp[i-1, j-1]
	 * 		else
	 * 			dp[i, j] = false;
	 *  
	 * 
	 */
    public boolean isMatch(String s, String p) {
    	
    	boolean[][] dp = new boolean[s.length()+1][p.length()+1];
    	
    	//init
    	dp[0][0] = true;
    	
    	for (int j = 2; j <= p.length(); j++) {
    		if (p.charAt(j - 1) == '*') {
    			dp[0][j] = dp[0][j-2];
    		}
    	}
    	
    	for (int i = 1; i <= s.length(); i++) {
    		for (int j = 1; j <= p.length(); j++) {
    			
    			if (p.charAt(j - 1) == '.') {
    				dp[i][j] = dp[i - 1][j - 1];
    			} else if (p.charAt(j - 1) == '*') {
    				if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
    					dp[i][j] = dp[i][j - 1] 
    							|| dp[i][j - 2]
    							|| dp[i - 1][j];
    				} else {
    					dp[i][j] = dp[i][j - 2];
    				}
    			} else if (s.charAt(i - 1) == p.charAt(j - 1)) {
    				dp[i][j] = dp[i - 1][j - 1];
    			} //else default dp[i][j] =false 
    		}
    	}
    	
    	return dp[s.length()][p.length()];
    }
    
}