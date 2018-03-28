public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int x = n;
        int y = 0;
        for (int i = 0; i < 32; i++) {
            y = y << 1;
            y = y | (x & 1);
            x = x >> 1;
        }
        return y;
    }
}
