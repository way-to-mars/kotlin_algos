fun String.rle(): String {
    var indexer = 1
    return this.asSequence().fold(mutableListOf<Char>()) { list, ch ->
        if (ch == list.lastOrNull()) indexer++
        else {
            list.addInt(indexer)
            indexer = 1
            list.add(ch)
        }
        if (ch !in 'A'..'Z') throw IllegalArgumentException("The string might contain only A-Z symbols")
        list
    }
        .addInt(indexer)
        .joinToString(separator = "")
}

fun MutableList<Char>.addInt(value: Int): MutableList<Char> {
    if (value > 1) this.addAll(value.toString().toList())
    return this
}