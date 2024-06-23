package com.example.userlisthw

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ActivityInputUsers : AppCompatActivity() {

    private lateinit var nameUserET: EditText
    private lateinit var emailET: EditText
    private lateinit var saveBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        saveBTN.setOnClickListener{
            val nameUser = nameUserET.text.toString().trim()
            val email = emailET.text.toString().trim()
            val intent = Intent()
            intent.putExtra("name", nameUser)
            intent.putExtra("email",email)
            setResult(RESULT_OK, intent)
            finish()
        }

    }
    private fun init(){
        setContentView(R.layout.activity_input_users)
        nameUserET = findViewById(R.id.nameUserET)
        emailET = findViewById(R.id.emailET)
        saveBTN = findViewById(R.id.saveBTN)
    }
}