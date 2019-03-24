package marfix.com.loginapp.login.component

import dagger.Component
import marfix.com.loginapp.login.module.LoginModule
import marfix.com.loginapp.login.scope.LoginComponentScope
import marfix.com.loginapp.login.views.LoginActivity

@Component(modules = arrayOf(LoginModule::class))
@LoginComponentScope
interface LoginComponent {
    fun inject(activity: LoginActivity)
}