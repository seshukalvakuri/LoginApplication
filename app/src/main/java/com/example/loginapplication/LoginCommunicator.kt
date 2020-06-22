package com.example.loginapplication

interface LoginCommunicator {
    //what we need from view which user had entered in the edittext
    fun getEmail():String
    fun getPassword():String
    fun onLoginSuccess()
    fun onLoginfailure(msg:String)
    fun onValidationError(msg:String)
}