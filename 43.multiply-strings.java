class Solution {
    public String multiply(String num1, String num2) {
    	
    	if(num1.length() == 0 || num2.length() == 0) {
    		return "";
    	}
    	
    	if(num1.equals("0") || num2.equals("0")) {
    		return "0";
    	}
    	
    	int[] res = new int[num1.length() + num2.length()];
    	
    	for (int i = num1.length() - 1; i >= 0; i--) {
    		for (int j = num2.length() - 1; j >=0; j--) {
    			int multi = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
    			res[i + j + 1] += multi;
    		}
    	}
    	
    	int carry = 0;
    	
    	String ans = "";
    	for (int i = res.length - 1; i > 0; i--) {
    		ans = String.valueOf(res[i] % 10 ) + ans;
    		carry = res[i] / 10;
    		res[i - 1] += carry;
    	}
    	
    	if(carry != 0) {
    		return String.valueOf(carry) + ans;
    	} else {
    		return ans;
    	}
    	
    }
}
