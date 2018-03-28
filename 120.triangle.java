class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        List<Integer> row = new ArrayList<Integer>(triangle.get(0));
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> currRow = new ArrayList<Integer>(triangle.get(i));
            for (int j = 0; j < currRow.size(); j++) {
                if (j == 0) {
                    currRow.set(0, row.get(0) + currRow.get(j));
                } else if (j == currRow.size() - 1) {
                    currRow.set(j, row.get(j - 1) + currRow.get(j));
                } else {
                    currRow.set(j, Math.min(row.get(j - 1), row.get(j)) + currRow.get(j));
                }
            }
            row = currRow;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < row.size(); i++) {
            min = Math.min(min, row.get(i));
        }
        return min;
    }
}