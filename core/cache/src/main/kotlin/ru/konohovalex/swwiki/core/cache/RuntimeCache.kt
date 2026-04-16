package ru.konohovalex.swwiki.core.cache

import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.time.Clock
import kotlin.time.Duration.Companion.seconds
import kotlin.time.Instant

class RuntimeCache<K, V>(
    private val defaultTtlSeconds: Long? = null,
    private val maximumSize: Int? = null,
) {
    private val storage = mutableMapOf<K, CacheEntry<V>>()
    private val mutex = Mutex()

    suspend fun put(key: K, value: V, ttlSeconds: Long? = defaultTtlSeconds) {
        mutex.withLock {
            if (maximumSize != null && storage.size >= maximumSize && !storage.containsKey(key)) {
                val oldest = storage.minByOrNull { it.value.createdAt }
                oldest?.let { storage.remove(it.key) }
            }
            storage[key] = CacheEntry(
                value = value,
                expiresAt = ttlSeconds?.let { Clock.System.now() + it.seconds },
                createdAt = Clock.System.now()
            )
        }
    }

    suspend fun get(key: K): V? {
        mutex.withLock {
            val entry = storage[key] ?: return null
            if (entry.isExpired()) {
                storage.remove(key)
                return null
            }
            return entry.value
        }
    }

    suspend fun invalidate(key: K) {
        mutex.withLock {
            storage.remove(key)
        }
    }

    suspend fun clear() {
        mutex.withLock {
            storage.clear()
        }
    }

    suspend fun keys(): Set<K> {
        mutex.withLock {
            val iterator = storage.iterator()
            while (iterator.hasNext()) {
                val (_, entry) = iterator.next()
                if (entry.isExpired()) {
                    iterator.remove()
                }
            }
            return storage.keys
        }
    }

    suspend fun size(): Int {
        mutex.withLock {
            val iterator = storage.iterator()
            while (iterator.hasNext()) {
                val (_, entry) = iterator.next()
                if (entry.isExpired()) iterator.remove()
            }
            return storage.size
        }
    }

    private data class CacheEntry<V>(
        val value: V,
        val expiresAt: Instant?,
        val createdAt: Instant
    ) {
        fun isExpired(): Boolean {
            return expiresAt != null && Clock.System.now() > expiresAt
        }
    }
}
