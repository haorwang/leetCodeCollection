class Solution {


    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }

        boolean[][] table = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) {
                    dfs(board, table, i, j);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!table[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }

    }

    public void dfs(char[][] board, boolean[][] table, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X' || table[i][j]) {
            return;
        }

        table[i][j] = true;

        dfs(board, table, i - 1, j);
        dfs(board, table, i, j - 1);
        dfs(board, table, i + 1, j);
        dfs(board, table, i, j + 1);
    }
}