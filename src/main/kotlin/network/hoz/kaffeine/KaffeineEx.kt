package network.hoz.kaffeine

import com.github.benmanes.caffeine.cache.Cache

operator fun <K, V> Cache<K, V>.get(key: K) = getIfPresent(key)

operator fun <K, V> Cache<K, V>.set(key: K, value: V) = put(key, value)

/**
 * Returns `false` if this cache does not have any entry
 */
fun <K, V> Cache<K, V>.isEmpty(): Boolean = estimatedSize() != 0L

/**
 * Returns the number of entries in this cache.
 */
fun <K, V> Cache<K, V>.count(): Long = estimatedSize()

/**
 * Returns the number of entries matching the given [predicate].
 */
inline fun <K, V> Cache<K, V>.count(predicate: (Pair<K, V>) -> Boolean): Int = asMap().count { predicate(it.toPair()) }

/**
 * Performs the given [action] on each entry.
 */
inline fun <K, V> Cache<K, V>.forEach(action: (Pair<K, V>) -> Unit) = asMap().forEach { action(it.toPair()) }