package marfix.com.loginapp.login.contract

import marfix.com.loginapp.models.User

interface LoginContracts {

    interface LoginView {
        fun showLoader()
        fun hideLoader()
        fun disableLoginButton()
        fun disableEmailEditText()
        fun disablePassowrdEditText()
        fun bindUserModel(user : User)
        fun showErrorMessageDialog(errorMessage: String)
        fun openHome(user: User)
    }

    interface LoginPresenter {
        fun logIn()
        fun initialize()
    }

    interface LoginInteractor {
        fun logIn(user: User)
    }

    interface LoginInteractorOutput {
        fun userLoggedIn(user: User)
        fun userFailedToLogin(errorMessage: String)
    }

}