package jqchen.dentalforum.data.source;

import jqchen.dentalforum.data.source.local.LocalLoginDataSource;
import jqchen.dentalforum.data.source.remote.RemoteLoginDataSource;

/**
 * Created by jqchen on 2016/12/3.
 * Use to
 */
public class LoginResponsitory implements LoginDataSource {
    public static LoginResponsitory INSTANCE = null;

    private LocalLoginDataSource localLoginDataSource;
    private RemoteLoginDataSource remoteLoginDataSource;

    public LoginResponsitory() {
        this.localLoginDataSource = new LocalLoginDataSource();
        this.remoteLoginDataSource = new RemoteLoginDataSource();
    }

    public static LoginResponsitory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LoginResponsitory();
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
