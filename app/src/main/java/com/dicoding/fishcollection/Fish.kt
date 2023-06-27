package com.dicoding.fishcollection

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Fish(
    val name: String,
    val description : String,
    val picture: Int,
    val location: String,
    val size: String,
    val price: String
) : Parcelable
