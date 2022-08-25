package main

import (
	"fmt"
	"math/big"
	"strconv"
	"net/http"
	"github.com/gin-gonic/gin"
)

func main() {
	fmt.Println("Hello world")
	router := gin.Default()
	router.GET("/fib", getFib)
	router.Run("0.0.0.0:8080")
}

func getFib(c *gin.Context) {
	paramN := c.DefaultQuery("n", "1")
	n, _ := strconv.ParseInt(paramN, 10, 64)
	fibNumber := fib(n)
	res := fmt.Sprintf("%s World, n:%d -> %d", "Hello", n, fibNumber)
	c.String(http.StatusOK, res)
}

func fib(n int64) *big.Int {
	a := big.NewInt(0)
	b := big.NewInt(1)
	c := big.NewInt(1)

	var i int64
	for i = 2; i <= n; i++ {
		c.Add(a, b)
		a = b
		b = c
	}

	return c
}