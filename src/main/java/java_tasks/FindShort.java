package java_tasks;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/*
https://www.codewars.com/kata/57cebe1dc6fdc20c57000ac9
*/
public class FindShort {
    public static int findShort(String s) {
        return Collections.min(Arrays.stream(s.split(" "))
                .map(String::length)
                .collect(Collectors.toList()));
    }
}
