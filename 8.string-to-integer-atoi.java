class Solution {
    public int myAtoi(String str) {
    	int i = 0;
    	int sign = 1;
    	long res = 0;
    	
    	//skip space in the front
    	while (i < str.length() && str.charAt(i) == ' ') {
    		i++;
    	}
    	
    	//check sign
    	if(i == str.length()){
    		return 0;
    	} else if (str.charAt(i) == '-') {
    		sign = -1;
    		i++;
    	} else if (str.charAt(i) == '+') {
    		i++;
    	}
    	
    	//get numbers
    	while (i < str.length() && Character.isDigit(str.charAt(i))) {
    		res = res * 10 + (str.charAt(i) - '0');
    		i++;
    		if (res * sign > Integer.MAX_VALUE) {
        		return Integer.MAX_VALUE;
        	}
        	if (res * sign < Integer.MIN_VALUE) {
        		return Integer.MIN_VALUE;
        	}
    	}
    	return (int) res * sign;
    }
}


    