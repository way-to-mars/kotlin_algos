/* Дана строка S
Выведите гистограмму как в примере (коды символов отсортированы)
S = Hello, world!

      #
      ##
##########
 !,Hdelorw
*/


fun main() {
    val string = readln()
    val nx = string.groupingBy { it }.eachCount().asSequence().map {
        it.key to it.value
    }.sortedBy { it.first.code }
    val maxOcc = nx.maxBy { it.second }.second
    for (i in maxOcc downTo 1) {
        nx.map { if (it.second >= i) "#" else " " }
            .joinToString(separator = "")
            .also { println(it) }
    }
    nx.map { it.first }.joinToString(separator = "").also { println(it) }
}