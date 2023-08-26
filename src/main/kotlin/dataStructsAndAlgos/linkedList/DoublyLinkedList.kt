package dataStructsAndAlgos.linkedList

class DoublyLinkedList<T : Any> {

    fun isEmpty(): Boolean {
        return head == null
    }

    private var head: AltNode<T>? = null
    private var tail: AltNode<T>? = null


    override fun toString(): String {
        if (isEmpty()) {
            return "Empty list"
        }
        return head.toString()
    }


    fun append(value: T) {

        val newNode = AltNode(value = value, previous = tail)
        if (isEmpty()) {
            head = newNode
            tail = newNode
            return
        }

        tail?.next = newNode

        tail = newNode
    }

    fun node(index: Int): AltNode<T>? {
        // 1
        var currentNode = head
        var currentIndex = 0

        // 2
        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex += 1
        }

        return currentNode
    }

    fun remove(node: AltNode<T>): T {

        val prev = node.previous
        val next = node.next

        if (prev != null) {
            prev.next = next
        } else {
            head = next
        }

        next?.previous = prev

        if (next == null) {
            tail = prev
        }

        node.previous = null
        node.next = null

        return node.value
    }

    val first: AltNode<T>?
        get() = head

}