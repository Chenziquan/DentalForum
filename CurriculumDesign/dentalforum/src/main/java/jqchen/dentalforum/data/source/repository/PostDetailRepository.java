package jqchen.dentalforum.data.source.repository;

import java.util.List;

import jqchen.dentalforum.base.SimpleCallBack;
import jqchen.dentalforum.data.bean.CommentBean;
import jqchen.dentalforum.data.source.PostDetailDataSource;
import jqchen.dentalforum.data.source.local.LocalPostDetailDataSource;
import jqchen.dentalforum.data.source.remote.RemotePostDetailDataSource;

/**
 * Created by jqchen on 2016/12/19.
 * Use to
 */
public class PostDetailRepository implements PostDetailDataSource {
    private static PostDetailRepository Instance;
    private LocalPostDetailDataSource localPostDetailDataSource;
    private RemotePostDetailDataSource remotePostDetailDataSource;

    public PostDetailRepository() {
        this.localPostDetailDataSource = new LocalPostDetailDataSource();
        this.remotePostDetailDataSource = new RemotePostDetailDataSource();
    }

    public static PostDetailRepository getInstance() {
        if (Instance == null) {
            Instance = new PostDetailRepository();
        }
        return Instance;
    }

    public static void destoryInstance() {
        Instance = null;
    }

    @Override
    public void getPostDetail(int postId, PostDetailCallBack callBack) {
        remotePostDetailDataSource.getPostDetail(postId, callBack);
    }

    @Override
    public void getComment(int postId, int page, int size, PostCommentCallBack commentCallBack) {
        remotePostDetailDataSource.getComment(postId, page, size, commentCallBack);
    }

    @Override
    public void deleteComment(int postId, int commentId, List<CommentBean> list, int postition, SimpleCallBack callBack) {
        remotePostDetailDataSource.deleteComment(postId, commentId, list, postition, callBack);
    }

    @Override
    public void comment(int postId, String content, List<CommentBean> list, PostReplyCallBack callBack) {
        remotePostDetailDataSource.comment(postId, content, list, callBack);
    }


    @Override
    public void reply(int postId, int commentId, String content, List<CommentBean> list, int position, PostReplyCallBack callBack) {
        remotePostDetailDataSource.reply(postId, commentId, content, list, postId, callBack);
    }

    @Override
    public void postLike(int postId, boolean isLike, SimpleCallBack callBack) {
        remotePostDetailDataSource.postLike(postId, isLike, callBack);
    }
}
