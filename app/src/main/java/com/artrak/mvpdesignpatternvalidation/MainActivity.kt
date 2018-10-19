package com.artrak.mvpdesignpatternvalidation

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.artrak.mvpdesignpatternvalidation.Presenter.ILoginPresenter
import com.artrak.mvpdesignpatternvalidation.Presenter.LoginPresenter
import com.artrak.mvpdesignpatternvalidation.view.ILoginView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ILoginView {

    var loginPresenter: ILoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_login.setOnClickListener{
            loginPresenter.onLogin(edt_email.text.toString(), edt_password.text.toString())
        }
    }

    init {
        "init".log()
        loginPresenter = LoginPresenter(this)
    }

    override fun onLoginResult(massage: String) {
        this.toast(massage)
        resultId.text = massage
    }

    fun Context.toast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun String.log(){
        Log.d("MyLog", this)
    }
}
