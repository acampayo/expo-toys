package com.expotoys.common.core.domain.model

data class Toy (
    val name: String,
    val technique: String,
    val size: String,
    val description: String,
    val biography: String,
    val price: String,
    val instagramUrl: String,
    val paypalAccount: String,
    val photos: List<String>
)