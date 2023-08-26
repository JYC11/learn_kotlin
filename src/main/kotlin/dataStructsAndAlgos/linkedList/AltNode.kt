package dataStructsAndAlgos.linkedList

data class AltNode<T : Any>(var value: T, var next: AltNode<T>? = null, var previous: AltNode<T>? = null) {
    override fun toString(): String {
        return if (next != null) {
            "$value -> ${next.toString()}"
        } else {
            "$value"
        }
    }
}