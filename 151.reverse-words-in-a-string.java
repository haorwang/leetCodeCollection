public class Solution {
    public String reverseWords(String s) { 
		
		char[] ca = s.trim().toCharArray();
		
		//step1: reverse the whole input
		reverseRange(ca, 0, ca.length - 1);

		//step2: reverse individual words
		int wordStartInd = 0;
		for (int i = 0; i < ca.length; i++) {
			if (i > 0 && ca[i - 1] == ' ' && ca[i] != ' ') { //find new start of word
				wordStartInd = i;	
			}
			if ((i == ca.length - 1 && ca[i] != ' ') 
				|| (i != ca.length - 1 && ca[i + 1] == ' ' && ca[i] != ' ')) { //end of a word 
				reverseRange(ca, wordStartInd, i);
			}
		}

		//step3: remove all spaces
		int buildInd = 0;
		for (int i = 0; i < ca.length; i++) {
			if (ca[i] != ' ' || (i > 0 && ca[i] == ' ' && ca[i - 1] != ' ')) {
				ca[buildInd++] = ca[i]; 
			}
		}

		return String.valueOf(ca).substring(0, buildInd);		
    }

	public void reverseRange(char[] ca, int i, int j) {
		while (i < j) {
			char cup = ca[i];
			ca[i] = ca[j];
			ca[j] = cup;
			i++;
			j--;
		}		
	}
}
