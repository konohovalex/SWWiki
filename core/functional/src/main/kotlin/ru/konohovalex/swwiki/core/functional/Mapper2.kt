package ru.konohovalex.swwiki.core.functional

@JvmSuppressWildcards
fun interface Mapper2<in I1, in I2, out O> {
    operator fun invoke(source1: I1, source2: I2): O
}
