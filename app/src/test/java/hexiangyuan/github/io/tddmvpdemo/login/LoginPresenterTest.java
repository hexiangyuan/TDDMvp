package hexiangyuan.github.io.tddmvpdemo.login;

import android.media.audiofx.Visualizer;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import hexiangyuan.github.io.tddmvpdemo.R;

/**
 * Created by 何祥源 on 2017/2/17.
 * Desc:
 */

public class LoginPresenterTest {

    private LoginPresenter mPresenter;
    private LoginContract.View mView;
    private LoginApi mApi;

    @Before
    public void setUp() {
        mView = Mockito.mock(LoginContract.View.class);
        mApi = Mockito.mock(LoginApi.class);
        mPresenter = new LoginPresenter(mView, mApi);
    }

    @Test
    public void whenUserNameIsEmpty() {
        Mockito.when(mView.getUserName()).thenReturn("");
        mPresenter.onLoginButtonClick();
        Mockito.verify(mView).showUserNameIsEmptyMsg(R.string.user_name_tmpty);
    }

    @Test
    public void whenPasswordIsEmpty() {
        Mockito.when(mView.getUserName()).thenReturn("hexiangyuan");
        Mockito.when(mView.getPassword()).thenReturn("");
        mPresenter.onLoginButtonClick();
        Mockito.verify(mView).showPassWordIsEmpty(R.string.password_tmpty);
    }

    @Test
    public void whenUserNameOrPassWordIsNotRight() throws Exception {
        Mockito.when(mView.getUserName()).thenReturn("hexiangyuan");
        Mockito.when(mView.getPassword()).thenReturn("123");

        Mockito.when(mApi.authenticate("hafiz1","123")).thenReturn(false);
        mPresenter.onLoginButtonClick();
        Mockito.verify(mView).showUserNameOrPassWordNotRight(R.string.not_right);
    }

    @Test
    public void whenLoginSucceed() throws Exception {
        Mockito.when(mView.getUserName()).thenReturn("hexiangyuan");
        Mockito.when(mView.getPassword()).thenReturn("123456");

        Mockito.when(mApi.authenticate("hexiangyuan","123456")).thenReturn(true);
        mPresenter.onLoginButtonClick();
        Mockito.verify(mView).loginSucceed();
    }
}
