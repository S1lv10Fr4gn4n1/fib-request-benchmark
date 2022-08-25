package sfs.benchmark.spark;

import static spark.Spark.get;
import static spark.Spark.port;

public class Controller {

    public static void main(String[] args) {
        var fib = new FibonacciNumber();

        port(8080);
        get("/fib", (req, res) -> {
            var n = req.queryParams("n");
            var fibNumber = fib.get(Integer.valueOf(n));
            res.status(200);
            return fibNumber.toString();
        });
    }
}
