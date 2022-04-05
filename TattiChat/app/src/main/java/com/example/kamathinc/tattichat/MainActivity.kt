package com.example.kamathinc.tattichat

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.AuthResult
import com.google.android.gms.tasks.Task
import android.support.annotation.NonNull
import com.google.android.gms.tasks.OnCompleteListener
import android.R.attr.password
import android.util.Log
import android.R.attr.password




class MainActivity : AppCompatActivity() {

    var emailText: EditText? = null
    var passwordText: EditText? = null
    val mAuth = FirebaseAuth.getInstance()

    fun loginClicked(view: View){
//        Toast.makeText(this,"Button clicked", Toast.LENGTH_SHORT ).show()

        //Check if user is logged in
        mAuth.signInWithEmailAndPassword(emailText?.text.toString(), passwordText?.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        login()
                    } else {
                        mAuth.createUserWithEmailAndPassword(emailText?.text.toString(), passwordText?.text.toString()).addOnCompleteListener(this){ task ->
                            if(task.isSuccessful){
                               //Add user to db
                                login()
                            }else{
                                Toast.makeText(this, "Something went wrong! Please check details entered", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                }

    }

    fun login(){

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        emailText = findViewById(R.id.emailText)
        passwordText = findViewById(R.id.passwordText)

        if(mAuth.currentUser != null){
            login()
        }

    }


}
