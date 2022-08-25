package sfs.benchmark.javalin;

import io.javalin.Javalin;
import io.javalin.http.HttpCode;

public class Controller {

    public static void main(String[] args) {
        // setup Javalin
        var app = Javalin.create(config -> {
//            config.enableDevLogging();
//            config.ignoreTrailingSlashes = true;
//            config.showJavalinBanner = false;
        });
        app.start(8080);

        var fib = new FibonacciNumber();
        app.get("/fib", ctx -> {
            var n = ctx.queryParam("n");
            var fibNumber = fib.get(Integer.valueOf(n));
            ctx.status(HttpCode.OK);
            ctx.result(fibNumber.toString());
        });
    }
}
