package dataStructsAndAlgos.queue

import dataStructsAndAlgos.linkedList.DoublyLinkedList

class LinkedListQueue<T : Any> : IQueue<T> {
    private val list = DoublyLinkedList<T>()
    private var size = 0
    override fun enqueue(element: T): Boolean {
        list.append(element)
        size++
        return true
    }

    override fun dequeue(): T? {
        val firstNode = list.first ?: return null
        size--
        return list.remove(firstNode)
    }

    override val count: Int
        get() = size

    override fun peek(): T? = list.first?.value
}