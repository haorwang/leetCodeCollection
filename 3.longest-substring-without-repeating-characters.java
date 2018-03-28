import java.util.Map;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
    	
    	int max = 0;
    	Set<Character> set = new HashSet<>();
    	for(int i=0, j=0; j<s.length(); j++){
    		while(set.contains(s.charAt(j))) 
    			set.remove(s.charAt(i++));
    		set.add(s.charAt(j));
    		max = Math.max(max, set.size());
    	}
    	return max;
    }
}