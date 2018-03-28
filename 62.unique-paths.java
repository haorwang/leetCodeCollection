class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
        	return 0;
        }
        
        int[] hoz = new int[n]; 
        
        for (int j = 0; j < n; j++) {
        	hoz[j] = 1;
        }
        
        for (int i = 1; i < m; i++) {
        	for (int j = 1; j < n; j++) {
        		hoz[j] = hoz[j - 1] + hoz[j];
        	}
        }
        return hoz[n - 1];
    }
}