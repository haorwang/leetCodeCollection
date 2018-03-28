class Solution {
    public void solveSudoku(char[][] board) {
    	
    	boolean[][] rowB = new boolean [9][10];
    	boolean[][] colB = new boolean [9][10];
    	boolean[][] boxB = new boolean [9][10];
    	for (int i = 0; i < 9; i++) {
    		for (int j = 0; j < 9; j++) {
    			if (board[i][j] != '.') {
    				int box = i / 3 * 3 + j / 3;
    				int k = board[i][j] - '0';
    				rowB[i][k] = true;
    				colB[j][k] = true;
    				boxB[box][k] = true;
    			}
    			
    		}
    	}
    	dfs(board, rowB, colB, boxB);
    	
    }
    
    public boolean dfs(char[][] board, boolean[][] rowB, boolean[][] colB, boolean[][] boxB) {
    	for (int i = 0; i < 9; i++) {
    		for (int j = 0; j < 9; j++) {
    			
    			if (board[i][j] == '.') {

					int box = i / 3 * 3 + j / 3;
    				for (int k = 1; k <=9; k++) {
    					// check conflict
    					if (rowB[i][k] || colB[j][k] || boxB[box][k]) {
    						continue;
    					}
    					
    					// prefill k
    					board[i][j] = (char) (k + '0');
    					rowB[i][k] = true;
    					colB[j][k] = true;
    					boxB[box][k] = true;
    					
    					if(dfs(board, rowB, colB, boxB)) {
    						return true;
    					} else { // change this back
    						board[i][j] = '.';
        					rowB[i][k] = false;
        					colB[j][k] = false;
        					boxB[box][k] = false;
    					}
    				}
    				
    				return false;
    			}
    			
    		}
    	}
    	return true;
    }
    	
    	
}
