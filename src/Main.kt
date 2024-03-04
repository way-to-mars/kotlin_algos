import kotlin.random.Random
import kotlin.time.measureTime

fun main() {
    //val input = readln().split(" ").mapNotNull(String::toIntOrNull)
    val input = (1..10_000_000).map { Random.nextInt(1_000_000) }
}










