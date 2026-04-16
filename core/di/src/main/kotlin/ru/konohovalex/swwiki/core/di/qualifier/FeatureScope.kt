package ru.konohovalex.swwiki.core.di.qualifier

import javax.inject.Qualifier
import javax.inject.Scope

@Scope
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class FeatureScope
