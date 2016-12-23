package jqchen.dentalforum.data.source;

import java.util.List;

import jqchen.dentalforum.base.BaseCallBack;
import jqchen.dentalforum.base.SimpleCallBack;
import jqchen.dentalforum.data.bean.PostBean;
import jqchen.dentalforum.data.bean.PostCommentBean;

/**
 * Created by jqchen on 2016/12/19.
 * Use to
 */
public interface PostDetailDataSource {
    interface PostDetailCallBack extends BaseCallBack {
        void onSuccess(PostBean postBean);
    }

    interface PostCommentCallBack extends BaseCallBack {
        void onGetComment(List<PostCommentBean> list);
        void onLoadCommentFinish();
    }

    interface PostReplyCallBack extends BaseCallBack {
        void onContentNull();
        void onSuccess();
    }

    void getPostDetail(int postId, PostDetailCallBack callBack);

    void getComment(int postId, int page, int size, PostCommentCallBack commentCallBack);

    void deleteComment(int postId, int commentId, List<PostCommentBean> list, int position, SimpleCallBack callBack);

    void comment(int postId, String content, List<PostCommentBean> list, PostReplyCallBack callBack);

    void reply(int postId, int commentId, String content, List<PostCommentBean> list, int position, PostReplyCallBack callBack);

    void postLike(int postId, boolean isLike, SimpleCallBack callBack);

    void postCollect(int postId,SimpleCallBack callBack);
}
