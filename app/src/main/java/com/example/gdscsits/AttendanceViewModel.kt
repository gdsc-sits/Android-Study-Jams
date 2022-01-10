package com.example.gdscsits

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.gdscsits.db.Attendance
import com.example.gdscsits.db.AttendanceDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AttendanceViewModel(application: Application) : AndroidViewModel(application) {
    val dao = AttendanceDatabase.getDatabase(application).getAttendanceDao()
    val repository=AttendanceRepository(dao)
  val allAttendance: LiveData<List<Attendance>>

  init {
      val dao = AttendanceDatabase.getDatabase(application).getAttendanceDao()
      val repository=AttendanceRepository(dao)
      allAttendance=repository.allAttendance

  }

    fun deleteAttendance(attendance: Attendance) =viewModelScope.launch (Dispatchers.IO){

        repository.delete(attendance)
    }

    fun insertAttendance(attendance: Attendance) =viewModelScope.launch (Dispatchers.IO){
        repository.insert(attendance)

    }

}