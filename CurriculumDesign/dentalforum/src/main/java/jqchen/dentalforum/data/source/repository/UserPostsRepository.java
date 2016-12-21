package jqchen.dentalforum.data.source.repository;

import jqchen.dentalforum.data.source.UserPostsDataSource;
import jqchen.dentalforum.data.source.local.LocalUserPostsDataSource;
import jqchen.dentalforum.data.source.remote.RemoteUserPostsDataSource;

/**
 * Created by jqchen on 2016/12/21.
 * Use to
 */
public class UserPostsRepository implements UserPostsDataSource {
    private static UserPostsRepository Instance;
    private LocalUserPostsDataSource localUserPostsDataSource;
    private RemoteUserPostsDataSource remoteUserPostsDataSource;

    public UserPostsRepository() {
        this.localUserPostsDataSource = new LocalUserPostsDataSource();
        this.remoteUserPostsDataSource = new RemoteUserPostsDataSource();
    }

    public static UserPostsRepository getInstance() {
        if (Instance == null) {
            Instance = new UserPostsRepository();
        }
        return Instance;
    }

    public static void destoryInstance() {
        Instance = null;
    }

    @Override
    public void getUserPosts(int page, int size, UserPostsCallBack callBack) {
        this.remoteUserPostsDataSource.getUserPosts(page, size, callBack);
    }
}
