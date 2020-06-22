package com.example.loginapplication.mvvm

import androidx.databinding.Bindable
import androidx.databinding.Observable

data class LoginUser(var email:String, var password:String)

//    @Bindable
//    fun getLoginEmail():String{
//        return email
//    }
//    fun setLoginEmail(email:String){
//        this.email=email
//
//        //notifyPropertyChanged(BR.email)
//    }
//    @Bindable
//    fun getLoginPassword():String{
//        return password
//    }
//    fun setLoginPassword(password:String){
//        this.password=password
//       // notifyPropertyChanged(BR.password)



//    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
//        TODO("Not yet implemented")
//    }
//
//    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
//        TODO("Not yet implemented")
//    }
