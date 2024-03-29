package dataStructsAndAlgos.linkedList

fun linkedListDemo() {
    val list = LinkedList<Int>()
    list.push(3).push(2).push(1)
    println(list)

    var middleNode = list.nodeAt(1)!!
    for (i in 1..3) {
        middleNode = list.insert(-1 * i, middleNode)
    }

    println(list)

    val list2 = LinkedList<Int>()
    list2.append(4).append(5).append(6)
    println(list2)
    val poppedValue = list2.pop()
    println(list2)
    println(poppedValue)
    list2.push(4)
    val removedValue = list2.removeLast()
    println(list2)
    println(removedValue)
    list2.append(6)

    val index = 1
    val node = list.nodeAt(index - 1)!!
    val removedValue2 = list.removeAfter(node)
    println(list)
    println(removedValue2)
    for (item in list) {
        println(item)
    }
    println("standard reverse")
    list.printInReverse()
    println()
    println("reverse with stack")
    list.printInReverseWithStack()
    println()
    println(list.getMiddle()?.value)
    println(list.reversed())

    val list3 = LinkedList<Int>()
    list3.append(1).append(3).append(5)
    println(list3)

    val list4 = LinkedList<Int>()
    list4.append(2).append(4).append(6)
    println(list4)

    println(list3.mergeSorted(list4))
}