package JavaLabs.ExceptionsAndErrors;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestExceptions {

    public static void testArrayIndexOutOfBoundsException() {
        int[] array = {0, 1, 2, 3};
        try {
            int element = array[4];
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Выход за пределы массива");
        }
    }

    public static void testFileNotFoundException() {
        try {
            FileReader reader = new FileReader("non-existent.txt");
        } catch (FileNotFoundException exception) {
            System.out.println("Файла не существует");
        }
    }

    public static void testNullPointerException() {
        String nullString = null;
        try {
            int length = nullString.length();
        } catch (NullPointerException exception) {
            System.out.println("Вызов метода от null");
        }
    }

    public static void testIOException() {
        try {
            FileReader reader = new FileReader("non-existent.txt");
        } catch (IOException exception) {
            System.out.println("Не существует файла");
        }
    }

    public static void testClassCastException() {
        try {
            Object obj = "some string";
            Integer integer = (Integer) obj;
        } catch (ClassCastException exception) {
            System.out.println("Нельзя привести тип");
        }
    }

    public static void testArithmeticException() {
        try {
            int infinity = 1/0;
        } catch (ArithmeticException exception) {
            System.out.println("Деление на ноль");
        }
    }

}
