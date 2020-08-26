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
import com.one46health.medis.ui.login.LoginActivity
import com.one46health.medis.views.Users
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    private var auth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        tv_signin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
        BtnSignUp.setOnClickListener{
            val username = ETUsername.text.toString().trim()
            val userEmail = ETUserEmail.text.toString().trim()
            val location = ETLocation.text.toString().trim()
            val number = ETphone_number.text.toString().trim()
            val password = ETPassword.text.toString().trim()

            if (username.isEmpty() || userEmail.isEmpty()|| location.isEmpty() || number.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Enter your email Address!!", Toast.LENGTH_LONG).show()
            }
            if (password.length < 6) {
                Toast.makeText(this, "Password too short, enter minimum 6 characters", Toast.LENGTH_LONG).show()
            }
            val mRef = FirebaseDatabase.getInstance().reference.child("MedIS").child("users");
            val userId = mRef.push().key
            val user = Users(userId, username, userEmail, location, number)
            if (userId != null) {
                mRef.child(userId).setValue(user).addOnCompleteListener {
                    Toast.makeText(this, "user data saved successfully", Toast.LENGTH_SHORT).show();

                }
            }

            auth.createUserWithEmailAndPassword(userEmail, password)
                .addOnCompleteListener(this) { task ->
                    if (!task.isSuccessful) {
                        Toast.makeText(this, "User Not created", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "createUserWithEmail:onComplete" + task.isSuccessful, Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    }

                }

        }
    }
}