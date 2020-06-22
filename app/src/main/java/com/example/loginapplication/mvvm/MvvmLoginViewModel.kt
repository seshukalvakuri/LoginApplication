package com.example.loginapplication.mvvm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

//(mvvm) this is acting as viewmodel
/*
* this we are using to handle presentation login
* and accessing bussiness logic through the model(data source)
* */
class MvvmLoginViewModel(application: Application):AndroidViewModel(application) {

    lateinit var mvvmLoginModel:MvvmLoginModel
    var _loginResultLiveData : MutableLiveData<Boolean> = MutableLiveData()
    val loginResultLiveData :LiveData<Boolean> = _loginResultLiveData
    fun login(email:String,password:String) {
        mvvmLoginModel = MvvmLoginModel()
        if(mvvmLoginModel.login(email,password)){
            _loginResultLiveData.postValue(true)
            //have to do login success prosecc otherwise
        }else{
            _loginResultLiveData.postValue(false)
            //do login failure process
        }
    }



}