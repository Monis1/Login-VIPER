package marfix.com.loginapp.login.presenter

import marfix.com.loginapp.login.contract.LoginContracts
import marfix.com.loginapp.models.User
import javax.inject.Inject

class LoginPresenterImpl @Inject constructor(var view: LoginContracts.LoginView, var loginInteractor: LoginContracts.LoginInteractor,var user: User)
    : LoginContracts.LoginPresenter, LoginContracts.LoginInteractorOutput {

    override fun initialize() {
        view.bindUserModel(user)
    }

    override fun logIn() {
        view.showLoader()
        view.disableEmailEditText()
        view.disablePassowrdEditText()
        view.disableLoginButton()
        loginInteractor.logIn(user)
    }

    override fun userLoggedIn(user: User) {
        view.hideLoader()
        view.openHome(user)
    }

    override fun userFailedToLogin(errorMessage: String) {
        view.showErrorMessageDialog(errorMessage)
    }

}