// На шахматной доске N x N находятся M ладей (rooks)
// Определите сколько пар ладей бьют друг друга
// Ладьи задаются парой чисел I и J, обозначающих координаты клетки
// 1 <= N <= 10^9   0 <= M <= 2 * 10^5

fun solveChess(rooks: List<Pair<Int, Int>>): Int {
    val x = mutableMapOf<Int, Int>()
    val y = mutableMapOf<Int, Int>()

    rooks.forEach { pair ->
        x[pair.first] = x.getOrDefault(pair.first, 0) + 1
        y[pair.second] = x.getOrDefault(pair.second, 0) + 1
    }

    return x.values.asSequence().filter { it > 1 }.sumOf { it - 1 } +
           y.values.asSequence().filter { it > 1 }.sumOf { it - 1 }
}

fun solveChess2(rooks: List<Pair<Int, Int>>): Int {
    val x = mutableMapOf<Int, Int>()
    val y = mutableMapOf<Int, Int>()

    rooks.forEach { pair ->
        x[pair.first] = x.getOrDefault(pair.first, 0) + 1
        y[pair.second] = x.getOrDefault(pair.second, 0) + 1
    }

    return x.values.fold(0) { sum, it -> sum + if (it > 1) it - 1 else 0} +
           y.values.fold(0) { sum, it -> sum + if (it > 1) it - 1 else 0}
}


/*
*  | 1 1 1 0 0     1 -> 0
* ------------     2 -> 1
* 1| x             3 -> 2
* 0|               ...
* 2|   x x         n -> n - 1
* 0|
*/