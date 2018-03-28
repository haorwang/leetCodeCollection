class Solution {
    public int totalNQueens(int n) {
        boolean[] hoz = new boolean[n];
        boolean[] dig1 = new boolean[n + n - 1];
        boolean[] dig2 = new boolean[n + n - 1];
        return dfs(hoz, dig1, dig2, 0);
    }
    public int dfs (boolean[] hoz, boolean[] dig1, boolean[] dig2, int j) {
    	if (j == hoz.length) {
    		return 1;
    	}
    	int res = 0;
    	for (int i = 0; i < hoz.length; i++) {
    		int d1 = hoz.length - 1 - i + j;
    		int d2 = i + j;
    		if (hoz[i] || dig1[d1] || dig2[d2]) {
    			continue;
    		}
    		hoz[i] = true;
    		dig1[d1] = true;
    		dig2[d2] = true;
    		res += dfs(hoz, dig1, dig2, j + 1);
    		hoz[i] = false;
    		dig1[d1] = false;
    		dig2[d2] = false;
    	}
    	return res;
    }
}