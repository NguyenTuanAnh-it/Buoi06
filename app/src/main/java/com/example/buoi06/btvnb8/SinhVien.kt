package com.example.buoi06.btvnb8

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class SinhVien(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id: Long,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "addRess")
    var addRess: String,
    @ColumnInfo(name = "phone")
    var phone: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(name)
        parcel.writeString(addRess)
        parcel.writeString(phone)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SinhVien> {
        override fun createFromParcel(parcel: Parcel): SinhVien {
            return SinhVien(parcel)
        }

        override fun newArray(size: Int): Array<SinhVien?> {
            return arrayOfNulls(size)
        }
    }

}

