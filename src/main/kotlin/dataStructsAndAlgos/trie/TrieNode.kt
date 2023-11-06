package dataStructsAndAlgos.trie

class TrieNode<Key>(var key: Key?, var parent: TrieNode<Key>?) {
    var children: HashMap<Key, TrieNode<Key>> = HashMap()
    var isTerminating = false
}