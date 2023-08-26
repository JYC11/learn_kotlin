package dataStructsAndAlgos.queue

class RingBufferQueue<T : Any>(size: Int) : IQueue<T> {
    private val ringBuffer: RingBuffer<T> = RingBuffer(size)
    override fun enqueue(element: T): Boolean =
        ringBuffer.write(element)

    override fun dequeue(): T? =
        if (isEmpty) null else ringBuffer.read()

    override val count: Int
        get() = ringBuffer.count

    override fun peek(): T? = ringBuffer.first

    override fun toString(): String = ringBuffer.toString()
}