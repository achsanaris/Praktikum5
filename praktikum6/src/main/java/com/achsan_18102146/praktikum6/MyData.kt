package com.achsan_18102146.praktikum6

import android.os.Parcel
import android.os.Parcelable

class MyData {
    @Parcelize
    data class MyData(
        var name: String?,
        var description: String?,
        var photo: String?
    ) : Parcelable {
        constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString()
        ) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(name)
            parcel.writeString(description)
            parcel.writeString(photo)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<MyData> {
            override fun createFromParcel(parcel: Parcel): MyData {
                return MyData(parcel)
            }

            override fun newArray(size: Int): Array<MyData?> {
                return arrayOfNulls(size)
            }
        }
    }

    annotation class Parcelize
}