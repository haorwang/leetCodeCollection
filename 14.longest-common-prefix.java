class Solution {
    public String longestCommonPrefix(String[] strs) {

    	String res = "";
    	
    	if (strs.length == 0 || strs[0].length() == 0) {
    		return res;
    		
    	}
    	
    	while (res.length() < strs[0].length()) {
    		res = res + strs[0].charAt(res.length());
    		for (int i = 0; i < strs.length; i++) {
    			if (strs[i].length() < res.length() ||
    					strs[i].charAt(res.length() - 1) != res.charAt(res.length() - 1)) {
    				return res.substring(0, res.length()-1);
    			}
    		}
    	}
    	
    	return res;
    }
}

