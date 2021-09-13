package com.example.daggerhilt.data

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Cannabis(

    val strain: String? = null,
    val health_benefit: String? = null,
    val uid: String = "",
    val cannabinoidAbbreviation: String? = null,
    val cannabinoid: String? = null,
    val medicalUse: String? = null,
    val buzzword: String? = null,
    val terpene: String? = null,
    val id: Int? = null,
    val category: String? = null,
    val type: String? = null,
    val brand: String? = null
)

