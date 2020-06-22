package com.example.loginapplication.mvvm
/*
* this class is representing model in mvvm architecture/ acess database or do network calling
* */
class MvvmLoginModel {
    fun login(email:String, password:String):Boolean{
        if(email.equals("ses")&&password.equals("12345"))
                return true
        else return false
    }
}