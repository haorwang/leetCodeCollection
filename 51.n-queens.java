class Solution {
    public List<List<String>> solveNQueens(int n) {
    	List<List<String>> res = new ArrayList<>();
    	boolean[][] board= new boolean[n][n];
    	
    	
    	boolean[] hzt = new boolean[n];
    	boolean[] dig1 = new boolean[n + n -1];
    	boolean[] dig2 = new boolean[n + n -1];
    	
    	dfs(res, board, hzt, dig1, dig2, 0);
    	return res;
    }
    
    public void dfs(List<List<String>> res, boolean[][] board, boolean[] hzt, boolean[] dig1, boolean[] dig2, int j) {
    	
    	if(j == board.length) {
    		build(res, board);
    	}
    	
    	for (int i = 0; i < board.length; i++) {
    		int d1 = board.length -1 -i + j;
    		int d2 = i + j;
    		
    		if (hzt[i] || dig1[d1] || dig2[d2]) {
    			continue;
    		}
    		
    		//put queen
    		board[i][j] = true;
    		hzt[i] = true;
    		dig1[d1] = true;
    		dig2[d2] = true;
    		
    		dfs(res, board, hzt, dig1, dig2, j + 1);
    		
    		board[i][j] = false;
    		hzt[i] = false;
    		dig1[d1] = false;
    		dig2[d2] = false;
    	}
    }
    
    public void build(List<List<String>> res, boolean[][] board) {
    	List<String> instant = new ArrayList<>();
    	for (int i = 0; i < board.length; i++) {
    		String item = "";
    		for (int j = 0; j < board.length; j++) {
    			if(board[i][j]) {
    				item += "Q";
    			} else {
    				item += ".";
    			}
    		}
    		instant.add(item);
    	}
    	res.add(instant);
    }
}