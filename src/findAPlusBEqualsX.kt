
// Дана последовательность положительных чисел динной N и число X
// Найти два различных числа
// 1. Полный перебор O(N^2)
fun findAPlusBEqualsX(list: List<Int>, x: Int): Pair<Int, Int> {
    val size = list.size
    val enumerable = list.asSequence()
    var res1 = 0
    var res2 = 0

    enumerable.take(size - 1).withIndex().filter { a ->
        enumerable
            .drop(a.index + 1)
            .filter { b -> (a.value != b) && (a.value + b == x) }
            .firstOrNull()?.also {
                res1 = a.value
                res2 = it
                println("found a couple: $res1 to $res2 >> index = ${a.index}")
            } != null
    }.firstOrNull()

    return res1 to res2
}

// 2. Преобразованием в множество
fun findAPlusBEqualsX2(list: List<Int>, x: Int): Pair<Int, Int> {
    val set = list.toSet()
    val size = set.size
    val seq = set.asSequence()
    var res1 = 0
    var res2 = 0

    seq.take(size-1).withIndex().filter { a ->
        seq
            .drop(a.index + 1)
            .filter { b -> a.value + b == x }
            .firstOrNull()?.also {
                res1 = a.value
                res2 = it
                println("found a couple: $res1 to $res2 >> index = ${a.index}")
            } != null
    }.firstOrNull()

    return res1 to res2
}

// 3. С созданием множества уже известных чисел
fun findAPlusBEqualsX3(list: List<Int>, x: Int): Pair<Int, Int> {
    val knownNumbers = mutableSetOf<Int>()
    list.forEach {
        if (x - it in knownNumbers) return it to (x - it)
        knownNumbers.add(it)
    }
    return 0 to 0
}