package com.example.gdscsits.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = arrayOf(Attendance::class),version = 1,exportSchema = false)
abstract class AttendanceDatabase:RoomDatabase() {
    abstract fun getAttendanceDao() : AttendanceDao

    companion object{
        @Volatile
        private var INSTANCE: AttendanceDatabase? = null
        fun getDatabase(context: Context):AttendanceDatabase{
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AttendanceDatabase::class.java,
                    "attendance_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }

        }
    }
}