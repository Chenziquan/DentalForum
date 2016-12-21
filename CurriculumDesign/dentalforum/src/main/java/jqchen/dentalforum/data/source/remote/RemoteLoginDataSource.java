package jqchen.dentalforum.data.source.remote;

import android.text.TextUtils;

import jqchen.dentalforum.app.MyApplication;
import jqchen.dentalforum.data.preference.Preference;
import jqchen.dentalforum.data.source.LoginDataSource;

/**
 * Created by jqchen on 2016/12/3.
 * Use to
 */
public class RemoteLoginDataSource implements LoginDataSource {
    @Override
    public void getUsername(LoginCallback callback) {

    }

    @Override
    public void login(String username, String password, LoginCallback callback) {
        if (TextUtils.isEmpty(username)) {
            callback.onUsernameError();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            callback.onPasswordError();
            return;
        }
        Preference preference = new Preference(MyApplication.getInstance());
        preference.setSignStatus(true);
        preference.setUserName(username);
        preference.setUserId("1");
        callback.onSuccess();
    }
}
