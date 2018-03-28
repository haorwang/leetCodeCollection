class Solution {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        while (n != 1) {
            set.add(n);
            n = next(n);
            if (set.contains(n)) {
                return false;
            }
        }
        return true;
    }

    public int next(int n) {
        int res = 0;
        while (n != 0) {
            int digit = n % 10;
            res += digit * digit;
            n /= 10;
        }
        return res;
    }
}
