package marfix.com.loginapp.login.interactor

import android.os.CountDownTimer
import android.os.Handler
import marfix.com.loginapp.login.callback.LoginCallback
import marfix.com.loginapp.login.contract.LoginContracts
import marfix.com.loginapp.login.entity.user.UserEntityManager
import marfix.com.loginapp.models.User
import javax.inject.Inject


class LoginInteractorImpl @Inject constructor(var userEntityManager: UserEntityManager) : LoginContracts.LoginInteractor {

    lateinit var interactorOutput: LoginContracts.LoginInteractorOutput

    override fun logIn(user: User) {
        userEntityManager.logIn(user, object : LoginCallback {
            override fun onSuccessfulLogin(user: User) {
                interactorOutput.userLoggedIn(user)
            }

            override fun onFailureLogin(errorMessage: String) {
                interactorOutput.userFailedToLogin(errorMessage)
            }

        })
    }

}