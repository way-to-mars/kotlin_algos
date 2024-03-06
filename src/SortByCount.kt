// Сортировка подсчетом
fun sortByCount6(list: List<Int>): List<Int> {
    val counts = IntArray(6) { 0 }
    list.forEach { counts[it]++ }
    return (1..5).flatMap { i -> (1..counts[i]).map { i } }
}

fun sortByCount(list: List<Int>): List<Int> {
    val min = list.min()
    val max = list.max()
    val k = max - min + 1
    val counts = IntArray(k) { 0 }
    list.forEach { counts[it - min]++ }
    return (0..<k).flatMap { i -> (1..counts[i]).map { i + min } }
}