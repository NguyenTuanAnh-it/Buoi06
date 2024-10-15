package com.example.buoi06.btvnb8

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.buoi06.buoi8.UserProfile

@Dao
interface UserDao {
    @Query("SELECT * FROM user ORDER BY id ASC")
    fun getAllUser(): List<SinhVien>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(user: SinhVien)

    @Update
    fun update(user: SinhVien)

    @Query("DELETE FROM user")
    fun deleteAll()
}