class Solution {
    public int climbStairs(int n) {

        int last = 1;
        int curr = 1;

        for (int i = 1; i < n; i++) {
            int oldCurr= curr;
            curr += last;
            last = oldCurr;
        }
        return curr;
    }

}