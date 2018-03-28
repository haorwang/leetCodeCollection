
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
    	List<Integer> res = new ArrayList<>();
    	int wordLength = words[0].length();
    	int wordsCnt = words.length;
    	int windowLength = wordLength * wordsCnt;
    	
    	if (wordsCnt == 0 || wordLength == 0 || s.length() < wordLength) {
    		return res;
    	}
    	
    	Map<String, Integer> mapCnt = new HashMap<>(); //word: remainingCnt
    	
    	for (int i = 0; i < wordsCnt; i++) {
    		if (mapCnt.containsKey(words[i])) {
    			mapCnt.put(words[i], mapCnt.get(words[i]) + 1);
    		} else {
    			mapCnt.put(words[i], 1);
    		}
    	}
    	
    	for (int k = 0; k < wordLength; k++) {
    		int remainingCnt = wordsCnt;
    		Map<String, Integer> map = new HashMap<>(mapCnt);
	    	for (int j = k; j <= s.length() - wordLength; j += wordLength) {
	    		int i = j - windowLength;
		    	if (i >= 0) {
		    		String toRemove = s.substring(i, i + wordLength);
		    		if (map.containsKey(toRemove)) {
		    			map.put(toRemove, map.get(toRemove) + 1);
		    			if (map.get(toRemove) > 0) {
		    				remainingCnt++;
		    			}
		    		} 
		    	}
		    	String toAdd = s.substring(j, j + wordLength);
	    		if (map.containsKey(toAdd)) {
	    			map.put(toAdd, map.get(toAdd) - 1);
	    			if(map.get(toAdd) >= 0) {
	    				remainingCnt--;
	    			}
	    		}
	    		System.out.println();
	    		if (remainingCnt == 0) {
	    			res.add(i + wordLength);
	    		}
	    	}
    	}
    	return res;
    }
}
