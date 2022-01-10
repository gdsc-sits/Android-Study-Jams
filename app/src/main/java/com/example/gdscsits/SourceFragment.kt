package com.example.gdscsits

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth


class SourceFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_source, container, false)

        val takeAttendanceButton = view.findViewById<Button>(R.id.btn_take_attendance)
        val viewAttendanceButton = view.findViewById<Button>(R.id.btn_view_attendance)
        val logoutButton = view.findViewById<Button>(R.id.btn_logout)
        //val gdscButton=view.findViewById<Button>(R.id.gdscid)
        val dscButton=view.findViewById<Button>(R.id.dsc_bt)
        val sinhgadButton=view.findViewById<Button>(R.id.sinhgad_bt)



        //gdscButton.setOnClickListener { findNavController()
         //   .navigate(R.id.action_sourceFragment_to_profileFragment)}

        takeAttendanceButton.setOnClickListener {
            val intent = Intent(requireActivity(), AttendanceActivity::class.java)
            requireActivity().startActivity(intent)
        }

//        viewAttendanceButton.setOnClickListener { findNavController()
//            .navigate(R.id.action_sourceFragment_to_viewAttendanceFragment)}

        viewAttendanceButton.setOnClickListener{
            val intent=Intent(requireActivity(),ViewAttendance2::class.java)
            requireActivity().startActivity(intent)
        }


        logoutButton.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(activity, LoginActivity::class.java)
            intent.flags=Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            Persistance.setString("pref_user_id_key","")
            startActivity(intent)


        }


        dscButton.setOnClickListener { findNavController()
            .navigate(R.id.action_sourceFragment_to_dscFragment) }

        sinhgadButton.setOnClickListener { findNavController()
            .navigate(R.id.action_sourceFragment_to_SITSWebsiteFragment) }


        return view
    }



}