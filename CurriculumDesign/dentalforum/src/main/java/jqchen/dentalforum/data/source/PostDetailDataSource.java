package jqchen.dentalforum.data.source;

import java.util.List;

import jqchen.dentalforum.base.BaseCallBack;
import jqchen.dentalforum.base.SimpleCallBack;
import jqchen.dentalforum.data.bean.CommentBean;
import jqchen.dentalforum.data.bean.PostBean;

/**
 * Created by jqchen on 2016/12/19.
 * Use to
 */
public interface PostDetailDataSource {
    interface PostDetailCallBack extends BaseCallBack {
        void onSuccess(PostBean postBean);
    }

    interface PostCommentCallBack extends BaseCallBack {
        void onGetComment(List<CommentBean> list);
    }

    interface PostReplyCallBack extends BaseCallBack {
        void onContentNull();
        void onSuccess();
    }

    void getPostDetail(int postId, PostDetailCallBack callBack);

    void getComment(int postId, int page, int size, PostCommentCallBack commentCallBack);

    void deleteComment(int postId, int commentId, List<CommentBean> list, int position, SimpleCallBack callBack);

    void comment(int postId, String content, List<CommentBean> list,PostReplyCallBack callBack);

    void reply(int postId, int commentId, String content, List<CommentBean> list, int position, PostReplyCallBack callBack);

    void postLike(int postId, boolean isLike, SimpleCallBack callBack);
}
