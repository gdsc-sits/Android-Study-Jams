package com.example.gdscsits

import androidx.lifecycle.LiveData
import com.example.gdscsits.db.Attendance
import com.example.gdscsits.db.AttendanceDao

class AttendanceRepository (private val attendanceDao: AttendanceDao) {

    val allAttendance: LiveData<List<Attendance>> = attendanceDao.getAllAttendance()

    suspend fun insert(attendance: Attendance){
        attendanceDao.insert(attendance)
    }

    suspend fun delete(attendance: Attendance){
        attendanceDao.delete(attendance)
    }

}