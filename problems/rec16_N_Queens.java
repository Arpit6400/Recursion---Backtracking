import java.util.*;

public class rec16_N_Queens {
    // public List<List<String>> solveNQueens(int n) {
    //     List<List<String>> ans = new ArrayList<>();
    //     String[][] board = new String[n][n];
    //     solve(0, board, ans, n);
    //     return ans;
    // }
    // private void solve(int col, String[][] board, List<List<String>> ans, int n) {
    //     if(col == n){
    //         List<String> temp = new ArrayList<>();
    //         for(int row = 0;row<n;row++){
    //             temp.add(board[row][col]);
    //         }
    //         ans.add(new ArrayList<>(temp));
    //         return;
    //     }
    //     for(int row = 0 ; row < n; row++){
    //         if (isSafe1(row, col, board, n)) {
    //             board[row][col]= "Q";
    //             solve(col+1, board, ans, n);
    //             board[row][col] = ".";
    //         }
    //     }
    // }
    // private boolean isSafe1(int row, int col, String[][] board, int n) {
    //     int dupliCol =  col;
    //     int dupliRow = row;
    //     // left-up check
    //     while (row > 0 && col > 0) {
    //         if (board[row][col].equals("Q")) {
    //             return false;
    //         }
    //         row--;col--;
    //     }
    //     row = dupliRow; col = dupliCol;
    //     // left check
    //     while (col > 0) {
    //         if (board[row][col].equals("Q")) {
    //             return false;
    //         }
    //         col--;
    //     }
    //     col = dupliCol;
    //     // left-down check
    //     while (row < n && col>0) {
    //         if (board[row][col].equals("Q")) {
    //             return false;
    //         }
    //         row++;col--;
    //     }
    //     // else true
    //     return true;
    // }

    // Optimal 

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();

        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        boolean[] leftRow = new boolean[n];
        boolean[] lowerDiagonal = new boolean[2 * n - 1];
        boolean[] upperDiagonal = new boolean[2 * n - 1];

        solve(0, board, ans, leftRow, lowerDiagonal, upperDiagonal, n);

        return ans;
    }

    private void solve(int col,
                       char[][] board,
                       List<List<String>> ans,
                       boolean[] leftRow,
                       boolean[] lowerDiagonal,
                       boolean[] upperDiagonal,
                       int n) {

        if (col == n) {
            List<String> temp = new ArrayList<>();
            for (char[] row : board) {
                temp.add(new String(row));
            }
            ans.add(temp);
            return;
        }

        for (int row = 0; row < n; row++) {

            if (!leftRow[row]
                    && !lowerDiagonal[row + col]
                    && !upperDiagonal[n - 1 + col - row]) {

                board[row][col] = 'Q';

                leftRow[row] = true;
                lowerDiagonal[row + col] = true;
                upperDiagonal[n - 1 + col - row] = true;

                solve(col + 1, board, ans,
                      leftRow, lowerDiagonal, upperDiagonal, n);

                board[row][col] = '.';

                leftRow[row] = false;
                lowerDiagonal[row + col] = false;
                upperDiagonal[n - 1 + col - row] = false;
            }
        }
    }
    public static void main(String[] args) {
        
    }
}
