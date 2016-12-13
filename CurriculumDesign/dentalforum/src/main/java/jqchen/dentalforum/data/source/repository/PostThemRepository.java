package jqchen.dentalforum.data.source.repository;

import jqchen.dentalforum.data.source.PostThemDataSource;
import jqchen.dentalforum.data.source.local.LocalPostThemDataSource;
import jqchen.dentalforum.data.source.remote.RemotePostThemDataSource;

/**
 * Created by jqchen on 2016/12/13.
 * Use to
 */
public class PostThemRepository implements PostThemDataSource {
    private static PostThemRepository Instance;
    private LocalPostThemDataSource localPostThemDataSource;
    private RemotePostThemDataSource remotePostThemDataSource;

    public PostThemRepository() {
        this.localPostThemDataSource = new LocalPostThemDataSource();
        this.remotePostThemDataSource = new RemotePostThemDataSource();
    }

    public static PostThemRepository getInstance() {
        if (Instance == null) {
            Instance = new PostThemRepository();
        }
        return Instance;
    }

    public static void destoryInstance() {
        Instance = null;
    }

    @Override
    public void getPostThem(PostThemCallBack callBack) {
        remotePostThemDataSource.getPostThem(callBack);
    }
}
