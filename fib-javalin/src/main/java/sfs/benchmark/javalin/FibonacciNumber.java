package sfs.benchmark.javalin;

import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;

public class FibonacciNumber {

    @NotNull
    public BigInteger get(@NotNull Integer n) {
        return fib(n);
    }

    @NotNull
    private BigInteger fib(@NotNull Integer n) {
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
