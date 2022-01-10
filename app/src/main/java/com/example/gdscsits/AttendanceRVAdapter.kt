package com.example.gdscsits


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gdscsits.db.Attendance

class AttendanceRVAdapter(val context: Context) : RecyclerView.Adapter<AttendanceRVAdapter.AttendanceViewHolder>() {

    val allAttendance= ArrayList<Attendance>()

    inner class AttendanceViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val textureView =itemView.findViewById<TextView>(R.id.student_name)
        val deleteBtn=itemView.findViewById<ImageView>(R.id.del_btn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttendanceViewHolder {
     val viewHolder= AttendanceViewHolder(  LayoutInflater.from(context).inflate(R.layout.item_attendance,parent,false))

        return viewHolder
    }

    override fun onBindViewHolder(holder: AttendanceViewHolder, position: Int) {
        val currentAttendance = allAttendance[position]
        holder.textureView.text=currentAttendance.text

    }

    override fun getItemCount(): Int {
       return allAttendance.size
    }

    fun updateList(newList: List<Attendance>)
    {
        allAttendance.clear()
        allAttendance.addAll(newList)
        notifyDataSetChanged()
    }

}

