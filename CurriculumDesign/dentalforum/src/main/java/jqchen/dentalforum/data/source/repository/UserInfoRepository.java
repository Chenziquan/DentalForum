package jqchen.dentalforum.data.source.repository;

import jqchen.dentalforum.data.source.UserInfoDataSource;
import jqchen.dentalforum.data.source.local.LocalUserInfoDataSource;
import jqchen.dentalforum.data.source.remote.RemoteUserInfoDataSource;

/**
 * Created by jqchen on 2016/12/20.
 * Use to
 */
public class UserInfoRepository implements UserInfoDataSource {
    private static UserInfoRepository Instance;
    private LocalUserInfoDataSource localUserInfoDataSource;
    private RemoteUserInfoDataSource remoteUserInfoDataSource;

    public UserInfoRepository() {
        this.localUserInfoDataSource = new LocalUserInfoDataSource();
        this.remoteUserInfoDataSource = new RemoteUserInfoDataSource();
    }

    public static UserInfoRepository getInstance() {
        if (Instance == null) {
            Instance = new UserInfoRepository();
        }
        return Instance;
    }

    public static void destoryInstance() {
        Instance = null;
    }

    @Override
    public void getUserInfo(UserInfoCallBack callBack) {
        this.remoteUserInfoDataSource.getUserInfo(callBack);
    }

    @Override
    public void updateProtrait(String url, UpdateInfoCallBack callBack) {
        this.remoteUserInfoDataSource.updateProtrait(url, callBack);
    }

    @Override
    public void updateName(String name, UpdateInfoCallBack callBack) {
        this.remoteUserInfoDataSource.updateName(name, callBack);
    }
}
