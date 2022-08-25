package sfs.benchmark.fibspringnative;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private FibonacciNumber fibonacciNumber = new FibonacciNumber();

    @GetMapping(value = "/fib")
    @ResponseBody
    public String fib(@RequestParam Integer n) {
        return fibonacciNumber.get(n).toString();
    }
}
