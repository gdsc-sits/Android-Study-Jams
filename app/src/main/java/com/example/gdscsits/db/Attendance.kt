package com.example.gdscsits.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "student_table")
class Attendance (
    @ColumnInfo(name="student_text") val text:String ){

    @PrimaryKey(autoGenerate = true) var id=0
    }

