fun pitCraft(input: IntArray): Int{
    require(input.size >= 2) { "The island is too small!" }
    val maxIndex = input.indexOfFirst { it == input.max() }

    return input.asSequence().take(maxIndex).sumWater() +
            input.reversed().asSequence().take(input.lastIndex - maxIndex).sumWater()
}

fun Sequence<Int>.sumWater(): Int{
    var cmax = 0
    return this.fold(0) { sum, c ->
        cmax = kotlin.math.max(c, cmax)
        sum + cmax - c
    }
}