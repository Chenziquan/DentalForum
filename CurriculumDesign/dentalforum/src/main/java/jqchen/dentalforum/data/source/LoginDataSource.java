package jqchen.dentalforum.data.source;

import jqchen.dentalforum.base.BaseCallBack;

/**
 * Created by jqchen on 2016/12/3.
 * Use to
 */
public interface LoginDataSource {
    interface GetUsernameCallBack extends BaseCallBack{
        void onGetUsername(String username);
    }
    interface LoginCallback extends BaseCallBack{
        void onFail();

        void onUsernameError();

        void onPasswordError();

        void onSuccess();

    }

    void getUsername(GetUsernameCallBack callback);

    void login(String username, String password, LoginCallback callback);
}
