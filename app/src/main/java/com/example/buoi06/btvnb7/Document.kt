package com.example.buoi06.btvnb7

import android.os.Parcel
import android.os.Parcelable

//để truyền đối tượng qua lại giữa các màn hình thì phải implement parcelable
data class Document(val id: Int, var title: String, var content: String): Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
//        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)
        parcel.writeString(content)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Document> {
        override fun createFromParcel(parcel: Parcel): Document {
            return Document(parcel)
        }

        override fun newArray(size: Int): Array<Document?> {
            return arrayOfNulls(size)
        }
    }

}
