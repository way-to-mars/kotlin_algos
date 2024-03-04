class MySet {
    private var hashSize = 10

    // x2 расширение в два раза

    private var hashArray = emptyHash(hashSize)

    private fun hashFunc(value: Int): Int = value % hashSize
    private fun emptyHash(size: Int): Array<MySingleLinkedSet<Int>> = Array(size) { MySingleLinkedSet() }

    fun add(value: Int): Boolean = hashArray[hashFunc(value)].add(value)
    fun remove(value: Int) = hashArray[hashFunc(value)].remove(value)
    fun contains(value: Int) = hashArray[hashFunc(value)].contains(value)
    override fun toString() = "MySet(hashSize=$hashSize, hashArray=${hashArray.contentToString()})"
 //   fun toList() = hashArray.flatMap { it.asSequence() }
}


class MySingleLinkedSet<T : Comparable<T>> : Iterable<T> {
    private inner class Node<T>(var value: T, var next: Node<T>?)

    private var size = 0
    private var head: Node<T>? = null

    fun add(value: T): Boolean {
        if (head == null || head!!.value > value) {
            val newNode = Node(value, head)
            head = newNode
            size = 1
            return true
        }

        var curr = head
        while (curr != null) {
            if (curr.value == value) return false
            val next = curr.next
            if (next == null || next.value > value) {
                val newNode = Node(value, next)
                curr.next = newNode
                size++
                return true
            }
            curr = next
        }
        throw UnsupportedOperationException("Unreachable code reached!")
    }

    fun remove(value: T): Boolean {
        var curr = head
        var prev: Node<T>? = null
        while (curr != null) {
            if (curr.value == value) {
                if (prev == null) {
                    head = curr.next
                } else {
                    prev.next = curr.next
                }
                size--
                return true
            }
            prev = curr
            curr = curr.next
        }
        return false
    }

    fun contains(value: T): Boolean {
        var curr = head
        while (curr != null) {
            if (curr.value == value) return true
            curr = curr.next
        }
        return false
    }

    override fun iterator(): Iterator<T> {
        TODO("Not yet implemented")
    }

    override fun toString(): String {
        var curr = head

        val sb = StringBuilder()
        sb.append('[')
        while (curr != null) {
            sb.append(curr.value)
            curr = curr.next
            if (curr != null) sb.append(", ")
        }
        sb.append(']')
        return sb.toString()
    }
}

