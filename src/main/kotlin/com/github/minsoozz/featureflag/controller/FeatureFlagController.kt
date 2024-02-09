package com.github.minsoozz.featureflag.controller

import com.github.minsoozz.featureflag.annotation.FeatureFlag
import com.github.minsoozz.featureflag.dto.FeatureFlagRequest
import com.github.minsoozz.featureflag.service.FeatureFlagService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/feature-flag")
class FeatureFlagController(
    private val featureFlagService: FeatureFlagService
) {

    @GetMapping
    @FeatureFlag("hello")
    fun get(): String {
        return "hello"
    }

    @PostMapping
    fun insert(@RequestBody featureFlagRequest: FeatureFlagRequest) {
        featureFlagService.insert(featureFlagRequest.name)
    }

    @PutMapping
    fun on(@RequestBody featureFlagRequest: FeatureFlagRequest) {
        featureFlagService.on(featureFlagRequest.name)
    }

    @DeleteMapping
    fun off(@RequestBody featureFlagRequest: FeatureFlagRequest) {
        featureFlagService.off(featureFlagRequest.name)
    }
}