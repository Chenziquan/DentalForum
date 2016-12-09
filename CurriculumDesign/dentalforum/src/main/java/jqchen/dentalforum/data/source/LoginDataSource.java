package jqchen.dentalforum.data.source;

import jqchen.dentalforum.base.BaseCallBack;

/**
 * Created by jqchen on 2016/12/3.
 * Use to
 */
public interface LoginDataSource {
    interface LoginCallback extends BaseCallBack{
        void onGetUsername(String username);

        void onUsernameError();

        void onPasswordError();

        void onSuccess();

    }

    void getUsername(LoginCallback callback);

    void login(String username, String password, LoginCallback callback);
}
