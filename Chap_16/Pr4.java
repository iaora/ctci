/*
 * Tic Tac Win: Design an algorithm to figure out if someone has won a game of tic tac toe
 *
 * Assumptions: board can by NxN
 */

public class Pr4{
    public static void main(String[] args){
        String[][] board = {{"X", "O", "X"},
                          {"X", "O", "O"},
                          {"X", "X", "O"}};

        System.out.println(bruteForce(board));
                          

    }

    private static boolean bruteForce(String[][] board){
        //traverse through rows
        if( checkRows(board))
            return true;

        // traverse through cols

        // check diagonals
        if(board[0][0].equals(board[1][1])
                && board[1][1].equals(board[2][2]))
            return true;
        if(board[0][2].equals(board[1][1])
                && board[1][1].equals(board[2][0]))
            return true;


        return false;

    }

    private boolean checkStraight(String[][] board){
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

    private boolean checkCols(String[][] board){
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
