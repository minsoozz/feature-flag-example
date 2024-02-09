package com.github.minsoozz.featureflag.domain

import jakarta.persistence.*

@Entity
class FeatureFlag(

    @Column(unique = true)
    var name: String,

    var status: Boolean = false,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
) {

    fun updateStatus(status: Boolean) {
        this.status = status
    }
}