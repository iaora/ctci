/*
 * Tic Tac Win: Design an algorithm to figure out if someone has won a game of tic tac toe
 */

public class Pr4{
    public static void main(String[] args){
        String[][] board = {{"X", "O", "X"},
                          {"O", "X", "O"},
                          {"O", "X", "O"}};

        System.out.println(bruteForce(board));
                          

    }

    private static boolean bruteForce(String[][] board){
        //traverse through rows
        for(String[] row : board){
            if(row[0].equals(row[1]) && row[1].equals(row[2]))
                return true;
        }

        // traverse through cols
        for (int i = 0; i < 3; i++){
            if(board[0][i].equals(board[1][i])
                    && board[1][i].equals(board[2][i]))
                return true;
        }

        // check diagonals
        if(board[0][0].equals(board[1][1])
                && board[1][1].equals(board[2][2]))
            return true;
        if(board[0][2].equals(board[1][1])
                && board[1][1].equals(board[2][0]))
            return true;


        return false;

    }

}
