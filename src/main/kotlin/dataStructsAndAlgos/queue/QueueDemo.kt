package dataStructsAndAlgos.queue

fun queueDemo() {
    println("array list queue")
    val queue = ArrayListQueue<String>().apply {
        enqueue("Ray")
        enqueue("Brian")
        enqueue("Eric")
    }
    println(queue)
    queue.dequeue()
    println(queue)
    println("Next up: ${queue.peek()}")

    println("\nlinked list queue")
    val llQueue = LinkedListQueue<String>().apply {
        enqueue("Ray")
        enqueue("Brian")
        enqueue("Eric")
    }
    println(llQueue)
    llQueue.dequeue()
    println(llQueue)
    println("Next up: ${llQueue.peek()}")

    println("\nring buffer queue")
    val rbQueue = RingBufferQueue<String>(10).apply {
        enqueue("Ray")
        enqueue("Brian")
        enqueue("Eric")
    }
    println(rbQueue)
    rbQueue.dequeue()
    println(rbQueue)
    println("Next up: ${rbQueue.peek()}")

    println("\ndouble stack queue")
    val dsQueue = StackQueue<String>().apply {
        enqueue("Ray")
        enqueue("Brian")
        enqueue("Eric")
    }
    println(dsQueue)
    dsQueue.dequeue()
    println(dsQueue)
    println("Next up: ${dsQueue.peek()}")
}