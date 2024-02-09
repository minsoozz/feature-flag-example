package com.github.minsoozz.featureflag.annotation

@Target(AnnotationTarget.FUNCTION)
annotation class FeatureFlag(
    val name: String
)