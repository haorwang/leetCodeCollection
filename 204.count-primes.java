class Solution {
    public int countPrimes(int n) {
    	if (n <= 2) {
    		return 0;
		}
		int cnt = 0;
		boolean[] a = new boolean[n];
		a[1] = true;
		for (int i = 1; i <n; i++) {
			if (!a[i]) {
				cnt++;
			}
			for (int j = 1; j <= i && i * j < n; j++) {
				a[i * j] = true;
			}
		}
		return cnt;
    }
}
