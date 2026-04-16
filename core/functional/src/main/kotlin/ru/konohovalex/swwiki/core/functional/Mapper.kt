package ru.konohovalex.swwiki.core.functional

@JvmSuppressWildcards
fun interface Mapper<in I, out O> {
    operator fun invoke(source: I): O
}
