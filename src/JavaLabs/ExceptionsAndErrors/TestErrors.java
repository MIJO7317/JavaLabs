package JavaLabs.ExceptionsAndErrors;

import java.util.ArrayList;
import java.util.function.Function;

public class TestErrors {

    public static void testOutOfMemoryError() {
        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            list.add(1);
        }
    }

    private static Integer recursionFunction(Integer i) {
        return recursionFunction(i+1);
    }

    public static void testStackOverflowError() {
        recursionFunction(1);
    }
}
