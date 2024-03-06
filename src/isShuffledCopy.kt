// Дано два числа без ведущих нулей
// Необходимо проверить, можно ли получить первое из второго перестановкой циоф

// 72 (55) ms per 10_000
fun isShuffledCopy(a: Long, b: Long) = a.toString().toCharArray().sorted() == b.toString().toCharArray().sorted()

// 20 (17) ms per 10_000
fun isShuffledCopy2(a: Long, b: Long): Boolean {
    fun long2digits(value: Long): Sequence<Int> {
        val result = mutableListOf<Int>()
        var x = value
        while (x > 0) {
            val d = (x % 10).toInt()
            x /= 10
            result.add(d)
        }
        return result.asSequence()
    }

    val digits = IntArray(11) { 0 }
    long2digits(a).forEach { digits[it]++ }
    long2digits(b).forEach { digits[it]-- }
    return digits.all { it == 0 }
}

// 7 (6) ms per 10_000
fun isShuffledCopy3(a: Long, b: Long): Boolean {
    val digits = IntArray(10) { 0 }
    var x = a
    while (x > 0) {
        digits[(x % 10).toInt()]++
        x /= 10
    }
    x = b
    while (x > 0) {
        digits[(x % 10).toInt()]--
        x /= 10
    }
    return digits.all { it == 0 }
}