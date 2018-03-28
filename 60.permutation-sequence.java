class Solution {
    public String getPermutation(int n, int k) {
    	
    	StringBuilder sb = new StringBuilder();
    	List<String> list = new ArrayList<>();
    	int[] fac = new int[n + 1];
    	fac[0] = 1;
    	
    	//build fac
    	for (int i = 1, f = 1; i <= n; i++) {
    		f*=i;
    		fac[i] = f;
    	}
    	
    	// build list
    	for (int i = 1; i <= n; i++) {
    		list.add(String.valueOf(i));
    	}
    	
    	for (int i = n; i > 0; i--) {
    		int ind = (k -1) / fac[i - 1];
    		sb.append(list.get(ind));
    		list.remove(ind);
    		k -= fac[i - 1] * ind;
    		
    	}
    	return sb.toString();
    }
}