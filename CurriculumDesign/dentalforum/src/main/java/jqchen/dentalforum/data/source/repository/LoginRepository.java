package jqchen.dentalforum.data.source.repository;

import jqchen.dentalforum.data.source.LoginDataSource;
import jqchen.dentalforum.data.source.local.LocalLoginDataSource;
import jqchen.dentalforum.data.source.remote.RemoteLoginDataSource;

/**
 * Created by jqchen on 2016/12/3.
 * Use to
 */
public class LoginRepository implements LoginDataSource {
    public static LoginRepository INSTANCE = null;

    private LocalLoginDataSource localLoginDataSource;
    private RemoteLoginDataSource remoteLoginDataSource;

    public LoginRepository() {
        this.localLoginDataSource = new LocalLoginDataSource();
        this.remoteLoginDataSource = new RemoteLoginDataSource();
    }

    public static LoginRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LoginRepository();
        }
        return INSTANCE;
    }

    public static void destoryInstance() {
        INSTANCE = null;
    }

    @Override
    public void getUsername(LoginCallback callback) {
        localLoginDataSource.getUsername(callback);
    }

    @Override
    public void login(String username, String password, LoginCallback callback) {
        remoteLoginDataSource.login(username, password, callback);
    }
}
