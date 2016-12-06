package jqchen.dentalforum.data.source.local;

import jqchen.dentalforum.data.source.LoginDataSource;

/**
 * Created by jqchen on 2016/12/3.
 * Use to
 */
public class LocalLoginDataSource implements LoginDataSource{
    @Override
    public void getUsername(LoginCallback callback) {
        callback.onGetUsername("陈军权测试");
    }

    @Override
    public void login(String username, String password, LoginCallback callback) {

    }
}
