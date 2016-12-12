package jqchen.dentalforum.data.source.repository;

import jqchen.dentalforum.data.source.UserDataSource;
import jqchen.dentalforum.data.source.local.LocalUserDataSource;
import jqchen.dentalforum.data.source.remote.RemoteUserDataSource;

/**
 * Created by jqchen on 2016/12/12.
 * Use to
 */
public class UserRepository implements UserDataSource {
    private static UserRepository Instance;
    private LocalUserDataSource localUserDataSource;
    private RemoteUserDataSource remoteUserDataSource;

    public UserRepository() {
        this.localUserDataSource = new LocalUserDataSource();
        this.remoteUserDataSource = new RemoteUserDataSource();
    }

    public static UserRepository getInstance() {
        if (Instance == null) {
            Instance = new UserRepository();
        }
        return Instance;
    }

    public static void destoryInstance() {
        Instance = null;
    }

    @Override
    public void GetSignStatus(UserCallBack callBack) {
        remoteUserDataSource.GetSignStatus(callBack);
    }

    @Override
    public void SignOut(SignOutCallBack callBack) {
        localUserDataSource.SignOut(callBack);
    }

    @Override
    public void SignIn(SignInCallBack callBack) {
        remoteUserDataSource.SignIn(callBack);
    }

}
