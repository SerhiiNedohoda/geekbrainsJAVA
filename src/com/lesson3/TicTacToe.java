package com.lesson3;

import java.util.Scanner;

public class TicTacToe {

//    Game settings
    private static char[][] map;
    private static final int SIZE = 3;
    private static final char DOT_EMPTY = '•';
    private static final char DOT_CROSS = 'X';
    private static final char DOT_ZERO = 'O';

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initMap();
        printMap();

//        for (;;){
//            humanTurn();
//            if (isEndGame(DOT_ZERO)) {
//                break;
//            }
//
//            computerTurn();
//            if (isEndGame(DOT_ZERO)) {
//                break;
//            }
//        }
        System.out.println("Game over!");
    }

    private static void printMap() {
        for (int i = 1; i <= SIZE; i++) {
            System.out.print("\t" + i);
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print((i+1) + " ");
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
}