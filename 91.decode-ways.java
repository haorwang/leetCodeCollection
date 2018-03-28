class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.charAt(0) == '0') {
            return 0;
        }
        int last2 = 1;
        int last = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) > '2' || s.charAt(i - 1) == '0') {
                    return 0;
                }
                last = last2;
            } else if (s.charAt(i - 1) != '0' || Integer.valueOf(s.substring(i - 1, i + 1)) <= 26){
                int oldLast = last;
                last += last2;
                last2 = oldLast;
            } else {
                last2 = last;
            }
        }
        return last;
    }
}