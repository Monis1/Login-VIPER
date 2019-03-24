package marfix.com.loginapp.login.module

import dagger.Module
import dagger.Provides
import marfix.com.loginapp.login.contract.LoginContracts
import marfix.com.loginapp.login.entity.user.UserEntityManager
import marfix.com.loginapp.login.entity.user.UserEntityManagerImpl
import marfix.com.loginapp.login.interactor.LoginInteractorImpl
import marfix.com.loginapp.login.manager.LoginNetworkManager
import marfix.com.loginapp.login.manager.LoginNetworkManagerImpl
import marfix.com.loginapp.login.presenter.LoginPresenterImpl
import marfix.com.loginapp.login.views.LoginActivity

@Module
class LoginModule(var activity: LoginActivity) {

    @Provides
    fun provideLoginView(): LoginContracts.LoginView {
        return activity
    }

    @Provides
    fun provideLoginPresenter(view: LoginContracts.LoginView, loginInteractor: LoginInteractorImpl):
            LoginContracts.LoginPresenter {
        val loginPresenter = LoginPresenterImpl(view, loginInteractor)
        loginInteractor.interactorOutput = loginPresenter
        return loginPresenter
    }

    @Provides
    fun provideLoginInteractor(userEntityManager: UserEntityManager): LoginInteractorImpl {
        return LoginInteractorImpl(userEntityManager)
    }

    @Provides
    fun provideUserEntityManager(loginNetworkManager: LoginNetworkManager) : UserEntityManager {
        return UserEntityManagerImpl(Object(), loginNetworkManager)
    }

    @Provides
    fun provideLoginNetworkManager() : LoginNetworkManager {
        return LoginNetworkManagerImpl()
    }

}