class Solution {
    public int calculate(String s) {

        Deque<Boolean> st = new LinkedList<Boolean>();
        st.push(true);
        boolean lastSignPositive = true;
        int res = 0;
        int lastInd = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '(' || s.charAt(i) == ')') {

                int lastNumber = (sb.length() == 0) ? 0 : Integer.valueOf(sb.toString());

                //System.out.println("i: " + i + "st: " + st.peek() + " last: " + lastSignPositive);

                if ((st.peek() && lastSignPositive) || (!st.peek() && !lastSignPositive)) {
                    res += lastNumber;
                } else {
                    res -= lastNumber;
                }

                sb = new StringBuilder();
                if (s.charAt(i) == '+') {
                    lastSignPositive = true;
                } else if (s.charAt(i) == '-') {
                    lastSignPositive = false;
                } else if (s.charAt(i) == '(') {
                    st.push((st.peek() && lastSignPositive) || (!st.peek() && !lastSignPositive));
                    lastSignPositive = true;
                } else if (s.charAt(i) == ')') {
                    st.pop();
                }
            } else {
                sb.append(s.charAt(i));
            }
        }

        int lastNumber = (sb.length() == 0) ? 0 : Integer.valueOf(sb.toString());
        if ((st.peek() && lastSignPositive) || (!st.peek() && !lastSignPositive)) {
            res += lastNumber;
        } else {
            res -= lastNumber;
        }

        return res;
    }
}
