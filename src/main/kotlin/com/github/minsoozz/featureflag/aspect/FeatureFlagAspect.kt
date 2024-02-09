package com.github.minsoozz.featureflag.aspect

import com.github.minsoozz.featureflag.annotation.FeatureFlag
import com.github.minsoozz.featureflag.service.FeatureFlagService
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component

@Aspect
@Component
class FeatureFlagAspect(
    private val featureFlagService: FeatureFlagService
) {

    @Around("@annotation(featureFlag)")
    fun check(proceedingJoinPoint: ProceedingJoinPoint, featureFlag: FeatureFlag): Any {
        val name = featureFlag.name
        if (featureFlagService.getStatusByName(name)) {
            throw RuntimeException()
        }
        return proceedingJoinPoint.proceed()
    }
}