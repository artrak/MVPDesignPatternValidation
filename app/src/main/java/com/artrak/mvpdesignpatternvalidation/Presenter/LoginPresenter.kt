package com.artrak.mvpdesignpatternvalidation.Presenter

import android.text.TextUtils
import android.util.Patterns
import com.artrak.mvpdesignpatternvalidation.model.User
import com.artrak.mvpdesignpatternvalidation.view.ILoginView

class LoginPresenter(var loginView: ILoginView): ILoginPresenter {

    override fun onLogin(email: String, password: String) {
        var user = User(email, password)
        var isLoginSuccess = isValidData(user)

        if (isLoginSuccess)
            loginView.onLoginResult("Login Success")
        else
            loginView.onLoginResult("Login error")
    }

    fun isValidData(user: User) =
            !TextUtils.isEmpty(user.email) &&
                    Patterns.EMAIL_ADDRESS.matcher(user.email).matches() &&
                    user.password.length > 6
}