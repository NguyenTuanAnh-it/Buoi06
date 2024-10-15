package com.example.buoi06.buoi8

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.buoi06.btvnb8.SinhVien
import com.example.buoi06.btvnb8.UserDao

//cái này quản lý 2 cái kia
//thêm bảng thì cho vào trong cái entities
@Database(entities = [UserProfile::class, SinhVien::class], version = 2)
public abstract class AppRoomDatabase: RoomDatabase() {

    abstract fun userProfileDao(): UserProfileDao
    abstract fun userDao(): UserDao

    companion object {

        @Volatile
        private var INSTANCE: AppRoomDatabase? = null

        fun getDatabase(context: Context): AppRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            if (INSTANCE == null) {
                synchronized(this) {
                    // Pass the database to the INSTANCE
                    INSTANCE = buildDatabase(context)
                }
            }
            // Return database.
            return INSTANCE!!
        }

        private fun buildDatabase(context: Context): AppRoomDatabase {
            return Room.databaseBuilder(context.applicationContext, AppRoomDatabase::class.java, "notes_database").
            allowMainThreadQueries().
            fallbackToDestructiveMigration().build()
        }
    }
}