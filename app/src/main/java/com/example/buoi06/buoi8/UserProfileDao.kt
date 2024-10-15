package com.example.buoi06.buoi8

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
//mục đích là query và cap nhật dữ liệu
@Dao
interface UserProfileDao {
    //lấy tất cả dữ lieu user đã lưu trong database và sắp xếp tăng dần
    @Query("SELECT * FROM user_profile ORDER BY id ASC")
    fun getAllUser(): List<UserProfile>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(user: UserProfile)

    @Update
    fun update(user: UserProfile)

    @Query("DELETE FROM user_profile")
    fun deleteAll()

}