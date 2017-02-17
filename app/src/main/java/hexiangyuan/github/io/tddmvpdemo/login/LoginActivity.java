package hexiangyuan.github.io.tddmvpdemo.login;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import hexiangyuan.github.io.tddmvpdemo.R;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements LoginContract.View{

    private EditText etEmail;
    private EditText etPassword;
    private LoginPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mPresenter = new LoginPresenter(this,new LoginApi());
        etEmail = (EditText)findViewById(R.id.email);
        etPassword = (EditText) findViewById(R.id.password);

    }

    public void login(View v){
        mPresenter.onLoginButtonClick();
    }

    @Override
    public String getUserName() {
        return etEmail.getText().toString();
    }

    @Override
    public void showUserNameIsEmptyMsg(@StringRes int strResId) {
        Toast.makeText(this,strResId,Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getPassword() {
        return etPassword.getText().toString();
    }

    @Override
    public void showPassWordIsEmpty(@StringRes int strResId) {
        Toast.makeText(this,strResId,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUserNameOrPassWordNotRight(@StringRes int not_right) {
        Toast.makeText(this,not_right,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSucceed() {
        Toast.makeText(this,"Login succeed",Toast.LENGTH_SHORT).show();
    }
}

