package java_tasks;

/*
https://www.codewars.com/kata/55c45be3b2079eccff00010f
*/
public class Order {
    public static String order(String words) {
        if (words.isEmpty()) {
            return "";
        }
        String [] arr_str = words.split(" ");
        String [] res = new String[arr_str.length];
        for (String tmp : arr_str) {
            int ind = Integer.parseInt(tmp.replaceAll("[a-zA-Z]", "")) - 1;
            res[ind] = tmp;
        }
        return String.join(" ", res);
    }
}
