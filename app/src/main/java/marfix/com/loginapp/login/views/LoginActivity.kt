package marfix.com.loginapp.login.views

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import marfix.com.loginapp.R
import marfix.com.loginapp.databinding.ActivityLoginBinding
import marfix.com.loginapp.home.HomeActivity
import marfix.com.loginapp.login.component.DaggerLoginComponent
import marfix.com.loginapp.login.contract.LoginContracts
import marfix.com.loginapp.login.module.LoginModule
import marfix.com.loginapp.models.User
import javax.inject.Inject

class LoginActivity : AppCompatActivity(), LoginContracts.LoginView {

    private lateinit var loginBinding: ActivityLoginBinding

    @Inject
    lateinit var presenter: LoginContracts.LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialize()
    }

    private fun initialize() {
        loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        DaggerLoginComponent.builder()
                .loginModule(LoginModule(this))
                .build().inject(this)
        loginBinding.presenter = presenter
        presenter.initialize()
    }

    override fun bindUserModel(user: User) {
        loginBinding.user = user
    }

    override fun showLoader() {
        login_loader.visibility = View.VISIBLE
    }

    override fun hideLoader() {
        login_loader.visibility = View.GONE
    }

    override fun disableLoginButton() {
        login_button.isClickable = false
    }

    override fun disableEmailEditText() {
        email_edittext.isEnabled = false
    }

    override fun disablePassowrdEditText() {
        password_edittext.isEnabled = false
    }

    override fun showErrorMessageDialog(errorMessage: String) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
    }

    override fun openHome(user: User) {
        finish()
        //TODO: Replace the following block with route call
        val intent = Intent(this , HomeActivity::class.java)
        intent.putExtra("name", user.name)
        startActivity(intent)
    }

}
