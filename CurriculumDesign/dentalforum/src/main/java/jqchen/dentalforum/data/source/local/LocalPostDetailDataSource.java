package jqchen.dentalforum.data.source.local;

import java.util.List;

import jqchen.dentalforum.base.SimpleCallBack;
import jqchen.dentalforum.data.bean.CommentBean;
import jqchen.dentalforum.data.source.PostDetailDataSource;

/**
 * Created by jqchen on 2016/12/19.
 * Use to
 */
public class LocalPostDetailDataSource implements PostDetailDataSource {
    @Override
    public void getPostDetail(int postId, PostDetailCallBack callBack) {

    }

    @Override
    public void getComment(int postId, int page, int size, PostCommentCallBack commentCallBack) {

    }

    @Override
    public void deleteComment(int postId, int commentId, List<CommentBean> list, int postition, SimpleCallBack callBack) {

    }

    @Override
    public void comment(int postId, String content, List<CommentBean> list, PostReplyCallBack callBack) {

    }

    @Override
    public void reply(int postId, int commentId, String content, List<CommentBean> list, int position, PostReplyCallBack callBack) {

    }

    @Override
    public void postLike(int postId, boolean isLike, SimpleCallBack callBack) {

    }
}
