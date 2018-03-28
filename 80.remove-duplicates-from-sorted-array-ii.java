class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        int cnt = 0;
        int last = nums[0] - 1;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != last) { //new elem
                nums[i++] = nums[j];
                cnt = 1;
            } else if (cnt < 2) { //repeat cnt < 2
                nums[i++] = nums[j];
                cnt++;
            } //cnt >=2
            last = nums[j];
        }
        return i;
    }
}