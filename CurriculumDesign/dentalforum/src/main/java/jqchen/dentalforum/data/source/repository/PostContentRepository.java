package jqchen.dentalforum.data.source.repository;

import java.util.List;

import jqchen.dentalforum.data.source.PostContentDataSource;
import jqchen.dentalforum.data.source.local.LocalPostContentDataSource;
import jqchen.dentalforum.data.source.remote.RemotePostContentDataSource;

/**
 * Created by jqchen on 2016/12/15.
 * Use to
 */
public class PostContentRepository implements PostContentDataSource {
    private static PostContentRepository Instance;
    private LocalPostContentDataSource localPostContentDataSource;
    private RemotePostContentDataSource remotePostContentDataSource;

    public PostContentRepository() {
        this.localPostContentDataSource = new LocalPostContentDataSource();
        this.remotePostContentDataSource = new RemotePostContentDataSource();
    }

    public static PostContentRepository getInstance() {
        if (Instance == null) {
            Instance = new PostContentRepository();
        }
        return Instance;
    }

    public static void destoryInstance() {
        Instance = null;
    }

    @Override
    public void addPicture(List<String> strings, UploadPictureCallBack callBack) {
        this.remotePostContentDataSource.addPicture(strings, callBack);
    }

    @Override
    public void postSubmit(String title, String content, List<String> strings, PostContentCallBack contentCallBack) {
        this.remotePostContentDataSource.postSubmit(title, content, strings, contentCallBack);
    }
}
