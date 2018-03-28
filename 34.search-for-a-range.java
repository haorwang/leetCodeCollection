class Solution {
    public int[] searchRange(int[] nums, int target) {
    	int[] res = new int[2];
    	Arrays.fill(res, -1);
    	
        int ls = 0;
        int rs = nums.length - 1;
        while (ls <= rs) {
        	int ms = (ls + rs) / 2;
        	if ((ms == 0 || nums[ms - 1] != target) && nums[ms] == target) {
        		res[0] = ms;
        		break;
        	} else if (nums[ms] >= target) {
        		rs = ms - 1;
        	} else {
        		ls = ms + 1;
        	}
        }
        
        int le = 0;
        int re = nums.length - 1;
        while (le <= re) {
        	int me = (le + re) / 2;
        	if ((me == nums.length - 1 || nums[me + 1] != target) && nums[me] == target) {
        		res[1] = me;
        		break;
        	} else if (nums[me] <= target) {
        		le = me + 1;
        	} else {
        		re = me - 1;
        	}
        }
        return res;
    }
}