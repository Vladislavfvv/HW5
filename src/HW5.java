import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class HW5 {
    public static void main(String[] args) throws IOException {
        System.out.println("Введите номер задачи:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - Создать трёхмерный массив из целых чисел. " +
                "С помощью циклов пройти по всему массиву и увеличить каждый элемент на заданное число. " +
                "Пусть число, на которое будет увеличиваться каждый элемент, задается из консоли. ");

        System.out.println("2 - Шахматная доска. " +
                "Создать программу для раскраски шахматной доски с помощью цикла. " +
                "Создать двумерный массив String'oв 8x8. С помощью циклов задать элементам цикла значения " +
                "B(Black) или W(White). ");

        System.out.println("3 - Умножение двух матриц. " +
                "Создайте два массива целых чисел размером 3х3 (две матрицы). " +
                "Напишите программу для умножения двух матриц. " +
                "Первый массив: {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 0, 0}} " +
                "Второй массив: {{1, 2, 3}, {1, 1, 1}, {0, 0, 0}, {2, 1, 0}} " +
                "Ожидаемый результат: {{1, 2, 3}, {1, 1, 1}, {0, 0, 0}}");

        System.out.println("4 - Создайте двумерный массив целых чисел. " +
                "Выведите на консоль сумму всех элементов массива.");

        System.out.println("5 - Создайте двумерный массив. Выведите на консоль диагонали массива.");

        System.out.println("6 - Создайте двумерный массив целых чисел. " +
                "Отсортируйте элементы в строках массива по возрастанию.");

        System.out.println("7 - Шахматная доска. Ход конем.");

        int task = scanner.nextInt();
        switch (task) {

            //Task 1
            case 1: {

                System.out.println("Введите размер трёхмерного массива: ");
                int size = scanner.nextInt();
                int[][][] arr1 = generateArr1(size);
                System.out.println("Ваш массив:");
                printArr1(arr1, size);

                while (true) {
                    System.out.println("Введите число, которое хотите прибавить к трёхмерному массиву: ");
                    int num = scanner.nextInt();
                    System.out.println("Ваш новый массив: ");
                    addNumber(arr1, size, num);
                    printArr1(arr1, size);
                    System.out.println("Хотите прибавить еще число? y/n");
                    char message = (char) System.in.read();
                    if (message == 'n') break;
                }
            }
            break;

            //Task 2
            case 2: {
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if ((i + j) % 2 == 0) System.out.print(String.valueOf('W') + "  ");
                        else System.out.print(String.valueOf('B') + "  ");
                    }
                    System.out.println();
                }
            }
            break;

            //Task 3
            case 3: {
                //"Первый массив: {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 0, 0}} " +
                //                "Второй массив: {{1, 2, 3}, {1, 1, 1}, {0, 0, 0}, {2, 1, 0}} " +
                //                "Ожидаемый результат: {{1, 2, 3}, {1, 1, 1}, {0, 0, 0}}");
                int[][] arrayFirst = {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 0, 0}};
                int[][] arraySecond = {{1, 2, 3}, {1, 1, 1}, {0, 0, 0}, {2, 1, 0}};
                int a = 0, b = 0, c = 0, d = 0;

                System.out.println("FirstArray:");
                for (int i = 0; i < arrayFirst.length - 1; i++) {
                    a = arrayFirst.length;
                    for (int j = 0; j < arrayFirst.length; j++) {
                        b = arrayFirst.length;
                        System.out.print(arrayFirst[i][j]);
                        if (j < arrayFirst.length) System.out.print(" ");
                    }
                    if (i < arrayFirst.length) System.out.println();
                }

                System.out.println("SecondArray:");
                for (int k = 0; k < arraySecond.length; k++) {
                    c = arraySecond.length;
                    for (int l = 0; l < arraySecond.length - 1; l++) {
                        d = arraySecond.length;
                        System.out.print(arraySecond[k][l]);
                        if (l < arraySecond.length - 1) System.out.print(" ");
                    }
                    if (k < arraySecond.length) System.out.println();
                }

                int[][] newarray = multipliedArray(arrayFirst, arraySecond, a, b, c, d);

                System.out.println("Multiplied Array: ");

                for (int i = 0; i < newarray.length; i++) {
                    for (int j = 0; j < newarray.length; j++) {
                        System.out.print(newarray[i][j]);
                        if (j < newarray.length - 1) System.out.print(" ");
                    }
                    if (i < newarray.length - 1) System.out.println();
                }
            }
