class Solution {
    public boolean isValidSudoku(char[][] board) {
    	
        //check row
    	for (int i = 0; i < 9; i++) {
    		boolean[] rowB = new boolean[10];
    		for (int j = 0; j < 9; j++) {
    			if (board[i][j] == '.') {
    				continue;
    			} else if (rowB[board[i][j] - '0']) {
    				return false;
    			} else {
    				rowB[board[i][j] - '0'] = true;
    			}
    		}
    	}
    	
    	//check col
    	for (int j = 0; j < 9; j++) {
    		boolean[] colB = new boolean[10];
    		for (int i = 0; i < 9; i++) {
    			if (board[i][j] == '.') {
    				continue;
    			} else if (colB[board[i][j] - '0']) {
    				return false;
    			} else {
    				colB[board[i][j] - '0'] = true;
    			}
    		}
    	}
    	
    	//check sqrt
    	for (int i = 0; i < 9; i++) {
    		boolean[] box = new boolean[10];
    		for (int j = 0; j < 9; j++) {
    			int row = i / 3 * 3 + j / 3;
    			int col = i % 3 * 3 + j % 3;
    			if(board[row][col] == '.') {
    				continue;
    			} else if (box[board[row][col] - '0']) {
    				return false;
    			} else {
    				box[board[row][col] - '0'] = true;
    			} 
    		}
    	}
    	
    	return true;
    }
}