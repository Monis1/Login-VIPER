package marfix.com.loginapp.login.entity.user

import marfix.com.loginapp.login.callback.LoginCallback
import marfix.com.loginapp.models.User

interface UserEntityManager {
    fun logIn(user: User, loginCallback: LoginCallback)
}