package com.example.gdscsits.db

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface AttendanceDao {
    @Delete
    fun delete(attendance:Attendance)


    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun insert(attendance: Attendance)

    @Query("Select * from student_table order by id ASC")
    fun getAllAttendance(): LiveData<List<Attendance>>
}
