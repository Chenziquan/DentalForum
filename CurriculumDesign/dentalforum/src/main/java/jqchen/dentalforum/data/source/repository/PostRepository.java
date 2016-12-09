package jqchen.dentalforum.data.source.repository;

import jqchen.dentalforum.data.source.PostDataSource;
import jqchen.dentalforum.data.source.local.LocalPostDataSource;
import jqchen.dentalforum.data.source.remote.RemotePostDataSource;

/**
 * Created by jqchen on 2016/12/9.
 * Use to
 */
public class PostRepository implements PostDataSource {
    private static PostRepository Instance;
    private LocalPostDataSource localPostDataSource;
    private RemotePostDataSource remotePostDataSource;

    public static PostRepository getInstance() {
        if (Instance == null) {
            Instance = new PostRepository();
        }
        return Instance;
    }

    public static void destoryInstance() {
        Instance = null;
    }

    public PostRepository() {
        this.localPostDataSource = new LocalPostDataSource();
        this.remotePostDataSource = new RemotePostDataSource();
    }

    @Override
    public void getPost(int page, int size, PostCallBack callBack) {
        remotePostDataSource.getPost(page, size, callBack);
    }

    @Override
    public void getHeader(PostCallBack callBack) {
        localPostDataSource.getHeader(callBack);
    }
}
