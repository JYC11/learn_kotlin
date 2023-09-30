package dataStructsAndAlgos.avlTree

fun avlTreeDemo() {
    val tree = AVLTree<Int>()
    (0..14).forEach {
        tree.insert(it)
    }
    print(tree)

    val otherTree = AVLTree<Int>().apply {
        insert(15)
        insert(10)
        insert(16)
        insert(18)
    }
    print(otherTree)
    otherTree.remove(10)
    print(otherTree)
}