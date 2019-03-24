package marfix.com.loginapp.login.callback

import marfix.com.loginapp.models.User

interface LoginCallback {

    fun onSuccessfulLogin(user: User)

    fun onFailureLogin(errorMessage: String)

}