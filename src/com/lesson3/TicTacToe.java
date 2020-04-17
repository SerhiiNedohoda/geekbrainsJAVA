package com.lesson3;

import java.util.*;

public class TicTacToe {

//    Game settings
    private static char[][] map;
    private static final int SIZE = 3;
    private static final char DOT_EMPTY = '•';
    private static final char DOT_HUMAN = 'X'; //Human
    private static final char DOT_COMPUTER = 'O'; //Computer

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();

        for (;;){
            humanTurn();
            if (isEndGame(DOT_HUMAN)) {
                break;
            }

            computerTurn();
            if (isEndGame(DOT_COMPUTER)) {
                break;
            }
        }
        System.out.println("Game over!");
    }

    private static boolean isEndGame(char playerSymbol) {
        boolean res = false;

        printMap();

        if (checkWin(playerSymbol)) {
            System.out.println("You win! " + playerSymbol);
            res = true;
        }

        if (isMapFull()) {
            System.out.println("Dead heat");
            res = true;
        }
        return res;
    }

    private static boolean checkWin(char playerSymbol) {
        boolean res = false;

        if (
                (map[0][0] == playerSymbol && map[0][1] == playerSymbol && map[0][2] == playerSymbol) ||
                (map[1][0] == playerSymbol && map[1][1] == playerSymbol && map[1][2] == playerSymbol) ||
                (map[2][0] == playerSymbol && map[2][1] == playerSymbol && map[2][2] == playerSymbol) ||
                (map[0][0] == playerSymbol && map[1][0] == playerSymbol && map[2][0] == playerSymbol) ||
                (map[0][1] == playerSymbol && map[1][1] == playerSymbol && map[2][1] == playerSymbol) ||
                (map[0][2] == playerSymbol && map[1][2] == playerSymbol && map[2][2] == playerSymbol) ||
                (map[0][0] == playerSymbol && map[1][1] == playerSymbol && map[2][2] == playerSymbol) ||
                (map[0][2] == playerSymbol && map[1][1] == playerSymbol && map[2][0] == playerSymbol)) {
            res = true;
        }

        return res;
    }

    private static boolean isMapFull() {
        boolean res = true;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (res = map[i][j] == DOT_EMPTY) {
                    res = false;
                }
            }
        }
        return res;
    }

    /**
     * Validation method of entered cell by user
     * @param x - horizontal coordinate
     * @param y - vertical coordinate
     * @return boolean - does the coordinate valid: true - valid; false - invalid
     */
    private static boolean isCellValid(int x, int y, boolean nearCheck) {
        boolean res = true;
        System.out.println("Validation x/y: " + x + "/" + y);
        if (nearCheck) {
            res = x < 0 || x >= SIZE || y < 0 || y >= SIZE ? false : true;

        } else if (x < 0 || x >= SIZE || y < 0 || y >= SIZE || map[y][x] != DOT_EMPTY) {
            res = false;
            System.err.println("Your coordinate is out of range or already taken: x = " + (y+1) + "; y = " + (x+1));
        }
        return res;
    }

    private static void printMap() {
        for (int i = 1; i <= SIZE; i++) {
            System.out.print("\t" + "y" + i);
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print("x" + (i+1));
            for (int j = 0; j < SIZE; j++) {
                System.out.print("\t" + map[i][j]);
            }
            System.out.println();
        }

        System.out.println();
    }

    private static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void humanTurn() {
        int x, y;
        do {
            System.out.println("Enter your coordinates (x and y) separated by space");
            y = SCANNER.nextInt() - 1;
            x = SCANNER.nextInt() - 1;

        } while (!isCellValid(x, y, false));

        map[y][x] = DOT_HUMAN;
    }

    private static void computerTurn() {
        int x = -1;
        int y = -1;


        // Check and write empty cells into LinkedHashMap
        Map <String, Integer> scoreHashMap = new LinkedHashMap<String, Integer>();

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    scoreHashMap.put(i + "/" + j,0);
//                    System.out.print("\t(" + i + ";" + j + ")");
                }
            }
        }

        //parse keys from LinkedHashMap to int[]
        int[] cellCoordinates = new int[scoreHashMap.size()*2];
        int k = 0; //Array index
        for ( Map.Entry<String, Integer> item : scoreHashMap.entrySet()) {
            String[] tempCellCoordinates = item.getKey().split("/", 2);

            cellCoordinates[k] = Integer.parseInt(tempCellCoordinates[0]);
            cellCoordinates[k+1] = Integer.parseInt(tempCellCoordinates[1]);
            k += 2;
        }

        //Display/compare array with LinkedHashMap, does everything good
