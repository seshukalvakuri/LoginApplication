package com.example.loginapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
//part of view in mvp architecture=
class MainActivity : AppCompatActivity(), LoginCommunicator {
    lateinit var email:EditText
    lateinit var password:EditText
    lateinit var login_btn: Button
    lateinit var loading: ProgressBar
    lateinit var loginPresenter:LoginPresenter
    lateinit var loginCommunicator:LoginCommunicator


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        email = findViewById(R.id.email_et)
        password = findViewById(R.id.password_et)
        login_btn = findViewById(R.id.login_btn)
        loading = findViewById((R.id.loading_prg))
        loginCommunicator = object : LoginCommunicator {
            override fun getEmail(): String {
                return email.text.toString()
            }

            override fun getPassword(): String {
                return password.text.toString()
            }

            override fun onLoginSuccess(){
                val intent = Intent(this@MainActivity, Home::class.java)
                startActivity(intent)
            }

            override fun onLoginfailure(msg:String){
                Toast.makeText(this@MainActivity, "login failure"+msg, Toast.LENGTH_LONG).show()
            }

            override fun onValidationError(msg: String) {
                Toast.makeText(this@MainActivity, "login failure"+msg, Toast.LENGTH_LONG).show()
            }

        }
        loginPresenter = LoginPresenter(LoginModel(), loginCommunicator)
        login_btn.setOnClickListener {
            loginPresenter.login()
        }
//            if(email_et.text.toString()=="ses" && password_et.text.toString()=="12345"){
//                val intent = Intent(this@MainActivity, Home::class.java)
//                intent.putExtra()
//                startActivity(intent)
//            }
//            else
//            {
//                Toast.makeText(this,"Invalid email or password",Toast.LENGTH_SHORT).show()
//            }
//        }
    }

    override fun getEmail(): String {
        return email.text.toString()    }

    override fun getPassword(): String {
        return password.text.toString()
    }

    override fun onLoginSuccess() {
        val intent = Intent(this@MainActivity, Home::class.java)
        startActivity(intent)
    }

    override fun onLoginfailure(msg: String) {
        Toast.makeText(this@MainActivity, "login failure"+msg, Toast.LENGTH_LONG).show()
    }

    override fun onValidationError(msg: String) {
        Toast.makeText(this@MainActivity, "login failure"+msg, Toast.LENGTH_LONG).show()
    }

//    override fun getEmail(): String {
//        return email.text.toString()
//    }
//
//    override fun getPassword(): String {
//       return password.text.toString()
//    }
}
