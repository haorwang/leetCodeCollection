class Solution {
    public boolean isValid(String s) {
        Deque<Character> st = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
        	switch (s.charAt(i)){
        		case '(': 
        			st.push('(');
        			break;
        		case '[': 
        			st.push('[');
        			break;
        		case '{': 
        			st.push('{');
        			break;
        		case ')':
        			if (st.size()!=0 && st.peek() == '(') {
        				st.pop();
        			} else {
        				return false;
        			}
        			break;
        		case ']':
        			if (st.size()!=0 && st.peek() == '[') {
        				st.pop();
        			} else {
        				return false;
        			}
        			break;
        		case '}':
        			if (st.size()!=0 && st.peek() == '{') {
        				st.pop();
        			} else {
        				return false;
        			}
        			break;
        		default:
        			return false;
        	}

        }
        System.out.println(st.size());
        return st.size() == 0;
    }
}

