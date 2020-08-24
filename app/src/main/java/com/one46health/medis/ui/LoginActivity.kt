package com.one46health.medis.ui

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.one46health.medis.R

class LoginActivity : AppCompatActivity() {

    private var userEmail: EditText? = null
    private var userPassword: EditText? = null
    private var btnSignup: TextView? = null
    private var btnLogin: Button? = null
    private var btnReset: TextView? = null
    private var progressBar: ProgressBar? = null
    private var auth: FirebaseAuth? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)




        setContentView(R.layout.activity_login)
        userEmail = findViewById<EditText>(R.id.ETLoginUserEmail)
        userPassword = findViewById<EditText>(R.id.ET_login_password)
        btnSignup = findViewById<TextView>(R.id.Btn_login_SignUp)
        btnLogin = findViewById<Button>(R.id.BtnSignIn)
        btnReset = findViewById<TextView>(R.id.tv_reset)

        auth = FirebaseAuth.getInstance()

        btnSignup!!.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
        })
        btnReset!!.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this@LoginActivity, ResetPassword::class.java))
        })

        if (auth!!.currentUser != null) {
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
            finish()
        }
        btnLogin!!.setOnClickListener(View.OnClickListener {
            val userEmail = userEmail!!.text.toString().trim()
            val userpassword = userPassword!!.text.toString().trim()

            if (TextUtils.isEmpty(userEmail)) {
                Toast.makeText(applicationContext, "Please enter your email.", Toast.LENGTH_SHORT)
                    .show()
                return@OnClickListener
            }
            if (TextUtils.isEmpty(userpassword)) {
                Toast.makeText(applicationContext, "Please Enter your Password", Toast.LENGTH_SHORT)
                    .show()
                return@OnClickListener
            }
//            progressBar!!.visibility = View.VISIBLE

            auth!!.signInWithEmailAndPassword(userEmail, userpassword)
                .addOnCompleteListener(this, OnCompleteListener { task ->
//                    progressBar!!.visibility = View.VISIBLE

                    if (!task.isSuccessful) {
                        if (userpassword.length < 6) {
                            userPassword!!.error = "password mismatch!"
                        } else {
                            Toast.makeText(
                                this@LoginActivity,
                                "Authentication Failed",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else {
                        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                        finish()
                    }
                })

        })

    }
}