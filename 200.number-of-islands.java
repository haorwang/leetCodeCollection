class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        if (row == 0) {
            return 0;
        }

        int col = grid[0].length;
        int[] p = new int[row * col];
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] != '0') {
                    if (i > 0 && grid[i - 1][j] != '0') {
                        union(p, i * col + j, (i - 1) * col + j);
                    }
                    if (j > 0 && grid[i][j - 1] != '0') {
                        union(p, i * col + j, i * col + j - 1);
                    }
                    if (i < grid.length - 1 && grid[i + 1][j] != '0') {
                        union(p, i * col + j, (i + 1) * col + j);
                    }
                    if (j < grid[0].length - 1 && grid[i][j + 1] != '0') {
                        union(p, i * col + j, i * col + j + 1);
                    }
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    set.add(findRoot(p, i * col + j));
                }
            }
        }
        return set.size();

    }

    public int findRoot(int[] p, int i) {
        while (p[i] != i) {
            p[i] = p[p[i]];
            i = p[i];
        }
        return i;
    }

    public void union(int[] p, int i, int j) {
        int root1 = findRoot(p, i);
        int root2 = findRoot(p, j);
        if (root1 == root2) {
            return;
        }
        p[root1] = root2;
    }
}
