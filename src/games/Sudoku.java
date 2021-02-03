package games;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sudoku {

    Map<Character, List<Integer>> digits = new HashMap<>();
    public boolean solution(char[][] board) {

        if(board == null || board.length == 0) return false;

        return validSudoku(board, 0, 3, 0, 3);
    }

    public boolean validSudoku(char[][] board, int rlow, int rhigh, int clow, int chigh) {

        if(rlow > 6|| rhigh > 8 || clow > 6 || chigh > 8) {
            return true;
        }


        for(int i = rlow; i < rhigh; i++) {
            for(int j = clow; j < chigh; j++) {
                int index = (i*9) + j;
                Character currValue = board[i][j];
                if(!currValue.equals('.') && !digits.containsKey(currValue)) {
                    digits.put(currValue, new ArrayList<Integer>());
                    digits.get(currValue).add(index);
                } else if(digits.containsKey(currValue)) {
                    List<Integer> listIndex = digits.get(currValue);
                    if(!listIndex.contains(index)) {
                        for(Integer pos: listIndex) {
                            int listI = pos / 9;
                            int listJ = pos % 9;
                            if(i == listI || j == listJ) {
                                return false;
                            }
                        }

                        digits.get(currValue).add(index);
                    }
                }
            }
        }

        return validSudoku(board, rlow, rhigh, clow + 3, chigh +3) && validSudoku(board, rlow + 3, rhigh
                + 3, clow, chigh) ;
    }


    public static void main(String[] args) {
        Sudoku game = new Sudoku();
//        System.out.println(game.solution(new String[][] {{"5","3",".",".","7",".",".",".","."},{"6",".",".","1","9","5",".",".","."},{".","9","8",".",".",".",".","6","."},{"8",".",".",".","6",".",".",".","3"},{"4",".",".","8",".","3",".",".","1"},{"7",".",".",".","2",".",".",".","6"},{".","6",".",".",".",".","2","8","."},{".",".",".","4","1","9",".",".","5"},{".",".",".",".","8",".",".","7","9"}}));
        System.out.println(game.solution(new char[][] {{'.','.','4','.','.','.','6','3','.'},{'.','.','.','.','.','.','.','.','.'},{'5','.','.','.','.','.','.','9','.'},{'.','.','.','5','6','.','.','.','.'},{'4','.','3','.','.','.','.','.','1'},{'.','.','.','7','.','.','.','.','.'},{'.','.','.','5','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'}}));
    }

}
