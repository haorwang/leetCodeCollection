class Solution {
    public String countAndSay(int n) {
    	String res = "1";
    	for (int i = 1; i < n; i++) {
    		String newRes = "";
    		char last = res.charAt(0);
    		int cnt = 1;
    		for (int j = 1; j < res.length(); j++) {
    			char curr = res.charAt(j);
    			if (curr == last) {
    				cnt++;
    			} else {
    				newRes += String.valueOf(cnt) + last;
    				last = curr;
    				cnt = 1;
    			}
    		}
    		newRes += String.valueOf(cnt) + last;
    		res = newRes;
    	}
    	return res;
    }
}