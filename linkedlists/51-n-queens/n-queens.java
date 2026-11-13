class Solution {
    List<List<String>> result = new ArrayList<>();
    char[][] board;
    boolean[] col, d1, d2;
    int n;
    public List<List<String>> solveNQueens(int n) {
         this.n = n;
        board = new char[n][n];
        col = new boolean[n];
        d1 = new boolean[2 * n - 1];
        d2 = new boolean[2 * n - 1];

        for (char[] row : board)
            Arrays.fill(row, '.');

        dfs(0);
        return result;
    }

    private void dfs(int r) {
        // STOP
        if (r == n) {
            saveBoard();
            return;
        }

        // MOVE
        for (int c = 0; c < n; c++) {

            // CHECK
            int x = r - c + n - 1;
            int y = r + c;

            if (col[c] || d1[x] || d2[y])
                continue;

            // UPDATE
            board[r][c] = 'Q';
            col[c] = d1[x] = d2[y] = true;

            // EXPLORE
            dfs(r + 1);

            // UNDO
            board[r][c] = '.';
            col[c] = d1[x] = d2[y] = false;
        }
    }

    private void saveBoard() {
        List<String> solution = new ArrayList<>();

        for (char[] row : board)
            solution.add(new String(row));

        result.add(solution);
    }
         
        
    }