break;
            //Task4
            case 4: {
                System.out.println("Введите количество строк двумерного массива:");
                int row = scanner.nextInt();
                System.out.println("Введите количество столбцов двумерного массива:");
                int col = scanner.nextInt();
                int[][] arr4 = generateTwoDimensionalArray(row, col);
                System.out.println("Your Array:");
                printTwoDimensionalArray(arr4, row, col);
                int sum = sumOfElementsArray(arr4, row, col);
                System.out.println();
                System.out.print("Sum of the elements: " + sum);

            }
break;
            //Task 5
            case 5: {
                char[][] arr5 = new char[7][7];
                for (int i = 0; i < 7; i++) {
                    for (int j = 0; j < 7; j++) {
                        arr5[i][j] = 'O';
                    }
                }
                while (true) {
                    System.out.println("Выберите, что будем выводить на экран:" + "\n" +
                            "1 - X " + "\n" +
                            "2 - ромб " + "\n" +
                            "3 - закрашенный ромб " + "\n" +
                            "4 - восьмиугольник " + "\n" +
                            "5 - рамка" + "\n");
                    int find = scanner.nextInt();
                    switch (find) {
                        case 1: {
                            System.out.println("New massive");
                            for (int i = 0; i < arr5.length; i++) {
                                for (int j = 0; j < arr5.length; j++) {
                                    //if (j - i > 0 || i - j > 0) arr5[i][j] = 0;
                                    System.out.print(arr5[i][j]);
                                    if (j < arr5.length - 1) System.out.print("  ");
                                }
                                if (i < arr5.length - 1) System.out.println();
                            }

                            System.out.println("\n");
                            for (int i = 0; i < arr5.length; i++) {
                                for (int j = 0; j < arr5.length; j++) {
                                    if (i + j - arr5.length + 1 == 0 || i - j == 0)
                                        arr5[i][j] = 'X';
                                }
                            }

                            for (int i = 0; i < arr5.length; i++) {
                                for (int j = 0; j < arr5.length; j++) {
                                    System.out.print(arr5[i][j]);
                                    if (j < arr5.length - 1) System.out.print("  ");
                                }
                                if (i < arr5.length - 1) System.out.println();
                            }
                        }
                        break;
                        case 2: {
                            //ромб//////////////////////

                            for (int i = 0; i < 7; i++) {
                                for (int j = 0; j < 7; j++) {
                                    arr5[i][j] = 'O';
                                }
                            }

                            System.out.println("\n");
                            for (int i = 0; i < arr5.length; i++) {
                                for (int j = 0; j < arr5.length; j++) {
                                    if (i + j == arr5.length / 2 || i + j == (arr5.length - 1) * 3 / 2 || i - j == arr5.length / 2 || j - i == arr5.length / 2)
                                        arr5[i][j] = 'X';
                                }
                            }
                            for (int i = 0; i < arr5.length; i++) {
                                for (int j = 0; j < arr5.length; j++) {
                                    System.out.print(arr5[i][j]);
                                    if (j < arr5.length - 1) System.out.print("  ");
                                }
                                if (i < arr5.length - 1) System.out.println();
                            }


                        }
                        break;
                        case 3: {
                            //ромб2222//////////////////////

                            for (int i = 0; i < 7; i++) {
                                for (int j = 0; j < 7; j++) {
                                    arr5[i][j] = 'O';
                                }
                            }

                            System.out.println("\n");
                            for (int i = 0; i < arr5.length; i++) {
                                for (int j = 0; j < arr5.length; j++) {
                                    if (i + j - arr5.length / 2 >= 0 & (i + j - (arr5.length - 1) * 3 / 2) <= 0 & i - j - arr5.length / 2 <= 0 & j - i - arr5.length / 2 <= 0)
                                        arr5[i][j] = 'X';
                                }
                            }
                            for (int i = 0; i < arr5.length; i++) {
                                for (int j = 0; j < arr5.length; j++) {
                                    System.out.print(arr5[i][j]);
                                    if (j < arr5.length - 1) System.out.print("  ");
                                }
                                if (i < arr5.length - 1) System.out.println();
                            }

                        }
                        break;
                        case 4: {
                            //восьмиугольник                //////////////////////

                            for (int i = 0; i < 7; i++) {
                                for (int j = 0; j < 7; j++) {
                                    arr5[i][j] = 'O';
                                }
                            }

                            System.out.println("\n");
                            for (int i = 0; i < arr5.length; i++) {
                                for (int j = 0; j < arr5.length; j++) {
                                    if (i + j == arr5.length / 3
                                            || j - i == arr5.length / 2 + 1
                                            || i - j == arr5.length / 2 + 1
                                            || i + j == arr5.length * 3 / 2
                                            || j == 0 & i < arr5.length / 2 + 1 & i > arr5.length / 2 - 1
                                            || i == 0 & j < arr5.length / 2 + 1 & j > arr5.length / 2 - 1
                                            || i == arr5.length - 1 & j < arr5.length / 2 + 1 & j > arr5.length / 2 - 1
                                            || j == arr5.length - 1 & i < arr5.length / 2 + 1 & i > arr5.length / 2 - 1)
                                        arr5[i][j] = 'X';
                                }
                            }
                            for (int i = 0; i < arr5.length; i++) {
                                for (int j = 0; j < arr5.length; j++) {
                                    System.out.print(arr5[i][j]);
                                    if (j < arr5.length - 1) System.out.print("  ");
                                }
                                if (i < arr5.length - 1) System.out.println();
                            }

                        }
                        break;
                        case 5: {
                            /////////////////////
//рамка
                            for (int i = 0; i < 7; i++) {
                                for (int j = 0; j < 7; j++) {
                                    arr5[i][j] = 'O';
                                }
                            }

                            System.out.println("\n");
                            for (int i = 0; i < arr5.length; i++) {
                                for (int j = 0; j < arr5.length; j++) {
                                    if (i == 0 || j == 0 || i == arr5.length - 1 || j == arr5.length - 1)
                                        arr5[i][j] = 'X';
                                }
                            }
                            for (int i = 0; i < arr5.length; i++) {
                                for (int j = 0; j < arr5.length; j++) {
                                    System.out.print(arr5[i][j]);
                                    if (j < arr5.length - 1) System.out.print("  ");
                                }
                                if (i < arr5.length - 1) System.out.println();
                            }

                        }
                        break;
                    }
                    System.out.println();
                    System.out.println("Желаете повторить? y/n");
                    char c = (char) System.in.read();
                    if (c == 'n') break;
                }
            }

            //Task6
            case 6: {
                System.out.println("Введите количество строк двумерного массива:");
                int row = scanner.nextInt();
                System.out.println("Введите количество столбцов двумерного массива:");
                int col = scanner.nextInt();
                int[][] arr6 = generateTwoDimensionalArray(row, col);
                System.out.println("Your Array:");
                printTwoDimensionalArray(arr6, row, col);

                for (int i = 0; i < arr6.length; i++) {
                    for (int j = arr6[i].length - 1; j > 0; j--) {
                        for (int k = 0; k < j; k++) {
                            if (arr6[i][k] > arr6[i][k + 1]) {
                                int temp = arr6[i][k + 1];
                                arr6[i][k + 1] = arr6[i][k];
                                arr6[i][k] = temp;
                            }
                        }
                    }
                }

                System.out.println();
                System.out.println("Отсортированный массив:");
                printTwoDimensionalArray(arr6, row, col);
            }

            //Task 7
            case 7: {
                System.out.println("Координаты расположения коня: " + "\n"
                        + "Введите точку х = ");
                int x = scanner.nextInt();
                System.out.println("Введите точку у = ");
                int y = scanner.nextInt();

                char[][] chess = new char[8][8];
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        chess[i][j] = '#';
                    }
                    System.out.println();
                }
                x--;
                y--;
                chess[x][y] = 'X';

                int a = x + 2, b = x - 2, c = x + 1, d = x - 1;
                int q = y + 2, w = y - 2, e = y + 1, s = y - 1;

