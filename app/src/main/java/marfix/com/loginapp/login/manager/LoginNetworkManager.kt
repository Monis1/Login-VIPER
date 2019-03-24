package marfix.com.loginapp.login.manager

import marfix.com.loginapp.login.callback.LoginCallback
import marfix.com.loginapp.models.User

interface LoginNetworkManager {
    fun logIn(user: User, loginCallback: LoginCallback)
}