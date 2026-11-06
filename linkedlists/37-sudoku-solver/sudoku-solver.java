class Solution {
    public void solveSudoku(char[][] board) {
        dfs(board, 0, 0);
    }

    private boolean dfs(char[][] board, int r, int c) {

        // STOP: All 9 rows completed
        if (r == 9) return true;

        // MOVE: Go to next row
        if (c == 9) return dfs(board, r + 1, 0);

        // CHECK: Skip already filled cells
        if (board[r][c] != '.') {
            return dfs(board, r, c + 1);
        }

        // TRY: Place digits 1 to 9
        for (char d = '1'; d <= '9'; d++) {

            // CHECK: Is placement valid?
            if (!valid(board, r, c, d)) continue;

            // UPDATE: Place digit
            board[r][c] = d;

            // MOVE: Explore next cell
            if (dfs(board, r, c + 1)) return true;

            // BACKTRACK: Undo placement
            board[r][c] = '.';
        }

        return false;
    }

    private boolean valid(char[][] board, int r, int c, char d) {

        for (int i = 0; i < 9; i++) {

            // CHECK: Same row and column
            if (board[r][i] == d || board[i][c] == d) {
                return false;
            }

            // CHECK: Same 3 × 3 box
            int boxRow = 3 * (r / 3) + i / 3;
            int boxCol = 3 * (c / 3) + i % 3;

            if (board[boxRow][boxCol] == d) {
                return false;
            }
        }

        return true;
    }
        
    }
