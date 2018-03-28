class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            char lc = s.charAt(l);
            char lr = s.charAt(r);

            if (!(lc >= 'a' && lc <= 'z') && !(lc >= 'A' && lc <= 'Z') && !Character.isDigit(lc)) {
                l++;
                continue;
            }

            if (!(lr >= 'a' && lr <= 'z') && !(lr >= 'A' && lr <= 'Z') && !Character.isDigit(lr)) {
                r--;
                continue;
            }

            if (Character.toLowerCase(lc) == Character.toLowerCase(lr)) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }

}