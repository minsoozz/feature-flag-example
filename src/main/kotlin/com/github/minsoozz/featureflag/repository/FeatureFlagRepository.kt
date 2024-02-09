package com.github.minsoozz.featureflag.repository

import com.github.minsoozz.featureflag.domain.FeatureFlag
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface FeatureFlagRepository : JpaRepository<FeatureFlag, Long> {
    fun findByName(name: String): Optional<FeatureFlag>
}