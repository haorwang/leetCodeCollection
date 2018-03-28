class WordDictionary {

    private class TrieNode {
        public char c = '\u0000';
        public Map<Character, TrieNode> children = new HashMap<>();
        boolean exist = false;

        public TrieNode(char c) {
            this.c = c;
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode('\u0000');
        root.exist = true;
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (!curr.children.containsKey(word.charAt(i))) {
                curr.children.put(word.charAt(i), new TrieNode(word.charAt(i)));
            }
            curr = curr.children.get(word.charAt(i));
        }
        curr.exist = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(root, word, 0);
    }

    private boolean search(TrieNode node, String word, int ind) {
        if (ind == word.length()) {
            return node.exist;
        }

        if (word.charAt(ind) == '.') {
            for (char child : node.children.keySet()) {
                if (search(node.children.get(child), word, ind + 1)) {
                    return true;
                }
            }
            return false;
        }

        if (node.children.containsKey(word.charAt(ind))) {
            return search(node.children.get(word.charAt(ind)), word, ind + 1);
        } else {
            return false;
        }
    }

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
