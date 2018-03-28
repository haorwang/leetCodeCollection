class Solution {
    public void reverseWords(char[] str) {
        reverse(str, 0, str.length - 1);
        int last = 0;
        for (int i = 0; i <= str.length; i++) {
            if (i == str.length || str[i] == ' ') {
                reverse(str, last, i - 1);
                last = i + 1;
            }
        }

    }

    public void reverse(char[] str, int i, int j) {
        while (i < j) {
            char c = str[i];
            str[i] = str[j];
            str[j] = c;
            i++;
            j--;
        }
    }
}
