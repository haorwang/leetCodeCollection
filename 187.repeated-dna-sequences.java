class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        Set<String> res =new HashSet<>();
        for (int i = 10; i <= s.length(); i++) {
            String subString = s.substring(i - 10, i);
            if (set.contains(subString)) {
                res.add(subString);
            } else {
                set.add(subString);
            }
        }
        return new ArrayList<String>(res);
    }
}
