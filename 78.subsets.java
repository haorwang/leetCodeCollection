class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }

    public void dfs (List<List<Integer>> res, List<Integer> curr, int[] nums, int s) {
        res.add(new ArrayList<Integer>(curr));
        for (int i = s; i < nums.length; i++) {
            curr.add(nums[i]);
            dfs(res, curr, nums, i + 1);
            curr.remove(curr.size() - 1);
        }
    }

}