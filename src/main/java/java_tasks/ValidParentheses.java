package java_tasks;

/*
https://www.codewars.com/kata/52774a314c2333f0a7000688
*/
public class ValidParentheses {
    public static boolean validParentheses(String parens) {
        if (parens.startsWith(")")) return false;
        parens = parens.replaceAll("[^()]", "");
        while (parens.contains("()")) {
            parens = parens.replaceAll("\\(\\)", "");
        }
        return parens.isEmpty();
    }
}
