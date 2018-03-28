class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), candidates, 0, 0, target);
        return res;
    }
    
    public void dfs (List<List<Integer>> res, List<Integer> curr, int[] cand, int pos, int sum, int target) {
    	
    	if (sum == target) {
    		res.add(new ArrayList<Integer>(curr));
    		return;
    	}
    	if(pos == cand.length || sum > target) {
    		return;
    	}
    	
    	for(int i = pos; i < cand.length; i++) {
    		curr.add(cand[i]);
    		dfs(res, curr, cand, i, sum + cand[i], target);
    		curr.remove(curr.size() - 1);
    	}
    }
    
}