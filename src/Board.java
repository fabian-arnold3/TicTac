import java.util.Scanner;

public class Board {
    private boolean player1Move = true;

    char[][] board = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};;



    public void printBoard() {
        System.out.println("  "+board[0][0]+"  |  "+board[0][1]+"  |  "+board[0][2]+"  \n-----|-----|-----\n  "+board[1][0]+"  |  "+board[1][1]+"  |  "+board[1][2]+"  \n-----|-----|-----\n  "+board[2][0]+"  |  "+board[2][1]+"  |  "+board[2][2]+"  ");
    }

    public boolean isFinished() {
        boolean finished = true;
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 2; i++) {
                if (board[i][j] != board[i+1][j] || board[i][j] != ' ' || board[i][j+1] != ' ') {
                    finished = false;
                }
            }
        }
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 2; i++) {
                if (board[j][i] != board[j][i+1] || board[j][i] != ' ' || board[j][i+1] != ' ') {
                    finished = false;
                }
            }
        }

        if(board[0][0] != board[1][1] || board[1][1] != board[2][2] || board[0][0] == ' ' || board[1][1] == ' ' || board[2][2] == ' ') {
            finished = false;
        }

        if(board[0][2] != board[1][1] || board[1][1] != board[2][0] || board[0][2] == ' ' || board[1][1] == ' ' || board[2][0] == ' ') {
            finished = false;
        }
        for(int i=0; i < 3; i++) {
            for(int j=0; j < 3;j++) {
                if(board[i][j] == ' ') {
                    finished = false;
                }
            }
        }

        return finished;
    }

    public void promptMove() {
        Scanner input = new Scanner(System.in);
        int x;
        int y;
        Boolean validMove = false;

        if(player1Move) {
            System.out.println("Player1 please make a move");
        } else {
            System.out.println("Player2 please make a move");
        }

        while(!validMove) {
            boolean validX = false;
            do {
                System.out.println("Please input the row");
                x = input.nextInt();
                if(x == 1 || x == 2 || x == 3) {
                    validX = true;
                }
            } while(!validX);

            boolean validY = false;
            do {
                System.out.println("Please input the column");
                y = input.nextInt();
                if (y == 1 || y == 2 || y == 3) {
                    validY = true;
                }
            } while(!validY);

            if(board[x-1][y-1] == ' ') {
                validMove = true;
                System.out.println("Valid Move");
                if(player1Move) {
                    board[x-1][y-1] = 'X';
                } else {
                    board[x-1][y-1] = 'O';
                }
                player1Move = !player1Move;
                printBoard();
            }
        }
    }
}
