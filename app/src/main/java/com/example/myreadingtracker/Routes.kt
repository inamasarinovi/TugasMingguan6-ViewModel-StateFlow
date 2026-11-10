package com.example.myreadingtracker

import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
data class Detail(
    val id: Int

)

@Serializable
data class Edit(
    val id: Int? = null
)