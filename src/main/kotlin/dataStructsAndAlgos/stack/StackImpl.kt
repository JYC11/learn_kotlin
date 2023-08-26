package dataStructsAndAlgos.stack

interface IStack<Element> {
    fun peek(): Element?
    val count: Int
    val isEmpty: Boolean
        get() = count == 0

    fun push(element: Element)
    fun pop(): Element?
}

class StackImpl<Element> : IStack<Element> {
    private val storage = arrayListOf<Element>()
    override val count: Int
        get() = storage.size
    override val isEmpty: Boolean
        get() = count == 0

    companion object {
        fun <Element> create(items: Iterable<Element>): StackImpl<Element> {
            val stack = StackImpl<Element>()
            for (item in items) {
                stack.push(item)
            }
            return stack
        }
    }

    override fun peek(): Element? {
        if (isEmpty) {
            return null
        }
        return storage.removeAt(count - 1)
    }

    override fun toString() = buildString {
        appendLine("----top----")
        storage.asReversed().forEach {
            appendLine("$it")
        }
        appendLine("-----------")
    }

    override fun push(element: Element) {
        storage.add(element)
    }

    override fun pop(): Element? {
        if (storage.size == 0) {
            return null
        }
        return storage.removeAt(storage.size - 1)
    }
}

fun <Element> stackOf(vararg elements: Element): StackImpl<Element> {
    return StackImpl.create(elements.asList())
}

fun String.checkParenthesis(): Boolean {
    val stack = StackImpl<Char>()
    for (character in this) {
        when (character) {
            '(' -> stack.push(character)
            ')' -> if (stack.isEmpty) {
                return false
            } else {
                stack.pop()
            }
        }
    }
    return stack.isEmpty
}