package Task11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UserNumberArray {

    public static void main(String[] args) throws IOException {

        int arrayLength = createSizeOfArray();

        int[] cleanArray = new int[arrayLength];
        int[] userArray = createAndFillArray(cleanArray);

        System.out.println(Arrays.toString(userArray));

        divide(userArray);

    }

    private static int createSizeOfArray() {
        System.out.println("Введите длину масива: ");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return Integer.parseInt(reader.readLine());
        } catch (NumberFormatException | IOException ex) {
            System.out.println("Вы ввели не число. Пожалуйста, введите число ");
            return createSizeOfArray();
        }
    }

    private static int[] createAndFillArray(int[] arr) throws IOException {
        System.out.println("Заполните массив целыми числами: ");
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < arr.length; i++) {
            try {
                arr[i] = Integer.parseInt(reader1.readLine());
            } catch (NumberFormatException ex) {
                System.out.println("Вы ввели не число. Пожалуйста, заполняйте массив только целыми числами");
                return createAndFillArray(arr);
            }
        }
        return arr;
    }

    private static void divide(int[] arr) throws IOException {
        System.out.println("Выберите 2 числа. Введите их индексы(индексы в массиве начинаются с 0). " +
                "Первое будет разделено на второе");
        int counter = 0;
        int[] indexes = new int[2];
        int[] nums = new int[2];
        int result;
        while (counter < indexes.length) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                indexes[counter] = Integer.parseInt(reader.readLine());
                nums[counter] = arr[indexes[counter]];
                counter++;
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException ex) {
                System.out.println("Введите пожалуйста число");
                divide(arr);
            }

        }
        try {
            result = nums[0] / nums[1];
            System.out.println("Результат деления - " + result);
        } catch (ArithmeticException ex) {
            System.out.println("Попытка деления на 0. На 0 делить нельзя. Попробуйте выбрать другой делитель");
            divide(arr);
        }
    }
}
