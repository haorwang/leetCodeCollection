class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int l = 1;
        int r = x;
        while (l <= r) {
            int m = (l + r) / 2;
            if (x / m == m) {
                return m;
            } else if (x / m > m) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return r;
    }
}