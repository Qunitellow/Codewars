package java_tasks;

import java_tasks.codeSpeed.CodeSpeed;

/*
https://www.codewars.com/kata/5270d0d18625160ada0000e4/java
*/
public class Greed {
    public static int greedy(int[] dice) {
        int numDupl[] = new int[7];
        for (int num : dice) numDupl[num]++;
        return numDupl[1] / 3 * 1000 + numDupl[1] % 3 * 100 + numDupl[2] / 3 * 200 + numDupl[3] / 3 * 300 +
                numDupl[4] / 3 * 400 + numDupl[5] / 3 * 500 + numDupl[5] % 3 * 50 + numDupl[6] / 3 * 600;
    }
}