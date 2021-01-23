package games;

import sun.jvm.hotspot.gc_implementation.parallelScavenge.PSYoungGen;

import java.util.*;

public class TicTacToe {

    static List<Integer> playerPositionsList = new ArrayList<>();
    static List<Integer> cpuPositionsList = new ArrayList<>();


    private static void printGamBoard(char[][] gameBoard) {
        for(char[] row: gameBoard) {
            for(char ch: row) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }

    private static void fillGameBoard(char[][] gameBoard, int pos, String player) {

        char symbol = 'X';
        if(player.equals("player")) {
            symbol = 'X';
            playerPositionsList.add(pos);
        } else {
            symbol = 'O';
            cpuPositionsList.add(pos);
        }

        switch (pos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
        }
    }

    private static String checkWinner() {
        List<Integer> firstRow = Arrays.asList(1,2,3);
        List<Integer> midRow = Arrays.asList(4,5,6);
        List<Integer> lastRow = Arrays.asList(7,8,9);
        List<Integer> firstCol = Arrays.asList(1,4,7);
        List<Integer> midCol = Arrays.asList(2,5,8);
        List<Integer> lastCol = Arrays.asList(3,6,9);
        List<Integer> cross1 = Arrays.asList(1,5,9);
        List<Integer> cross2 = Arrays.asList(7,5,3);

        List<List<Integer>> winnerCombinations = new ArrayList<>();
        winnerCombinations.add(firstRow);
        winnerCombinations.add(midRow);
        winnerCombinations.add(lastRow);
        winnerCombinations.add(firstCol);
        winnerCombinations.add(midCol);
        winnerCombinations.add(lastCol);
        winnerCombinations.add(cross1);
        winnerCombinations.add(cross2);

        for(List combination: winnerCombinations) {
            if(playerPositionsList.containsAll(combination)) {
                return "Yay you are the winner";
            } else if(cpuPositionsList.containsAll(combination)) {
                return "Sorry you lost :(";
            } else if(playerPositionsList.size() + cpuPositionsList.size() == 9){
                return "DRAW!!!";
            }
        }
      return null;

    }

    public static void main(String[] args) {
        int numberOfTurns = 4;
        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                              {'-', '+', '-', '+', '-'},
                              {' ', '|', ' ', '|', ' '},
                              {'-', '+', '-','+','-'},
                              {' ', '|', ' ', '|', ' '}};

        printGamBoard(gameBoard);
        //make player enter a value
       while(numberOfTurns != 0) {
           Scanner scan = new Scanner(System.in);
           System.out.println("Please enter a position from 1-9");
           int playerPos = scan.nextInt();
           while(playerPositionsList.contains(playerPos) || cpuPositionsList.contains(playerPos)) {
               System.out.printf("Please enter a different number, that position is already taken");
               playerPos = scan.nextInt();
           }

           fillGameBoard(gameBoard, playerPos, "player");

           Random rand = new Random();
           int cpuPostion = rand.nextInt(9) + 1;
           while(playerPositionsList.contains(cpuPostion) || cpuPositionsList.contains(cpuPostion)) {
               cpuPostion = rand.nextInt(9) + 1;
           }
           fillGameBoard(gameBoard, cpuPostion, "cpu");

           printGamBoard(gameBoard);
           String result = checkWinner();
           if(result != null) System.out.println(result);

           numberOfTurns--;

       }


    }
}
