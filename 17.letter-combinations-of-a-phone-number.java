class Solution {
    public List<String> letterCombinations(String digits) {
        String[] pad = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        dfs(res, pad, digits, new StringBuilder(),  0);
        return res;
    }
    
    public void dfs(List<String> res, String[] pad, String digits, StringBuilder curr, int pos) {
    	if (pos == digits.length()) {
    		if(curr.length() != 0) {
    			res.add(curr.toString());
    		}
    		return;
    	} 
    	for (int i = 0; i < pad[digits.charAt(pos) - '0'].length(); i++) {
    		curr.append(pad[digits.charAt(pos) - '0'].charAt(i));
    		dfs(res, pad, digits, curr, pos+1);
    		curr.deleteCharAt(curr.length()-1);
    	}
    }
}