package com.example.loginapplication
//(mvp): model : we should add business logic here
class LoginModel {
    fun login(email:String, password:String): Boolean{
        if(email.equals("ses")&&password.equals("12345")){
            return true
        }
        else
            return false
    }
}