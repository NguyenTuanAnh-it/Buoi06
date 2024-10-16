package com.example.buoi06.buoi8

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
//cái này tạo bảng
@Entity(tableName = "user_profile")
data class UserProfile (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "age")
    val age: Int,
    @ColumnInfo(name = "gender")
    val gender: String,
    @ColumnInfo(name = "high")
    val high: String,
    @ColumnInfo(name = "weight")
    val weight: String
)



