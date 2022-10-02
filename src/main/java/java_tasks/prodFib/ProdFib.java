package java_tasks.prodFib;

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
