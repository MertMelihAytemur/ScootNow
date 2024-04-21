package tr.com.mermela.core

interface Factory<T> {
    fun create(): T
}