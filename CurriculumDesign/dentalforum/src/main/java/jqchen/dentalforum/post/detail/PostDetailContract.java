package jqchen.dentalforum.post.detail;

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
    }

    interface Presenter extends BasePresenter {
        void getPostDetail(int postId);

        void getComment(int page, int size, boolean isRefresh);

        void deleteComment(int postId);

        void comment(int postId, String content);

        void reply(int postId, int commentId, String content);
    }
}
