package com.example.loginapplication.mvvm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.loginapplication.Home
import com.example.loginapplication.R
import com.example.loginapplication.databinding.ActivityMvvmLoginBinding

//(mvvm) : this is view
class MvvmLoginActivity : AppCompatActivity() {

//    lateinit var email:EditText
//    lateinit var password:EditText
//    lateinit var login_btn: Button
//    lateinit var loader_pg:ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMvvmLoginBinding>(this, R.layout.activity_mvvm_login)
        val loginuser = LoginUser(email="",password="")
        binding.loginUser = loginuser
        val mvvmloginViewModel = ViewModelProviders.of(this).get(MvvmLoginViewModel::class.java)
        binding.loginviewmodel= mvvmloginViewModel
//        setContentView(R.layout.activity_mvvm_login)
//        email = findViewById(R.id.email_et)
//        password = findViewById(R.id.password_et)
//        login_btn = findViewById(R.id.login_btn)
//        loader_pg = findViewById(R.id.loading_prg)

        mvvmloginViewModel.loginResultLiveData.observe(this, Observer {loginResult ->
            if(loginResult){
                //start home activity
                val intent = Intent(this, Home::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"login fail", Toast.LENGTH_LONG).show()
            }
        })
//        login_btn.setOnClickListener {
//            mvvmloginViewModel.login(email.text.toString(),password.text.toString())
//        }
    }
}
