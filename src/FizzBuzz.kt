fun fizzBuzz(maxNumber: Int){
    for (i in 1..maxNumber)
        when
        {
            i % 15 == 0 -> println("Fizz Buzz ($i)")
            i % 5 == 0 -> println("Buzz ($i)")
            i % 3 == 0 -> println("Fizz ($i)")
            else -> println(i)
        }
}