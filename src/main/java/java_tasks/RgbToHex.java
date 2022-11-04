package java_tasks;

/*
https://www.codewars.com/kata/513e08acc600c94f01000001/java
*/
public class RgbToHex {
    public static String rgb(int r, int g, int b) {
        return String.format("%02X%02X%02X",
                r >= 0 ? Math.min(r, 255) : 0,
                g >= 0 ? Math.min(g, 255) : 0,
                b >= 0 ? Math.min(b, 255) : 0);
    }
}
