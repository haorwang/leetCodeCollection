class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        res.add(firstRow);
        for (int i = 1; i < numRows; i++) {
            List<Integer> newRow = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                newRow.add(((j == 0) ? 0 : res.get(i - 1).get(j - 1))
                        + ((j == i) ? 0 : res.get(i - 1).get(j)));
            }
            res.add(newRow);
        }
        return res;
    }
}