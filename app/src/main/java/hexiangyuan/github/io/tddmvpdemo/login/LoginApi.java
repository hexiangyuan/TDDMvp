package hexiangyuan.github.io.tddmvpdemo.login;

/**
 * Created by 何祥源 on 2017/2/17.
 * Desc:
 */

public class LoginApi {
    private final String USERNAME = "hexiangyuan";
    private final String PASSWORD = "123456";

    public boolean authenticate(String username, String password) {
        if (USERNAME.equals(username) && PASSWORD.equals(password))
            return true;
        return false;
    }
}
