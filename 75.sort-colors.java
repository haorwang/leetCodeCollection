class Solution {
    public void sortColors(int[] nums) {
        int i = 0;
        int l = 0;
        int r = nums.length - 1;
        while (i <= r) {
            if (nums[i] == 0) {
                swap(nums, i, l++);
                if (l > i) {
                    i = l;
                }
            } else if (nums[i] == 2) {
                swap(nums, i, r--);
            } else {
                i++;
            }
        }
    }

    public void swap (int[] nums, int a, int b) {
        int c = nums[a];
        nums[a] = nums[b];
        nums[b] = c;
    }

}