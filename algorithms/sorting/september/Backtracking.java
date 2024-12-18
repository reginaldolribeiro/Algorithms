package algorithms.sorting.september;

public class Backtracking {
    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];
        // populate
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        // printing...
        for (int i = 0; i < board.length; i++) {
            System.out.print("[");
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println("]");
        }
        backtracking(board, 1);
        System.out.println("*** AFTER ***");
        for (int i = 0; i < board.length; i++) {
            System.out.print("[");
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println("]");
        }
    }

    private static void backtracking(char[][] board, int n) {
        for (int i = 0; i < board.length; i++) {
            boolean isLineFilled = false;
            for (int j = 0; j < board.length; j++) {
                if(isSafe(board, i, j, n)){
                    board[i][j] = 'q';
                }
//                if(isSafe(board, i, j) && !isLineFilled){
//                    board[i][j] = 'q';
//                    isLineFilled = true;
//                }
            }
        }
    }

    private static boolean isSafe(char[][] board, int row, int column, int n) {
        // Is there a queen in that row?
        for (int i = 0; i < column; i++) {
            if(board[row][i] != '.')
                return false;
        }

        // Is there a queen in that column?
        for (int i = 0; i < row; i++) {
            if(board[i][column] != '.')
                return false;
        }

        // Is there a queen in a left diagonal?
        for (int i = row-1, j = column-1; i >=0 && j >= 0 ; i--, j--) {
            if(board[i][j] != '.')
                return false;

        }

        // Is there a queen in a right diagonal?
        for (int i = row-1, j = column+1; i >=0 && j < n; i--, j++) {
            if(board[i][j] != '.')
                return false;
        }

        return true;
    }

    private static boolean isSafe1(char[][] board, int row, int column) {
        if(column == 0  && row == 0){
            return board[row][column] == '.';
        } else if(column > 0){
            if(column == board.length-1){
                return board[row][column] == '.' && board[row][column-1] == '.';
            } else {
                return board[row][column] == '.' && board[row][column-1] == '.' && board[row][column+1] == '.';
            }
        } else if(row > 0) {
            int previousRow = row - 1;
            return board[row][column] == '.' && board[row-1][column] == '.' && board[row][column+1] == '.';
        } else {
            return board[row][column] == '.';
        }
    }
}
