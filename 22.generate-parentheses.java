class Solution {
    public List<String> generateParenthesis(int n) {
    	List<String> res = new ArrayList<>();
    	dfs(res, new StringBuilder(), n, 0, 0);
    	return res;
    }
    
    public void dfs(List<String> res, StringBuilder curr, int pair, int left, int right) {
    	if (pair == left && pair == right) {
    		res.add(curr.toString());
    		return;
    	}
    	if (left == pair) {
    		dfs(res, curr.append(')'), pair, left, right + 1);
        	curr.deleteCharAt(curr.length() - 1);
    		return;
    	}
    	if (left == right) {
    		dfs(res, curr.append('('), pair, left + 1, right);
        	curr.deleteCharAt(curr.length() - 1);
    		return;
    	}
    	dfs(res, curr.append('('), pair, left + 1, right);
    	curr.deleteCharAt(curr.length() - 1);
    	dfs(res, curr.append(')'), pair, left, right + 1);
    	curr.deleteCharAt(curr.length() - 1);
    }
}