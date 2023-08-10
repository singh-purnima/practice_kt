package purnima

class MyLinkedList<T> {

    class Node<T>(var value: T, var next: Node<T>? = null)

    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    fun append(value: T) {
        val t = Node(value) // temporary node
        if (isEmpty) {  // empty list
            head = t
            tail = t
        } else { // Non-empty list
            tail?.next = t
            tail = t
        }
    }

    fun prepend(value: T) {
        val t = Node(value)
        if (isEmpty) {
            head = t
            tail = t
        } else {
            t.next = head
            head = t
        }
    }

    val length: Int
        get() {
            var count = 0
            var t = head
            while (t != null) {
                count++
                t = t.next
            }
            return count
        }

    val isEmpty: Boolean
        get() = head == null

    val first: T?
        get() = head?.value

    val last: T?
        get() = tail?.value

    fun oldLength(): Int {
        var count = 0
        var t = head
        while (t != null) {
            count++
            t = t.next
        }
        return count
    }

    fun toList(): List<T> {
        val result = mutableListOf<T>()
        var t = head
        while (t != null) {
            result.add(t.value)
            t = t.next
        }
        return result
    }

    fun getAt(idx: Int): T? {
        var pos = 0
        var t = head
        while (t != null) {
            if (pos == idx) {
                return t.value
            }
            pos++
            t = t.next
        }

        return null
    }

    fun indexOf(value: T): Int? {
        var t = head
        var pos = 0

        while (t != null) {
            if (value == t.value) {
                return pos
            }
            pos++
            t = t.next
        }
        return null
    }

    fun removeAt(idx: Int) {

        if (idx < 0) {
            throw IndexOutOfBoundsException("Idx is negative.")
        }
        if (head == null) {
            throw IndexOutOfBoundsException("List is empty.")
        }

        if (idx == 0) { // first node
            val t = head?.next
            head?.next = null
            head = t
            if (head == null) {
                tail = null
            }
            return
        }

        var c = head
        var pos = 0

        var p = c
        while (c != null) {
            if (pos == idx) { // found it, delete
                p?.next = c.next
                c.next = null
                break
            }
            pos++
            p = c
            c = c.next
        }

        if (p?.next == null) { // last node
            tail = p
        }
        if (c == null) {
            throw IndexOutOfBoundsException("Idx is greater than list length.")
        }
    }

    fun insertAt(idx: Int, value: T) {
        TODO()
    }
}