class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int a1 = (C - A) * (D - B);
        int a2 = (G - E) * (H - F);
        int overLap = 0;

        int maxLeft = Math.max(A, E);
        int minRight = Math.min(C, G);
        int maxBot = Math.max(B, F);
        int minTop = Math.min(D, H);
        if (maxLeft <= minRight && maxBot <= minTop) {
            overLap = (minRight - maxLeft) * (minTop - maxBot);
        }
        return a1 + a2 - overLap;
    }
}
