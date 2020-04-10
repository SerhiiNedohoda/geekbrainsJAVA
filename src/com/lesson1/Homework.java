package com.lesson1;

/*
+1. Создать пустой проект в IntelliJ IDEA и прописать метод main();
+2. Создать переменные всех пройденных типов данных, и инициализировать их значения;
+3. Написать метод, вычисляющий выражение a * (b + (c / d)) и возвращающий результат, где a, b, c, d – входные параметры этого метода;
+4. Написать метод, принимающий на вход два числа, и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false;
+5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль положительное число передали или отрицательное (Замечание: ноль считаем положительным числом.);
+6. Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное;
+7. Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
+8. *Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
 */

public class Homework {
    //task 2
    byte _byte = 1;
    short _short = 123;
    int _int = 123123;
    long _long = 123123123L;
    float _float = 123.123f;
    double _double = 123123.123;
    char _char = 'X';

    public static void main(String[] args) {
        System.out.println("Hello World"); //task 1
        System.out.println("Calculation result: " + calculation(1, 3.5, 7, 0.1)); //task 3
        System.out.println("Does the sum equal the range 10..20: " + sumCompare(5, 10)); //task 4
        positiveCheck(178); //task 5
        System.out.println("Does your number is negative: " + negativeCheck(-18)); //task 6
        name("Сергей"); //task 7
        leapYear((short) 2020); //task 8

    }

    private static int calculation(int a, int b, int c, int d) {
        int res;
        if (isNull(d)) {
            res = 0;
        } else {
            res = a * (b + (c / d));
        }
        return res;
    }


    private static double calculation(double a, double b, double c, double d) {
        double res;
        if (isNull(d)) {
            res = 0;
        } else {
            res = a * (b + (c / d));
        }
        return res;
    }

    private static boolean sumCompare(int a, int b) {
        if ((a + b) >= 10 && (a + b) <= 20) {
            return true;
        } else {
            return false;
        }
    }

    private static void positiveCheck(int a) {
        String res;
        res = a >= 0 ? "Your number is positive" : "Your number is negative";
        System.out.println("Does your number is positive: " + res);
    }

    private static boolean negativeCheck(int a) {
        return a < 0;
    }

    private static void name(String a) {
        System.out.println("Привет, " + a + "!");
    }

    private static void leapYear(short a) {
        if (a % 4 == 0 && a % 100 != 0 || a % 400 == 0) {
            System.out.println("This year(" + a + ") is a leap year!");
        } else {
            System.out.println("This year(" + a + ") is not a leap year!");
        }
    }

    private static boolean isNull(double a) {
        boolean res;
        if (a == 0) {
            System.err.println("Can't divide by zero! Entered number is: " + a);
            res = true;
        } else {
            res = false;
        }
        return res;
    }

}
