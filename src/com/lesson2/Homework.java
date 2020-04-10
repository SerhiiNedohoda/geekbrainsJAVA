package com.lesson2;

import java.util.Arrays;
/*
1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    С помощью циклаи условия заменить 0 на 1, 1 на 0;
2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], пройти по нему циклом, и числа, меньшие 6, умножить на 2;
4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
5. Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
6. Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
    если в массиве есть место, в котором сумма левой и правой части массива равны.
    Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false, checkBalance ([10, || 10]) → true,
    граница показана символами ||, эти символы в массив не входят;
7. *Написать метод, которому на вход подается одномерный массив и число n (может быть положительным или отрицательным),
    при этом метод должен сместить все элементы массива на n позиций. Нельзя пользоваться вспомогательными массивами.
 */

public class Homework {

    static int[] arrFirstTask = {1, 1, 0, 1, 1, 0, 1, 0};
    static int[] arrSecondTask = new int[8];
    static int[] arrThirdTask = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
    static int[][] arrFourthTask = new int[7][7];
    static int[] arrSixthTaskBalanced = {7,2,1,4};


    public static void main(String[] args) {
//        System.out.println(displayTaskTitle("First"));
//        arrInversion(arrFirstTask);
//
//        System.out.println(displayTaskTitle("Second"));
//        fillArray(arrSecondTask);
//
//        System.out.println(displayTaskTitle("Third"));
//        multiplyBy2(arrThirdTask);
//
//        System.out.println(displayTaskTitle("Fourth"));
//        fillSquareArray(arrFourthTask);
//
//        System.out.println(displayTaskTitle("Fifth"));
//        findMinAndMaxElements(arrThirdTask);
//
//        System.out.println(displayTaskTitle("Sixth"));
//        System.out.println("Does your array balanced: " + isArrayBalanced(arrSixthTaskBalanced));
//
        System.out.println(displayTaskTitle("Seventh"));
        shiftElement(arrSixthTaskBalanced, 1);
    }

    private static String displayTaskTitle(String title) {
        return "\n+++++ " + title + " task: " + "+++++";
    }

    private static int[] arrInversion(int[] arr) {
        System.out.println("Default:  " + Arrays.toString(arr));
        for(int i = 0; i < arr.length; i++) {
            if ( arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        System.out.println("Inverted: " + Arrays.toString(arr));
        return arr;
    }

    private static int[] fillArray(int[] arr) {
        System.out.println("Default: " + Arrays.toString(arr));
        int increment = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = increment;
            increment += 3;
        }
        System.out.println("Result:  " + Arrays.toString(arr));
        return arr;
    }

    private static int[] multiplyBy2(int[] arr) {
        System.out.println("Default: " + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i]*2;
            }
        }
        System.out.println("Result:  " + Arrays.toString(arr));
        return arr;
    }

    private static int[][] fillSquareArray(int[][] arr) {

        for (int i = 0, j = 0; i < arr.length; i++, j++) {
            arr[i][j] = 1;
            arr[i][(arr.length - 1) - j] = 1;
        }
        displaySquareArray(arr);
        return arr;
    }

    private static void findMinAndMaxElements(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i : arr) {
            if (min > i) {
                min = i;
            } else if( max < i) {
                max = i;
            }
        }
        System.out.println("Min element: " + min + "\nMax element: " + max);
    }

    private static boolean isArrayBalanced(int[] arr) {
        boolean res = false;
        if (arr.length < 2) {
            System.err.println("Can't check balance because array consist of less than 2 element. Array length: "
                                + arr.length);
        }

        int leftSum = arr[0], rightSum = arr[arr.length - 1];

        for (int i = 1, k = arr.length - 2; i <= k;) {
            if (leftSum < rightSum || (leftSum == rightSum && arr[i] <= arr[k])) {
                    leftSum += arr[i];
                    i++;
                } else {
                    rightSum +=arr[k];
                    k--;
                }
        }
        if (leftSum == rightSum) {
            res = true;
        }
        System.out.println("Left sum: " + leftSum + "\t\tRight sum: " + rightSum);
        return res;
    }

    private static int[] shiftElement(int[] arr, int n) {
        System.out.println("Default array: " + Arrays.toString(arr));
        if (n == 0) {
            System.err.println("Sorry, but I can't shift elements to " + n + " position. Try another position counter");
        }

        if (n > 0) {
            for (int i = arr.length - 1; i > 0; i--) {
                arr[i] += arr[i+n];
            }
        }

        System.out.println("Shifted array: " + arr);
        return arr;
    }



    private static void displaySquareArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
