/*
 * Tic Tac Win: Design an algorithm to figure out if someone has won a game of tic tac toe
 *
 * Assumptions: board can by NxN
 */

public class Pr4{
    public static void main(String[] args){
        String[][] board = {{"O", "O", "X"},
                          {"X", "X", "O"},
                          {"X", "X", "X"}};

        System.out.println(bruteForce(board));
                          

    }

    private static boolean bruteForce(String[][] board){
        //traverse through rows and cols
        if( checkRows(board) || checkCols(board))
            return true;

        // check diagonals
        return checkDiag(board);
    }

    private static boolean checkDiag(String[][] board){
        // top left-> bottom right
        int count = 0;
        for(int i = 0; i < board.length-1; i++){
            if(board[i][i] == board[i+1][i+1])
                count++;
            if(count == board.length-1)
                return true;
        }

        // top right --> bottom left
        count = 0;
        for(int i = 0; i < board.length-1; i++){
            if(board[i][board.length-1-i] == board[i+1][board.length-2-i])
                count++;
            if(count == board.length-1)
                return true;
        }
        return false;
    }

    private static boolean checkRows(String[][] board){
        int count = 0;
        for(String[] row : board){
            for(int i = 0; i < row.length-1; i++){
                if(row[i].equals(row[i+1]))
                    count++;
            }
            if(count == row.length-1)
                return true;
            count = 0;
        }
        return false;
    }

    private static boolean checkCols(String[][] board){
        int count = 0;
        for(int col = 0; col < board[0].length; col++){
            for(int row = 0; row < board.length-1; row++){
                if(board[row][col] == board[row+1][col])
                    count++;
            }
            if(count == board[0].length-1)
                return true;
            count = 0;
        }
        return false;
    }

}
