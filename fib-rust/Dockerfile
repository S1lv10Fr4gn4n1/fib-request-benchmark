# Build stage
FROM rust:1.63.0-slim as builder

WORKDIR /app

COPY . .

RUN cargo build --profile release


# Runtime stage
FROM rust:1.63.0-slim as runner

WORKDIR /app

COPY --from=builder /app/target/release/rust-fib ./rust-fib

# not sure why, but it was not getting the settins from Cargo.toml
ENV ROCKET_PORT=8080
ENV ROCKET_ADDRESS='0.0.0.0'

EXPOSE 8080

CMD ["./rust-fib"]