package java_tasks;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
https://www.codewars.com/kata/5679aa472b8f57fb8c000047
*/
public class EqualSidesOfAnArray {
    public static int findEvenIndex(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && IntStream.of(Arrays.copyOfRange(arr, 0, i)).sum()
                    == IntStream.of(Arrays.copyOfRange(arr, i + 1, arr.length)).sum()) {
                return i;
            }
        }
        return IntStream.of(Arrays.copyOfRange(arr, 1, arr.length)).sum() == 0 ? 0 : -1;
    }
}
