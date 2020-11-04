package com.pyn.jetpackpractice.databinding

import androidx.databinding.BaseObservable
import androidx.databinding.ObservableField

class TwoWayBindingViewModel : BaseObservable() {

/*    var loginModel: LoginModel

    init {
        loginModel = LoginModel("G.E.M.");
    }

    @Bindable
    fun getUserName(): String {
        return loginModel.userName
    }

    fun setUserName(userName:String){
        if (!(userName == loginModel.userName)){
            loginModel.userName = userName
            notifyPropertyChanged(BR.userName)
        }
    }*/

    var loginModelObservableField:ObservableField<LoginModel>

    init {
        val loginModel = LoginModel("G.E.M.")
        loginModelObservableField = ObservableField()
        loginModelObservableField.set(loginModel)
    }

    fun getUserName(): String? {
        return loginModelObservableField.get()?.userName
    }

    fun setUserName(userName:String){
        loginModelObservableField.get()!!.userName = userName
    }

}