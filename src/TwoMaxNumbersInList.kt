fun solve(input: List<Int>): Pair<Int, Int> {
    require(input.size >= 2) { "IllegalArgument in 'solve'. Array must contain at least 2 items" }
    var max1 = input[0]
    var max2 = input[0]
    var secondFound = false

    for (i in 1..input.lastIndex) {
        val current = input[i]

        if (!secondFound) {
            if (current < max2) {
                max2 = current
                secondFound = true
            } else if (current > max1) {
                max1 = current
                secondFound = true
            }
        } else when {
            current in (max2 + 1)..<max1 -> max2 = current
            current > max1 -> {
                max2 = max1
                max1 = current
            }
        }
    }
    return Pair(max1, max2)
}
