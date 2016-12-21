package jqchen.dentalforum.data.source.repository;

import jqchen.dentalforum.data.source.UserCollectionDataSource;
import jqchen.dentalforum.data.source.local.LocalUserCollectionDataSource;
import jqchen.dentalforum.data.source.remote.RemoteUserCollectionDataSource;

/**
 * Created by jqchen on 2016/12/21.
 * Use to
 */
public class UserCollectionRepository implements UserCollectionDataSource {
    private static UserCollectionRepository Instance;
    private LocalUserCollectionDataSource localUserCollectionDataSource;
    private RemoteUserCollectionDataSource remoteUserCollectionDataSource;

    public UserCollectionRepository() {
        this.localUserCollectionDataSource = new LocalUserCollectionDataSource();
        this.remoteUserCollectionDataSource = new RemoteUserCollectionDataSource();
    }

    public static UserCollectionRepository getInstance() {
        if (Instance == null) {
            Instance = new UserCollectionRepository();
        }
        return Instance;
    }

    public static void destoryInstance() {
        Instance = null;
    }

    @Override
    public void getUserCollection(int page, int size, UserCollectionCallBack collectionCallBack) {
        this.remoteUserCollectionDataSource.getUserCollection(page, size, collectionCallBack);
    }
}
