class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        bt (res, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return res;
    }
    
    public void bt (List<List<Integer>> res, List<Integer> curr, int[] nums, boolean[] used) {
    	if (curr.size() == nums.length) {
    		res.add(new ArrayList<Integer>(curr));
    		return;
    	}
    	for (int i = 0; i < nums.length; i++) {
    		if (used[i] || (i > 0 && !used[i - 1] && nums[i] == nums[i - 1])) {
    			continue;
    		}
    		used[i] = true;
    		curr.add(nums[i]);
    		bt(res, curr, nums, used);
    		used[i] = false;
    		curr.remove(curr.size() - 1);
    	}
    }
    
}