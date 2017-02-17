package hexiangyuan.github.io.tddmvpdemo.login;

import android.support.annotation.StringRes;

/**
 * Created by 何祥源 on 2017/2/17.
 * Desc:
 */

public interface LoginContract {
    interface Presenter{
        void onLoginButtonClick();
    }

    interface View{

        String getUserName();

        void showUserNameIsEmptyMsg(@StringRes int strResId);

        String getPassword();

        void showPassWordIsEmpty(@StringRes int strResId);

        void showUserNameOrPassWordNotRight(@StringRes int not_right);

        void loginSucceed();
    }
}