//        System.out.println("Int array of coordinates: " + Arrays.toString(cellCoordinates));
//        System.out.println(scoreHashMap.keySet());

        //Check near elements
        String[] keysScoreHashMap = scoreHashMap.keySet().toArray(new String[0]);
        int n = 0; //Array index
        for (int l = 0; l < cellCoordinates.length/2; l++) {
            int i = cellCoordinates[n];
            int j = cellCoordinates[n+1];
            System.out.println("Checked coordinate: (" + i + "/" + j + ")\t");
            int tempValue = scoreHashMap.get(keysScoreHashMap[n/2]); //get current key value in HashMap

            //Check does the neighbor cell is valid and has 'O'
            if (isCellValid(i-1,j-1, true) && map[i-1][j-1] == DOT_COMPUTER) {
                scoreHashMap.replace(keysScoreHashMap[n/2], tempValue+1);
            }
            if (isCellValid(i-1,j, true) && map[i-1][j] == DOT_COMPUTER) {
                scoreHashMap.replace(keysScoreHashMap[n/2], tempValue+1);
            }
            if (isCellValid(i-1,j+1, true) && map[i-1][j+1] == DOT_COMPUTER) {
                scoreHashMap.replace(keysScoreHashMap[n/2], tempValue+1);
            }
            if (isCellValid(i,j-1, true) && map[i][j-1] == DOT_COMPUTER) {
                scoreHashMap.replace(keysScoreHashMap[n/2], tempValue+1);
            }
            if (isCellValid(i,j+1, true) && map[i][j+1] == DOT_COMPUTER) {
                scoreHashMap.replace(keysScoreHashMap[n/2], tempValue+1);
            }
            if (isCellValid(i+1,j-1, true) && map[i+1][j-1] == DOT_COMPUTER) {
                scoreHashMap.replace(keysScoreHashMap[n/2], tempValue+1);
            }
            if (isCellValid(i+1,j, true) && map[i+1][j] == DOT_COMPUTER) {
                scoreHashMap.replace(keysScoreHashMap[n/2], tempValue+1);
            }
            if (isCellValid(i+1,j+1, true) && map[i+1][j+1] == DOT_COMPUTER) {
                scoreHashMap.replace(keysScoreHashMap[n/2], tempValue+1);
            }
            n += 2;
        }
        System.out.println("HashMap: " + scoreHashMap.entrySet());

        //Get max value from HashMap and get key for this value
        int maxValue = 0;
        for (Map.Entry<String, Integer> value : scoreHashMap.entrySet()) {
            if(maxValue == 0 || value.getValue() > maxValue) {
                maxValue = value.getValue();
            }
        }

        //Get key by maxValue(if there is two the same value - use the last one)
        String maxValueKey = "";
        for (Map.Entry<String, Integer> entry : scoreHashMap.entrySet()) {
            if (entry.getValue().equals(maxValue)) {
                maxValueKey = entry.getKey();
            }
        }

        //Get coordinates from a key
        int[] maxValueCoordinates = new int[2];
        if (!maxValueKey.equals("")) {
            String[] temp = maxValueKey.split("/", 2);
            maxValueCoordinates[0] = Integer.parseInt(temp[0]);
            maxValueCoordinates[1] = Integer.parseInt(temp[1]);
        }

        //Write 'O' into cell with max 'O' neighbors
        if (maxValue != 0) {
            do {
                x = maxValueCoordinates[0];
                y = maxValueCoordinates[1];
            } while (!isCellValid(x,y, false));
        } else {
            do {
                x = RANDOM.nextInt(SIZE);
                y = RANDOM.nextInt(SIZE);
            } while (!isCellValid(x,y, false));
        }

        System.out.println("AI choose cell: (" + (y+1) + ";" + (x+1) + ")");
        map[y][x] = DOT_COMPUTER;
    }
}