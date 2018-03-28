class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
        	char[] ca = strs[i].toCharArray();
        	Arrays.sort(ca);
        	String cas = String.valueOf(ca);
        	if (map.containsKey(cas)) {
        		map.get(cas).add(strs[i]);
        	} else {
        		List<String> item = new ArrayList<>();
        		res.add(item);
        		item.add(strs[i]);
        		map.put(cas, item);
        	}
        }
        return res;
    }
}
