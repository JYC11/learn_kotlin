package dataStructsAndAlgos.binaryTree

fun binaryTreeDemo() {
    val zero = BinaryNode(0)
    val one = BinaryNode(1)
    val five = BinaryNode(5)
    val seven = BinaryNode(7)
    val eight = BinaryNode(8)
    val nine = BinaryNode(9)
    seven.leftChild = one
    one.leftChild = zero
    one.rightChild = five
    seven.rightChild = nine
    nine.leftChild = eight
    println(seven)
    println("in order")
    seven.traverseInOrder { println(it) }
    println("\npre order")
    seven.traversePreOrder { println(it) }
    println("\npost order")
    seven.traversePostOrder { println(it) }

    println("height is ${seven.height()}")
    println("serialized: ${seven.serialize()}")
    println("deserialized: ${seven.deserialize(seven.serialize())}")
    println("deserialized optimized: ${seven.deserializeOptimized(seven.serialize())}")
}