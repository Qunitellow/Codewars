package java_tasks.greedIsGood;

import java.util.Arrays;

public class Greed {
    public static int greedy(int[] dice) {
        Arrays.sort(dice);
        String input = Arrays.toString(dice).replaceAll("\\D+", "");

        Integer sum = 0;
        if (input.contains("111")) {
            sum+=1000;
            input = input.replaceAll("111", "");
        } else if (input.contains("222")) {
            sum+=200;
            input = input.replaceAll("222", "");
        } else if (input.contains("333")) {
            sum+=300;
            input = input.replaceAll("333", "");
        } else if (input.contains("444")) {
            sum+=400;
            input = input.replaceAll("444", "");
        } else if (input.contains("555")) {
            sum+=500;
            input = input.replaceAll("555", "");
        } else if (input.contains("666")) {
            sum+=600;
            input = input.replaceAll("666", "");
        }
        for (int i = 0; i < input.toCharArray().length; i++) {
            if (input.toCharArray()[i] == '1') {
                sum+=100;
            } else if (input.toCharArray()[i] == '5') {
                sum+=50;
            }
        }
        return sum;
    }
}