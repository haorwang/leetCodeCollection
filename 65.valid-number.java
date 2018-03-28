class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0) return false;

        // take care of sign before e;
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            s = s.substring(1);
        }

        boolean foundNum = false;
        boolean foundPeriod = false;
        boolean foundE = false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) ==  'e') {
                if (foundE) {
                    return false;
                } else if (!foundNum){
                    return false;
                } else {
                    foundE = true;
                    foundNum = false;
                    // take care of sign after e
                    if (i + 1 < s.length() && (s.charAt(i + 1) == '+' || s.charAt(i + 1) == '-')){
                        i++;
                    }
                }
            } else if (s.charAt(i) == '.'){
                if (foundPeriod || foundE) {
                    return false;
                } else {
                    foundPeriod = true;
                }
            } else if (s.charAt(i) < '0'  || s.charAt(i) > '9') {
                return false;
            } else {
                foundNum = true;
            }
        }
        return foundNum;

    }
}