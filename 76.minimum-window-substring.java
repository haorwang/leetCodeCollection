class Solution {
    public String minWindow(String s, String t) {

        String res = "";

        if (t.length() == 0) {
            return res;
        }

        int[] map = new int[256];

        //build map
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i) - '0']++;
        }

        int l = 0;
        int r = 0;
        int min = s.length();
        int remain = t.length();

        while (r < s.length()) {
            map[s.charAt(r) - '0']--;
            if (map[s.charAt(r) - '0'] >= 0 ) {
                remain--;
            }
            r++;
            while (remain == 0 && l < r) {
                map[s.charAt(l) - '0']++;
                if (map[s.charAt(l) - '0'] > 0) {
                    remain++;
                    if (r - l <= min) {
                        min = r - l;
                        res = s.substring(l, r);
                    }
                }
                l++;
            }

        }
        return res;
    }
}