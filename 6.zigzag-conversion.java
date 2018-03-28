class Solution {
    public String convert(String s, int numRows) {
    	
    	if (s.length() == 0 || numRows == 1) {
    		return s;
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	
    	int numEle = numRows * 2 - 2;
    	int numCyc = s.length() / numEle;
    	
    	for (int i = 0; i < numRows; i++) {
    		for (int j = 0; j <= numCyc; j++) {
    			if (i == 0) {
    				if(j * numEle >= s.length()) {
    					break;
    				}
    				sb.append(s.charAt(j * numEle));
    			} else if (i == numRows - 1) {
    				if (j * numEle + i >= s.length()) {
    					break;
    				}
    				sb.append(s.charAt(j * numEle + i));
    			} else {
    				if (j * numEle + i >= s.length()) {
    					break;
    				}
    				sb.append(s.charAt(j * numEle + i));
    				if ((j + 1) * numEle - i >= s.length()) {
    					break;
    				}
    				sb.append(s.charAt((j + 1) * numEle - i));
    			} 
    		}
    	}
    	
    	return sb.toString();
    }
}