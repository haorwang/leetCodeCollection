class Solution {
    public int longestValidParentheses(String s) {
    	int max = 0;
    	int[] dp = new int[s.length()]; //ind: last continues valid starting ind
    	
    	Deque<Integer> st = new LinkedList<>();
    	for (int i = 0; i < s.length(); i++) {
    		dp[i] = i;
    		if (s.charAt(i) == '(') {
    			st.push(i);
    			if(i > 0 && s.charAt(i - 1) == ')' && dp[i - 1] != i - 1) {
    				dp[i] = dp[i - 1];
    			}
    		} else if (!st.isEmpty()) { //char is ')'
    			dp[i] = dp[st.pop()];
        		max = Math.max(max, i - dp[i] + 1);
    		}
    	}
    	return max;
    }
}