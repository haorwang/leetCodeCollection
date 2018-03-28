class Solution {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || word.length() == 0) {
            return false;
        }

        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (bt(board, visited, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean bt(char[][] board, boolean[][] visited, String word, int ind, int i, int j) {
        if (ind == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
                || visited[i][j] || board[i][j] != word.charAt(ind)) {
            return false;
        }
        visited[i][j] = true;
        boolean res = bt(board, visited, word, ind + 1, i - 1, j) ||
                bt(board, visited, word, ind + 1, i, j - 1) ||
                bt(board, visited, word, ind + 1, i + 1, j) ||
                bt(board, visited, word, ind + 1, i, j + 1);
        visited[i][j] = false;
        return res;

    }
}