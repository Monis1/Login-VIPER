package marfix.com.loginapp.login.entity.user

import marfix.com.loginapp.login.callback.LoginCallback
import marfix.com.loginapp.login.manager.LoginNetworkManager
import marfix.com.loginapp.models.User
import javax.inject.Inject

class UserEntityManagerImpl @Inject constructor(var repository: Any, var loginNetworkManager: LoginNetworkManager) : UserEntityManager {

    override fun logIn(user: User, loginCallback: LoginCallback) {
        loginNetworkManager.logIn(user, object : LoginCallback {
            override fun onSuccessfulLogin(user: User) {
                //repository.insert(user) TODO insert in db using repository
                loginCallback.onSuccessfulLogin(user)
            }

            override fun onFailureLogin(errorMessage: String) {
                loginCallback.onFailureLogin(errorMessage)
            }

        })
    }

}