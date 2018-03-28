class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }

        Deque<Integer> st = new LinkedList<>();

        int max = 0;

        for (int i = 0; i <= heights.length; i++) {
            while (!st.isEmpty() && (i == heights.length || heights[i] <= heights[st.peek()])) {
                int ind = st.pop();
                int width =  i - 1 - ((st.isEmpty()) ? -1 : st.peek());
                int area = width * heights[ind];
                max = Math.max(max, area);
            }
            if (i != heights.length) {
                st.push(i);
            }
        }

        return max;
    }
}