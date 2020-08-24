package com.one46health.medis.ui

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.one46health.medis.R
import com.one46health.medis.views.Users

class RegisterActivity : AppCompatActivity() {
    private var userName: EditText? = null
    private var userEmail: EditText? = null
    private var userLocation: EditText? = null
    private var userPhoneNumber: EditText? = null
    private var userPassword: EditText? = null
    private var btnSignIn: TextView? = null
    private var btnSignUp: Button? = null
    private var progressBar: ProgressBar? = null

    private var auth: FirebaseAuth? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

//        add my code
        auth = FirebaseAuth.getInstance()

        btnSignIn = findViewById(R.id.tv_signin)
        btnSignUp = findViewById(R.id.BtnSignUp)

        userName = findViewById(R.id.ETUsername)
        userEmail = findViewById(R.id.ETUserEmail)
        userLocation = findViewById(R.id.ETLocation)
        userPhoneNumber = findViewById(R.id.ETphone_number)
        userPassword = findViewById(R.id.ETPassword)


        btnSignIn!!.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
            finish()
        })
        btnSignUp!!.setOnClickListener(View.OnClickListener {
            val username = userName!!.text.toString().trim()
            val userEmail = userEmail!!.text.toString().trim()
            val location = userLocation!!.text.toString().trim()
            val phonenumber = userPhoneNumber!!.text.toString().trim()
            val userpassword = userPassword!!.text.toString().trim()

            if (TextUtils.isEmpty(username) || TextUtils.isEmpty(userEmail) || TextUtils.isEmpty(
                    location
                ) || TextUtils.isEmpty(phonenumber) || TextUtils.isEmpty(userpassword)
            ) {
                Toast.makeText(applicationContext, "Enter your email Address!!", Toast.LENGTH_LONG)
                    .show()
                return@OnClickListener
            }
            if (userpassword.length < 6) {
                Toast.makeText(
                    applicationContext,
                    "Password too short, enter mimimum 6 charcters",
                    Toast.LENGTH_LONG
                ).show()
                return@OnClickListener
            }
//            progressBar!!.visibility = View.VISIBLE

//                ---store data----
            val mRef = FirebaseDatabase.getInstance().getReference().child("MedIS").child("users");
            val userId = mRef.push().key

            val user = Users(userId, username, userEmail, location, phonenumber)

            if (userId != null) {
                mRef.child(userId).setValue(user).addOnCompleteListener(OnCompleteListener {
                    Toast.makeText(
                        applicationContext,
                        "user data saved successfully",
                        Toast.LENGTH_SHORT
                    ).show();

                })
            }

            //create user
            auth!!.createUserWithEmailAndPassword(userEmail, userpassword)
                .addOnCompleteListener(this, OnCompleteListener { task ->
                    Toast.makeText(
                        this@RegisterActivity,
                        "createUserWithEmail:onComplete" + task.isSuccessful,
                        Toast.LENGTH_SHORT
                    ).show()
//                    progressBar!!.visibility = View.VISIBLE

                    if (!task.isSuccessful) {
                        Toast.makeText(
                            this@RegisterActivity,
                            "User Not created",
                            Toast.LENGTH_SHORT
                        ).show()
                        return@OnCompleteListener
                    } else {
                        startActivity(Intent(this@RegisterActivity, MainActivity::class.java))
                        finish()
                    }


                })

        })
    }

    override fun onResume() {
        super.onResume()
//        progressBar!!.visibility = View.GONE
    }
}