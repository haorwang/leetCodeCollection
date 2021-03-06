class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
    	Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
        	if(i > 0 && nums[i - 1] == nums[i]) continue;
        	int l = i + 1;
        	int r = nums.length - 1;
        	int expect = - nums[i];
        	while (l < r) {
        		if (nums[l] + nums[r] == expect) {
        			res.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{nums[i], nums[l], nums[r]})));
        			l++;
        			r--;
        		}
        		while (l < r && (nums[l] + nums[r] < expect || (l > i + 1 && nums[l] == nums[l - 1]))) {
        			l++;
        		}
        		while (l < r && (nums[l] + nums[r] > expect || (r < nums.length - 1 && nums[r] == nums[r + 1]))){
        			r--;
        		}
        	}
        }
        return res;
    }
}