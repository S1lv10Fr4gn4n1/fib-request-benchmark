package sfs.benchmark.fibspring;

import java.math.BigInteger;

public class FibonacciNumber {

    public BigInteger get(Integer n) {
        return fib(n);
    }

    private BigInteger fib(Integer n) {
        if (n <= 1) {
            return BigInteger.valueOf(n);
        }

        var a = BigInteger.ZERO;
        var b = BigInteger.ONE;
        var c = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            c = a.add(b);
            a = b;
            b = c;
        }

        return c;
    }
}
