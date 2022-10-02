package java_tasks.validParentheses;

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