///////заполнение ходами
                int count = 0;
                for (int i = 0; i < chess.length; i++) {
                    for (int j = 0; j < chess[i].length; j++) {
                        if (i == x + 2 && j == y + 1) {
                            chess[i][j] = '0';
                            count++;
                        }
                        if (i == x + 2 && j == y - 1) {
                            chess[i][j] = '0';
                            count++;
                        }
                        if (i == x - 2 && j == y + 1) {
                            chess[i][j] = '0';
                            count++;
                        }
                        if (i == x - 2 && j == y - 1) {
                            chess[i][j] = '0';
                            count++;
                        }
                        if (i == x + 1 && j == y + 2) {
                            chess[i][j] = '0';
                            count++;
                        }
                        if (i == x + 1 && j == y - 2) {
                            chess[i][j] = '0';
                            count++;
                        }
                        if (i == x - 1 && j == y + 2) {
                            chess[i][j] = '0';
                            count++;
                        }
                        if (i == x - 1 && j == y - 2) {
                            chess[i][j] = '0';
                            count++;
                        }
                    }

                }

                System.out.println();
                for (int i = 0; i < chess.length; i++) {
                    for (int j = 0; j < chess[i].length; j++) {
                        System.out.print(chess[i][j] + "  ");
                    }
                    System.out.println();

                }
                System.out.println("Количество ходов: " + count);
            }
        }
    }


    public static int[][] generateTwoDimensionalArray(int a, int b) {
        int[][] array = new int[a][b];

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                Random random = new Random();
                array[i][j] = random.nextInt(10);
            }
        }
        return array;
    }

    public static void printTwoDimensionalArray(int array[][], int r, int t) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < t; j++) {
                System.out.print(array[i][j]);
                if (j < t) System.out.print(" ");
            }
            if (i < r) System.out.println();
        }
    }

    public static int sumOfElementsArray(int[][] array, int row, int col) {
        int sum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sum += array[i][j];
            }
        }
        return sum;
    }


    public static int[][] multipliedArray(int arr1[][], int arr2[][], int a, int b, int c, int d) {
        int array[][] = new int[a][d];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < d; j++) {
                for (int k = 0; k < d - 1; k++) {
                    array[i][k] += arr1[i][j] * arr2[j][k];
                }
            }
        }
        return array;
    }
    //

    public static int[][][] generateArr1(int n) {

        Random random = new Random();
        int[][][] arr = new int[n][n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    arr[i][j][k] = random.nextInt(10);
                }
            }
        }
        return arr;
    }

    //public static void printArr3X3(arr[][], int)


    public static void printArr1(int[][][] arr1, int n) {
        System.out.print("[");
        for (int i = 0; i < n; i++) {
            System.out.print("[");
            for (int j = 0; j < n; j++) {
                System.out.print("[");
                for (int k = 0; k < n; k++) {
                    System.out.print(arr1[i][j][k] + " ");
                }
                System.out.print("]");
            }
            System.out.print("]");
            if (i < n - 1) System.out.println();
        }
        System.out.println("]");
        System.out.println();
    }

    public static int[][][] addNumber(int[][][] array, int size, int number) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    array[i][j][k] += number;
                }
            }
        }
        return array;
    }
}

