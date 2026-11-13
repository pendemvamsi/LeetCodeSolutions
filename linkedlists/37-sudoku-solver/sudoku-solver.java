class Solution {
    public void solveSudoku(char[][] board) {
            solve(board);
    }

    private boolean solve(char[][] board) {
        // STOP + STATE: Find an empty cell
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') continue;

                // MOVE + CHECK: Try digits 1–9
                for (char num = '1'; num <= '9'; num++) {
                    if (!isValid(board, r, c, num)) continue;

                    // UPDATE: Choose
                    board[r][c] = num;

                    // EXPLORE
                    if (solve(board)) return true;

                    // UNDO
                    board[r][c] = '.';
                }

                return false;
            }
        }

        // STOP: No empty cells remain
        return true;
    }

    private boolean isValid(char[][] board, int r, int c, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[r][i] == num ||
                board[i][c] == num ||
                board[3 * (r / 3) + i / 3][3 * (c / 3) + i % 3] == num)
                return false;
        }

        return true;
    }
        
    }
