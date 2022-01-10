package com.example.gdscsits

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.text.TextUtils
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*


class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        tv_login.setOnClickListener{
            //startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
            onBackPressed()
        }


        btn_register.setOnClickListener {
            when{
                TextUtils.isEmpty(et_register_email.text.toString().trim{it <=' '}) -> {
                    Toast.makeText(
                        this@RegisterActivity,
                        "Please enter mail.",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                TextUtils.isEmpty(et_register_password.text.toString().trim{ it <= ' '}) -> {
                    Toast.makeText(
                        this@RegisterActivity,
                        "Please enter password.",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                else ->{

                    val email: String = et_register_email.text.toString().trim{it <= ' '}
                    val password:String = et_register_password.text.toString().trim{ it <= ' '}

                    // Create an instance and register a user with email and password
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(
                           OnCompleteListener<AuthResult> { task ->

                                //if registration is successful
                                if (task.isSuccessful) {

                                    //Firebase registered user
                                    val firebaseUser:FirebaseUser=task.result!!.user!!

                                    Toast.makeText(
                                        this@RegisterActivity,
                                        "You were registered successfully",
                                        Toast.LENGTH_SHORT
                                    ).show()

                                    val intent=
                                        Intent(this@RegisterActivity, MainActivity::class.java)
                                    intent.flags=Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                    intent.putExtra("user_id",firebaseUser.uid)
                                    intent.putExtra("email_id",firebaseUser.uid)
                                    startActivity(intent)
                                    finish()

                            } else {
                                //if registration is not successful then show err message
                                Toast.makeText(
                                    this@RegisterActivity,
                                    task.exception!!.message.toString(),
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    )

                }

            }
        }
    }
}