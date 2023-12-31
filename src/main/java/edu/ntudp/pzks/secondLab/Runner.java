package edu.ntudp.pzks.secondLab;

import java.util.Scanner;

public class Runner {
    private static final int MIN_RANDOM_VALUE = -200;
    private static final int MAX_RANDOM_VALUE = 200;
    private static final int MAX_MATRIX_RANGE = 20;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть ширину матриці: ");
        int width = scanner.nextInt();
        System.out.print("Введіть висоту матриці: ");
        int height = scanner.nextInt();
        if (width > MAX_MATRIX_RANGE || height > MAX_MATRIX_RANGE) {
            System.out.println("Розміри матриці не можуть перевищувати" + MAX_MATRIX_RANGE + " на " + MAX_MATRIX_RANGE);
            return;
        }
        System.out.println("""
                Оберіть спосіб створення матриці цілих чисел:
                1. Ручний спосіб вводу;
                2. Автоматичний спосіб генерації матриці; (рандомно)
                Ваш вибір:
                """);

        int[][] matrix = new int[width][height];
        int choiseUser = scanner.nextInt();
        if (choiseUser == 1) {
            fillMatrixFromKeyboard(matrix, scanner);
        } else if (choiseUser == 2) {
            fillMatrixRandomly(matrix);
        } else {
            System.out.println("Помилка, немає такого варіанту");
        }
        System.out.println("Матриця:");
        printMatrix(matrix);
        System.out.println("Мінімальний елемент: " + findMinElementMatrix(matrix));
        System.out.println("Максимальний елемент: " + findMaxElementMatrix(matrix));
        System.out.println("Середнє арифметичне: " + findAvarageElementMatrix(matrix, width, height));
        System.out.println("Середнє геометричне: " + findGeometryAvarageMatrix(matrix, width, height));
        scanner.close();
    }

    private static int findMinElementMatrix(int[][] matrix) {
        int min = matrix[0][0];
        for (int[] rowsOfMatrix : matrix) {
            for (int elementOfMatrix : rowsOfMatrix) {
                if (elementOfMatrix < min) {
                    min = elementOfMatrix;
                }
            }
        }
        return min;
    }

    private static int findMaxElementMatrix(int[][] matrix) {
        int max = matrix[0][0];
        for (int[] rowsOfMatrix : matrix) {
            for (int elementOfMatrix : rowsOfMatrix) {
                if (elementOfMatrix > max) {
                    max = elementOfMatrix;
                }
            }
        }
        return max;
    }

    private static void fillMatrixFromKeyboard(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("Елемент[" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    private static void fillMatrixRandomly(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * (MAX_RANDOM_VALUE - MIN_RANDOM_VALUE + 1) + MIN_RANDOM_VALUE);
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static double findAvarageElementMatrix(int[][] matrix, int width, int height) {
        int sum = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                sum += matrix[i][j];
            }
        }
        return (double) sum / (width * height);
    }

    private static double findGeometryAvarageMatrix(int[][] matrix, int width, int height) {
        double geometryAvarageValue = 1;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                geometryAvarageValue *= matrix[i][j];
            }
        }
        geometryAvarageValue = Math.pow(geometryAvarageValue, 1.0 / (width * height));
        return geometryAvarageValue;
    }

}
