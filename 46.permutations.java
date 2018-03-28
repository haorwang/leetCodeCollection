class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> left = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
        	left.add(nums[i]);
        }
        bt(res, new ArrayList<Integer>(), left);
        return res;
        
    }
    public void bt (List<List<Integer>> res, List<Integer> curr, Set<Integer> left) {
    	if (left.isEmpty()) {
    		res.add(new ArrayList<Integer>(curr));
    		return;
    	}
    	Set<Integer> leftCopy = new HashSet<Integer>(left);
    	for (Integer item : leftCopy) {
    		left.remove(item);
    		curr.add(item);
    		bt(res, curr, left);
    		curr.remove(curr.size() - 1);
    		left.add(item);
    	}
    }
}
