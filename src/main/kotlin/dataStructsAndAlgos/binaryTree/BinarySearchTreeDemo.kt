package dataStructsAndAlgos.binaryTree

fun binarySearchTreeDemo() {
    val bst = BinarySearchTree<Int>()
    (0..4).forEach {
        bst.insert(it)
    }
    println(bst)

    val exampleTree = BinarySearchTree<Int>().apply {
        insert(3)
        insert(1)
        insert(4)
        insert(0)
        insert(2)
        insert(5)
    }
    println(exampleTree)

    if (exampleTree.contains(5)) {
        println("Found 5")
    } else {
        println("Couldn't find 5")
    }

    exampleTree.remove(3)
    println(exampleTree)
}