
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
        	if (i > 0 && nums[i] == nums[i - 1]) continue;
        	for (int j = i + 1; j < nums.length; j++) {
        		if (j > i + 1 && nums[j] == nums[j - 1]) continue;
        		int l = j + 1;
        		int r = nums.length - 1;
        		while (l < r) {
        			if (nums[i] + nums[j] + nums[l] + nums[r] == target) {
        				res.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{nums[i], nums[j], nums[l], nums[r]})));
        				l++;
        				r--;
        			}
        			while (l < r && ((l > j + 1 && nums[l] == nums[l - 1]) || nums[i] + nums[j] + nums[l] + nums[r] < target)) {
        				l++;
        			}
        			while (l < r && ((r < nums.length - 1 && nums[r] == nums[r + 1]) || nums[i] + nums[j] + nums[l] + nums[r] > target)) {
        				r--;
        			}
        		}
        	}
        }
        return res;
    }
}