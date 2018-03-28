class Trie {

    private class TrieNode {
        private char c;
        private Map<Character, TrieNode> children;
        private boolean existence;

        public TrieNode (char c) {
            this.c = c;
            children = new HashMap<>();
            existence = false;
        }

        public void addChild (char c) {
            children.put(c, new TrieNode(c));
        }

        public Map<Character, TrieNode> getChildren() {
            return children;
        }

        public TrieNode getChild(char c) {
            return children.get(c);
        }

        public void setTrue() {
            existence = true;
        }

        public void setFalse() {
            existence = false;
        }

        public boolean getExistence() {
            return existence;
        }
    }


    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode('\u0000');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (!curr.getChildren().containsKey(word.charAt(i))) {
                curr.addChild(word.charAt(i));
            }
            curr = curr.getChild(word.charAt(i));
        }
        curr.setTrue();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (curr.getChildren().containsKey(word.charAt(i))) {
                curr = curr.getChild(word.charAt(i));
            } else {
                return false;
            }
        }
        return curr.getExistence();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (curr.getChildren().containsKey(prefix.charAt(i))) {
                curr = curr.getChild(prefix.charAt(i));
            } else {
                return false;
            }
        }
        return dfs(curr);
    }

    private boolean dfs(TrieNode curr) {
        if (curr.getExistence()) {
            return true;
        }

        if (curr.getChildren().size() == 0) {
            return false;
        }

        for (char c : curr.getChildren().keySet()) {
            if (dfs(curr.getChild(c))) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
