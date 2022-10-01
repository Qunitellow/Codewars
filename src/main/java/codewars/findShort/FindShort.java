package codewars.findShort;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class FindShort {
    public static int findShort(String s) {
        return Collections.min(Arrays.stream(s.split(" "))
                .map(String::length)
                .collect(Collectors.toList()));
    }
}
