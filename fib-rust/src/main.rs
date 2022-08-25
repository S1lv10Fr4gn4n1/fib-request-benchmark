#[macro_use] extern crate rocket;

use num_bigint::BigUint;
use num_traits::{Zero, One};
use std::mem::replace;

#[get("/fib?<n>")]
fn fib(n: i32) -> String {
    return fibonacci(n).to_string();
}

#[launch]
fn rocket() -> _ {
    rocket::build().mount("/", routes![fib])
}

fn fibonacci(n: i32) -> BigUint {
    let mut f0: BigUint = Zero::zero();
    let mut f1: BigUint = One::one();
    for _ in 0..n {
        let f2 = f0 + &f1;
        // This is a low cost way of swapping f0 with f1 and f1 with f2.
        f0 = replace(&mut f1, f2);
    }
    f0
}