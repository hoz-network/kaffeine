package network.hoz.kaffeine

import com.github.benmanes.caffeine.cache.Cache

operator fun <K, V> Cache<in K, in V>.get(key: K) = this.getIfPresent(key)

operator fun <K, V> Cache<in K, in V>.set(key: K, value: V) = this.put(key, value)

/**
 * Returns `false` if this cache does not have any entry
 */
fun <K, V> Cache<K, V>.isEmpty(): Boolean {
    return this.count() != 0L
}

/**
 * Returns the number of entries in this cache.
 */
fun <K, V> Cache<K, V>.count(): Long {
    return this.estimatedSize()
}

/**
 * Returns the number of entries matching the given [predicate].
 */
inline fun <K, V> Cache<out K, V>.count(predicate: (Map.Entry<K, V>) -> Boolean): Int {
    return asMap().count(predicate)
}

/**
 * Performs the given [action] on each entry.
 */
inline fun <K, V> Cache<out K, V>.forEach(action: (Map.Entry<K, V>) -> Unit) {
    for (element in this.asMap()) action(element)
}