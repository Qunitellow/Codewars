package java_tasks.nextBiggerNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NextBiggerNumber {
    public static long nextBiggerNumber(long n) {
        List<Long> arrNum = new ArrayList<>();
        while (n > 0) {
            arrNum.add(0, n % 10);
            n = n / 10;
        }
        if (arrNum.size() == 1)
            return -1;
        for (int i = arrNum.size() - 1; i >= 0; i--) {
            if (i > 0 && arrNum.get(i) > arrNum.get(i - 1)) {
                long temp = arrNum.get(i);
                arrNum.remove(i);
                arrNum.add(i - 1, temp);
                List<Long> arrNum2 = arrNum.subList(i, arrNum.size());
                List<Long> arrNumCopy = new ArrayList<>(List.copyOf(arrNum2));
                arrNum.subList(i, arrNum.size()).clear();
                Collections.sort(arrNumCopy);
                arrNum.addAll(arrNumCopy);

                return Long.parseLong(arrNum.toString().replaceAll("\\D", ""));
            }
        }
        return -1;
    }
}
