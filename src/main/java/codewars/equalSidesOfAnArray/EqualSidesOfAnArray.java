package codewars.equalSidesOfAnArray;

import java.util.Arrays;
import java.util.stream.IntStream;

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
