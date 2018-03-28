class Solution {
    public static String addBinary(String a, String b) {
        if (a.length() == 0) {
            return b;
        }
        if (b.length() == 0) {
            return a;
        }

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int longerLen = Math.max(a.length(), b.length());
        for (int i = 0; i < longerLen; i++) {
            int indA = a.length() - 1 - i;
            int indB = b.length() - 1 - i;
            int curr = carry;
            if (indA >= 0) {
                curr += a.charAt(indA) - '0';
            }
            if (indB >= 0) {
                curr += b.charAt(indB) - '0';
            }
            sb.insert(0, String.valueOf(curr % 2));
            carry = curr / 2;
        }

        if (carry == 1) {
            sb.insert(0, "1");
        }
        return sb.toString();
    }
}