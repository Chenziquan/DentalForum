package jqchen.dentalforum.post.detail.comment;

import java.util.List;

import jqchen.dentalforum.base.BasePresenter;
import jqchen.dentalforum.base.BaseView;
import jqchen.dentalforum.data.bean.CommentBean;
import jqchen.dentalforum.data.bean.PostBean;

/**
 * Created by jqchen on 2016/12/17.
 * Use to
 */
public interface PostDetailContract {
    interface View extends BaseView {
        void setPostDetail(PostBean postDetail);

        void setCommentRefresh(List<CommentBean> list);

        void setCommentLoad(List<CommentBean> list);

        void refreshComment(int position);

        void refresh();

        void showContentNull();

        void setLike(boolean isLike);
    }

    interface Presenter extends BasePresenter {
        void getPostDetail(int postId);

        void getComment(int postId, int page, int size, boolean isRefresh);

        void deleteComment(int postId, int commentId, List<CommentBean> list, int position);

        void comment(int postId, String content, List<CommentBean> list);

        void reply(int postId, int commentId, String content, List<CommentBean> list, int position);

        void postLike(int postId, boolean isLike);
    }
}
