class Solution {
    public int lengthOfLastWord(String s) {
    	String[] res = s.split(" ");
    	if (res.length == 0) {
    		return 0;
    	}
    	return res[res.length - 1].length();
    }
}