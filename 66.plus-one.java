
class Solution {
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        while(i >= 0 && digits[i] == 9) {
            digits[i--] = 0;
        }
        int[] res;
        if (i == -1) {
            res = new int[digits.length + 1];
            res[0] = 1;
        } else {
            res = new int[digits.length];
            for (int j = 0; j < digits.length; j++) {
                res[j] =  digits[j];
            }
            res[i]++;
        }
        return res;
    }
}