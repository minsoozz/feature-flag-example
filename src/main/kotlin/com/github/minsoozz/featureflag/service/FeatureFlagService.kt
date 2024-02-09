package com.github.minsoozz.featureflag.service

import com.github.minsoozz.featureflag.domain.FeatureFlag
import com.github.minsoozz.featureflag.repository.FeatureFlagRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
@Transactional
class FeatureFlagService(
    private val featureFlagRepository: FeatureFlagRepository
) {

    fun getStatusByName(name: String): Boolean {
        val featureFlag = featureFlagRepository.findByName(name)
        val isEmpty = featureFlag.isEmpty

        if (isEmpty) {
            return false
        }

        return featureFlag.get().status
    }

    fun insert(name: String) {
        featureFlagRepository.save(FeatureFlag(name = name))
    }

    fun on(name: String) {
        val featureFlag = featureFlagRepository.findByName(name).orElseThrow()
        featureFlag.updateStatus(true)
    }

    fun off(name: String) {
        val featureFlag = featureFlagRepository.findByName(name).orElseThrow()
        featureFlag.updateStatus(false)
    }
}