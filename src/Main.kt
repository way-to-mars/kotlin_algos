import kotlin.system.measureTimeMillis

fun main() {


}

fun <T> printWithMilliseconds(block: () -> T): T {
    var result: T
    val time = measureTimeMillis {
        result = block.invoke()
    }
    println("Time = ${time}ms")
    return result
}

fun <T> List<T>.toCroppedString(): String {
    val size = this.size
    return when {
        size <= 10 -> this.toString()
        else -> {
            val head = this.take(5).joinToString(separator = ", ")
            val tail = this.takeLast(5).joinToString(separator = ", ")
            "[$head ... $tail] size=$size"
        }
    }
}









