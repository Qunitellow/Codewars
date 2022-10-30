package java_tasks;

/*
https://www.codewars.com/kata/5541f58a944b85ce6d00006a
*/
public class ProdFib {
    public static long[] productFib(long prod) {
        long num1 = 0;
        long num2 = 1;
        while (num1 * num2 < prod) {
            long tmp = num1 + num2;
            num1 = num2;
            num2 = tmp;
        }
        if (num1 * num2 == prod)
            return new long[]{num1, num2, 1};
        else
            return new long[]{num1, num2, 0};
    }
}
