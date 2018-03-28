class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Deque<String> q = new LinkedList<>();
        int len = 1;
        Set<String> set = new HashSet<>(wordList);
        if (beginWord.equals(endWord) && set.contains(beginWord)) {
            return len;
        }

        len ++;
        Set<String> reached = new HashSet<>();
        q.offer(beginWord);
        reached.add(beginWord);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                char[] currString = q.poll().toCharArray();

                for (char c = 'a'; c <= 'z'; c++) {
                    for (int j = 0; j < currString.length; j++) {
                        char oldChar = currString[j];
                        if(c == oldChar) {
                            continue;
                        }
                        currString[j] = c;
                        String newString = String.valueOf(currString);
                       //System.out.println(newString);
                        if (set.contains(newString) && !reached.contains(newString)) {
                            //System.out.println(newString);
                            if (endWord.equals(newString)) {
                                return len;
                            }
                            q.offer(newString);
                            reached.add(newString);
                        }
                        currString[j] = oldChar;
                    }
                }
            }
            len ++;
        }
        return 0;
    }
}