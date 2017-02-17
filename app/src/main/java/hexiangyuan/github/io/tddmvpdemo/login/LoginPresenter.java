package hexiangyuan.github.io.tddmvpdemo.login;

import android.text.TextUtils;

import hexiangyuan.github.io.tddmvpdemo.R;

/**
 * Created by 何祥源 on 2017/2/17.
 * Desc:
 */

public class LoginPresenter implements LoginContract.Presenter {
    private final LoginContract.View mView;
    private final LoginApi mApi;

    public LoginPresenter(LoginContract.View view, LoginApi api) {
        mView = view;
        mApi = api;
    }

    @Override
    public void onLoginButtonClick() {
        if(mView.getUserName().isEmpty()){
           mView.showUserNameIsEmptyMsg(R.string.user_name_tmpty);
            return;
        }
        if(mView.getPassword().isEmpty()){
            mView.showPassWordIsEmpty(R.string.password_tmpty);
            return;
        }

        if(!mApi.authenticate(mView.getUserName(),mView.getPassword())){
            mView.showUserNameOrPassWordNotRight(R.string.not_right);
            return;
        }
        mView.loginSucceed();
    }
}
