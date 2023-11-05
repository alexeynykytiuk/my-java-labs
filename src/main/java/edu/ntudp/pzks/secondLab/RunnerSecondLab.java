package edu.ntudp.pzks.secondLab;

import java.util.Scanner;

public class RunnerSecondLab {
    private static final int MIN_RANDOM_VALUE = -200;
    private static final int MAX_RANDOM_VALUE = 200;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть ширину матриці: ");
        int width = scanner.nextInt();
        System.out.print("Введіть висоту матриці: ");
        int height = scanner.nextInt();
        // Перевірка, чи розміри матриці не перевищують 20 на 20
        if (width > 20 || height > 20) {
            System.out.println("Розміри матриці не можуть перевищувати 20 на 20.");
            return;
        }
        System.out.println("Оберіть спосіб створення матриці цілих чисел:");
        System.out.println("1. Ручний спосіб вводу;");
        System.out.println("2. Автоматичний спосіб генерації матриці; (рандомно)");
        System.out.print("Ваш вибір: ");
        int choiseUser = scanner.nextInt();
        int[][] matrix = new int[width][height];
        if (choiseUser == 1) {
            fillMatrixFromKeyboard(matrix, scanner);
        } else if (choiseUser == 2) {
            fillMatrixRandomly(matrix);
        } else {
            System.out.println("Помилка, немає такого варіанту");
        }
        // Вивід результатів
        System.out.println("Матриця:");
        printMatrix(matrix);
        System.out.println("Мінімальний елемент: " + findMinElementsMatrix(matrix));
        System.out.println("Максимальний елемент: " + findMaxElementsMatrix(matrix));
        System.out.println("Середнє арифметичне: " + findAvarageElementMatrix(matrix, width, height));
        System.out.println("Середнє геометричне: " + findGeometryAvarageElementMatrix(matrix, width, height));
        scanner.close();
    }

    // Знаходження мінімальних елементів матриці
    public static int findMinElementsMatrix(int[][] matrix) {
        int min = matrix[0][0];
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if (anInt < min) {
                    min = anInt;
                }
            }
        }
        return min;
    }

    // Знаходження максимальних елементів матриці
    public static int findMaxElementsMatrix(int[][] matrix) {
        int max = matrix[0][0];
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if (anInt > max) {
                    max = anInt;
                }
            }
        }
        return max;
    }

    // Заповнення матриці з клавіатури
    public static void fillMatrixFromKeyboard(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("Елемент[" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    // Заповнення матриці рандомно
    public static void fillMatrixRandomly(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * (MAX_RANDOM_VALUE - MIN_RANDOM_VALUE + 1) + MIN_RANDOM_VALUE);
            }
        }
    }

    // Виведення матриці на екран
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    // Знаходження середнє значення елемента матриці
    public static double findAvarageElementMatrix(int[][] matrix, int width, int height) {
        int sum = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                sum += matrix[i][j];
            }
        }
        return (double) sum / (width * height);
    }

    // Знаходження середнє геометричного значення елемента матриці
    public static double findGeometryAvarageElementMatrix(int[][] matrix, int width, int height) {
        double gavg = 1;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                gavg *= matrix[i][j];
            }
        }
        gavg = Math.pow(gavg, 1.0 / (width * height));
        return gavg;
    }

}
