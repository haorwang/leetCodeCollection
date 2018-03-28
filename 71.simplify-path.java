class Solution {
    public String simplifyPath(String path) {
        String[] names = path.split("/");
        Deque<String> st = new LinkedList<>();
        for (String name : names) {
            if (name.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else if (!name.equals(".") && name.length()!=0) {
                st.push(name);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String item : st) {
            sb.insert(0, item);
            sb.insert(0, "/");
        }
        return (sb.length() == 0) ? "/" : sb.toString();
    }
}