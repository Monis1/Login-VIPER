package marfix.com.loginapp.login.manager

import marfix.com.loginapp.login.callback.LoginCallback
import marfix.com.loginapp.models.User

class LoginNetworkManagerImpl : LoginNetworkManager {

    //TODO Add actual calls here and inject a network client here

    override fun logIn(user: User, loginCallback: LoginCallback) {
        user.name = "BABA"
        loginCallback.onSuccessfulLogin(user)
    }

}