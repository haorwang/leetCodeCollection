class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<Integer>(), 1, n, k);
        return res;
    }
    public void dfs (List<List<Integer>> res, List<Integer> curr, int ind, int n, int k) {
        if (curr.size() == k) {
            res.add(new ArrayList<Integer>(curr));
            return;
        }
        for (int i = ind; i <= n; i++) {
            curr.add(i);
            dfs(res, curr,i + 1, n, k);
            curr.remove( curr.size() - 1);
        }
    }

}
