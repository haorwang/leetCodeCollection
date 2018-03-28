class Solution {
	
	private String[] ones = new String[]{"I", "X", "C", "M"};
	private String[] fives = new String[]{"V", "L", "D"};
	
	
    public String intToRoman(int num) {
    	int digit = 0;
    	String res = "";
    	while (num > 0) {
    		int left = num % 10;
    		if (left <=3){
    			res = mapper(digit, left) + res;
    		} else if(left <=5) {
    			res = fives[digit] + res;
    			res = mapper(digit, 5-left) + res;
    		} else if(left <=8) {
    			res = mapper(digit, left-5) + res;
    			res = fives[digit] + res;
    		} else {
    			res = ones[digit+1] + res;
    			res = mapper(digit, 10-left) + res;
    		}
    		num = num / 10;
    		digit++;
    	}
    	return res;
    }
    
    public String mapper(int digit, int num) {
    	String res = "";
    	for (int i = 0; i < num; i++) {
    		res = res + ones[digit];
    	} 
    	return res;
    }
}

