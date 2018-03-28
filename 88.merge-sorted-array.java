class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int leftInd = m + n - 1;
        int ind1 = m - 1;
        int ind2 = n - 1;
        while (ind2 >= 0) {
            if (ind1 < 0 || nums2[ind2] > nums1[ind1]) {
                nums1[leftInd--] = nums2[ind2--];
            } else {
                nums1[leftInd--] = nums1[ind1--];
            }
        }
    }
}