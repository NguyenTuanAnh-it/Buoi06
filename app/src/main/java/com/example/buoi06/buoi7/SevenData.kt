package com.example.buoi06.buoi7

import android.os.Parcel
import android.os.Parcelable

class SevenData() : Parcelable {
    var title: String = ""
    var content: String = ""

    constructor(parcel: Parcel) : this() {
        title = parcel.readString().toString()
        content = parcel.readString().toString()
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(p0: Parcel, p1: Int) {
        p0.writeString(title)
        p0.writeString(content)
    }

    companion object CREATOR : Parcelable.Creator<SevenData> {
        override fun createFromParcel(parcel: Parcel): SevenData {
            return SevenData(parcel)
        }

        override fun newArray(size: Int): Array<SevenData?> {
            return arrayOfNulls(size)
        }
    }
}