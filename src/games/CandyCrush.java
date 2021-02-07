package games;

public class CandyCrush {

    public static int[][] candyCrush(int[][] board) {



        int R = board.length;
        int C = board[0].length;
        boolean isValid = false;

        //first spin
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c + 2 < C; ++c) {
                int v = Math.abs(board[r][c]);
                if (v != 0 && v == Math.abs(board[r][c+1]) && v == Math.abs(board[r][c+2])) {
                    board[r][c] = board[r][c+1] = board[r][c+2] = -v;
                    isValid = true;
                }
            }
        }


        for (int r = 0; r + 2< R; ++r) {
            for (int c = 0; c < C; ++c) {
                int v = Math.abs(board[r][c]);
                if (v != 0 && v == Math.abs(board[r+1][c]) && v == Math.abs(board[r+2][c])) {
                    board[r][c] = board[r+1][c] = board[r+2][c] = -v;
                    isValid = true;
                }
            }
        }

        printBoard(board);
        System.out.println("==========================");
        System.out.println("==========================");

        for (int c = 0; c < C; ++c) {
            int wr = R - 1; // 9 - 1 = 8
            for (int r = R - 1; r >= 0; --r) {
                printBoard(board);
                System.out.println("==========================");
                System.out.println("==========================");
                if (board[r][c] > 0)
                    board[wr--][c] = board[r][c]; //board[8][0] == 4 || board[8][1]
                printBoard(board);
                System.out.println("==========================");
                System.out.println("==========================");
                while (wr >= 0)
                    board[wr--][c] = 0;
                printBoard(board);
                System.out.println("==========================");
                System.out.println("==========================");
            }
        }

        return  board;
    }

    private static void printBoard(int[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        candyCrush(new int[][] {{110,5,112,113,114},{210,211,5,213,214},{310,311,3,313,314},{410,411,412,5,414},{5,1,512,3,3},{610,4,1,613,614},{710,1,2,713,714},{810,1,2,1,1},{1,1,2,2,2},{4,1,4,4,1014}});
    }
}
