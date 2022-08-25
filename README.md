# fib-request-benchmark

Benchmark different languages on Fibonacci sequence (dynamic programming, no cache).

## Steps to reproduce
- inside of almost all projects, there is a `Dockerfile`, please build it before the test (Spring projects use gradle task to build it)
- running the Docker with fixed resources like:
    -  `docker run --rm -it -d --cpus 4.0 --memory 4g -p 8080:8080 --name fib <image_name>`
- run [ab - Apache HTTP server benchmarking tool](https://httpd.apache.org/docs/2.4/programs/ab.html)
    - `ab -n 60000 -c 200 -m GET localhost:8080/fib?n=10000`

## Results
Benchmark ran on a MSI laptop:
- Intel® Core™ i7-7700HQ CPU @ 2.80GHz × 8
- 32GB RAM
- Ubuntu 18.04


### Java and [javalin](https://javalin.io/)
- Started in 270ms
- Requests per second:    604.99 [#/sec] (mean)
- Requests per second:    670.25 [#/sec] (mean)
- Requests per second:    752.64 [#/sec] (mean)
- Final RAM 1.308GiB


### Java and [SparkJava](https://sparkjava.com/)
- Started in 258ms
- Requests per second:    434.14 [#/sec] (mean)
- Requests per second:    496.53 [#/sec] (mean)
- Requests per second:    481.66 [#/sec] (mean)
- Final RAM 1.079GiB


### Java and [Spring](https://spring.io/)
- Started in 2.375sec
- Requests per second:    460.81 [#/sec] (mean)
- Requests per second:    495.52 [#/sec] (mean)
- Requests per second:    485.36 [#/sec] (mean)
- Final RAM 2.276GiB


### Java and [Spring native](https://docs.spring.io/spring-native/docs/current/reference/htmlsingle/)
- Started in 0.039 seconds
- Requests per second:    641.03 [#/sec] (mean)
- Requests per second:    695.51 [#/sec] (mean)
- Requests per second:    599.12 [#/sec] (mean)
- Final RAM 781.6MiB


### Go and [Gin](https://gin-gonic.com/)
- Started in no logs, but 100-500ms for sure
- Requests per second:    1692.62 [#/sec] (mean)
- Requests per second:    1756.52 [#/sec] (mean)
- Requests per second:    1881.97 [#/sec] (mean)
- Final RAM 16.41MiB


### Rust and [Rocket](https://rocket.rs/)
- Started in no logs, but 100-500ms for sure
- Requests per second:    5422.99 [#/sec] (mean)
- Requests per second:    5781.83 [#/sec] (mean)
- Requests per second:    5744.30 [#/sec] (mean)
- Final RAM 10.71MiB