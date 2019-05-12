package com.expotoys.common.core.domain.model

import android.os.Parcel
import android.os.Parcelable

data class Toy (
    val name: String = "",
    val technique: String = "",
    val size: String = "",
    val description: String = "",
    val biography: String = "",
    val price: String = "",
    val instagramUrl: String = "",
    val paypalAccount: String = "",
    val photos: List<String> = listOf()
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.createStringArrayList()
    )

    override fun writeToParcel(parcel: Parcel?, p1: Int) {
        parcel?.writeString(name)
        parcel?.writeString(technique)
        parcel?.writeString(size)
        parcel?.writeString(description)
        parcel?.writeString(biography)
        parcel?.writeString(price)
        parcel?.writeString(instagramUrl)
        parcel?.writeString(paypalAccount)
        parcel?.writeStringList(photos)
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<Toy> {
        override fun createFromParcel(parcel: Parcel): Toy {
            return Toy(parcel)
        }

        override fun newArray(size: Int): Array<Toy?> {
            return arrayOfNulls(size)
        }
    }
}
