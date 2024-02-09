package com.github.minsoozz.featureflag

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FeatureFlagApplication

fun main(args: Array<String>) {
    runApplication<FeatureFlagApplication>(*args)
}