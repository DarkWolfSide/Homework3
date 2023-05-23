fun main(args: Array<String>) {
//  Task 172
    val number = 9
    val result = twoFactorial(number)
    println("Factorial of $number is: $result")

//  Task 173
    val N = 10
    val A = 0
    val B = 100

    val segmentLength = (B - A) / N
    var currentPoint = A
    println("Segments:")
    repeat(N) {
        val startPoint = currentPoint
        val endPoint = currentPoint + segmentLength
        println("$startPoint - $endPoint")
        currentPoint = endPoint
    }

//  Task 176
    val fib = 10
    println("Fibonacci sequence up to $fib:")
    for (i in 0..fib) {
        println(fibonacci(i))
    }

//  Task 179
    val N1 = 27
    val K = 4

    val (quotient, remainder) = divide(N1, K)
    println("quotient: $quotient")
    println("remainder: $remainder")

//  Task 180
    val base = 2
    val num = 16

    val isPower = isPowerOf(base, num)
    if (isPower) {
        println("$num is a power of $base")
    } else {
        println("$num is not a power of $base")
    }

// Task 181
    val n1 = 128
    val exponent = findExponent(n1)
    println("The exponent 'k' for N = $n1 is: $exponent")

//  Task 183
    val n2 = 26
    val k = findsmallestK(n2)
    println("The smallest value of k where 3^k > $n2 is $k")

//  Task 184
    val n3 = 28
    val k1 = findsmallestK(n3) - 1
    println("The biggest value of k where 3^k < $n3 is $k1")

//  Task 185
    var count = 0
    var avand = 30000
    val P = 20
    do{
        count++
        avand += avand * P / 100
    } while(avand<100000)
    println("Months: $count")
    println("last avand: : $avand")

//  Task 186
    var daysCount = 0
    var distance = 20
    val p = 20
    do{
        daysCount++
        distance += distance * p / 100
    } while(distance<80)
    println("Days: $daysCount")
    println("Total distance: $distance")

//  Task 187
    val numb = 19
    println("number isEven: ${isPrime(numb)}")

//  Task 188
    val fibonacci = 14
    println("is Fibonacci number: ${isFibonacciNumber(fibonacci,0,1)}")

//  Task 189
    val someNum = 35
    println("Greather Fibonacci number is: ${FibonacciNumber(someNum,0,1)}")
}

fun isFibonacciNumber(number: Int, a: Int, b: Int): Boolean {
    if (b == number) {
        return true
    }
    if (b > number) {
        return false
    }
    return isFibonacciNumber(number, b, a + b)
}

fun FibonacciNumber(number: Int, a: Int, b: Int): Int {
    if (b > number) {
        return b
    }
    return FibonacciNumber(number, b, a + b)
}

fun isPrime(numb: Int): Boolean {
    for (i in 2 until numb) {
        if (numb % i == 0) {
            return false
        }
    }
    return true
}

fun findsmallestK(N: Int, power: Int = 1, k: Int = 0): Int {
    if (power > N) {
        return k
    }
    return findsmallestK(N, power * 3, k + 1)
}

fun findExponent(N: Int): Int {
    return when (N) {
        1 -> 0
        else -> 1 + findExponent(N / 2)
    }
}


fun isPowerOf(base: Int, number: Int): Boolean {
    return when {
        number < 1 -> false
        number == 1 -> true
        number % base != 0 -> false
        else -> isPowerOf(base, number / base)
    }
}

fun twoFactorial(num: Int): Int {
    return if (num == 0 || num == 1) {
        1
    } else {
        num * twoFactorial(num - 2)
    }
}

fun fibonacci(n: Int): Long {
    return if (n <= 1) {
        n.toLong()
    } else {
        fibonacci(n - 1) + fibonacci(n - 2)
    }
}

fun divide(N: Int, K: Int): Pair<Int, Int> {
    return if (N < K) {
        Pair(0, N)
    } else {
        val (quotient, remainder) = divide(N - K, K)
        Pair(quotient + 1, remainder)
    }
}