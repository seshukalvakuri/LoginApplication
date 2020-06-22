package com.example.loginapplication
//(mvp) :presenter: we should add presentation logic here
class LoginPresenter(val loginModel:LoginModel, val loginCommunicator:LoginCommunicator) {
    // calling that login function og model class
    fun login(){
        if(validateUserCred()) {
            //between presenter and view we need a communicator to
            if (loginModel.login(loginCommunicator.getEmail(), loginCommunicator.getPassword()))
            {
                // communicate with view if login success
                loginCommunicator.onLoginSuccess()
            }
            else
            {
                loginCommunicator.onLoginfailure("login failure")
            }
        }
    }
    fun validateUserCred():Boolean{
        if(loginCommunicator.getEmail().isBlank()||loginCommunicator.getEmail().isEmpty()) {
            loginCommunicator.onValidationError("email should not be empty")
            return false
        }
        else if (loginCommunicator.getPassword().isBlank() || loginCommunicator.getPassword().isEmpty()){
            loginCommunicator.onValidationError("password should not be empty")
            return false
        }
        else{
            return true
        }
    }
}