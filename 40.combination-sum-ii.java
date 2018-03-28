class Solution {
	
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(res, new ArrayList<Integer>(), candidates, 0, 0, target);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, List<Integer> curr, int[] cand, int pos, int sum, int target) {
    	if (sum == target) {
    		res.add(new ArrayList<Integer>(curr));
    		return;
    	}
    	if (pos == cand.length || sum > target) {
    		return;
    	}
    	for(int i = pos; i < cand.length; i++) {
    		if (i > 0 && cand[i] == cand[i - 1] && i!=pos) {
    			continue;
    		}
    		curr.add(cand[i]);
    		dfs(res, curr, cand, i + 1, sum + cand[i], target);
    		curr.remove(curr.size() - 1);
    	}
    }
    
}