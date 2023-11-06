package dataStructsAndAlgos.trie

fun trieDemo() {
//    val trie = Trie<Char>()
//    trie.insert("cute")
//    if (trie.contains("cute")) {
//        println("cute is in the trie")
//    }

    val trie = Trie<Char>()
    trie.insert("cut")
    trie.insert("cute")
    println("\n*** Before removing ***")
    assert(trie.contains("cut"))
    println("\"cut\" is in the trie")
    assert(trie.contains("cute"))
    println("\"cute\" is in the trie")
    println("\n*** After removing cut ***")
    trie.remove("cut")
    assert(!trie.contains("cut"))
    assert(trie.contains("cute"))
    println("\"cute\" is still in the trie")

    val carTrie = Trie<Char>().apply {
        insert("car")
        insert("card")
        insert("care")
        insert("cared")
        insert("cars")
        insert("carbs")
        insert("carapace")
        insert("cargo")
    }
    println("\nCollections starting with \"car\"")
    val prefixedWithCar = carTrie.collections("car")
    println(prefixedWithCar)
    println("\nCollections starting with \"care\"")
    val prefixedWithCare = carTrie.collections("care")
    println(prefixedWithCare)
}