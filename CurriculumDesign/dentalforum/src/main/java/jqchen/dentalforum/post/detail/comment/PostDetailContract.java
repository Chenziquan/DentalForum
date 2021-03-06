package jqchen.dentalforum.post.detail.comment;

import java.util.List;

import jqchen.dentalforum.base.BasePresenter;
import jqchen.dentalforum.base.BaseView;
import jqchen.dentalforum.data.bean.PostBean;
import jqchen.dentalforum.data.bean.PostCommentBean;

/**
 * Created by jqchen on 2016/12/17.
 * Use to
 */
public interface PostDetailContract {
    interface View extends BaseView {
        void setPostDetail(PostBean postDetail);

        void setCommentRefresh(List<PostCommentBean> list);

        void setCommentLoad(List<PostCommentBean> list);

        void refreshComment(int position);

        void refresh();

        void showContentNull();

        void setLike(boolean isLike);

        void showCollectSuccess();

        void showCollectFail();

        void onLoadCommentFinish();
    }

    interface Presenter extends BasePresenter {

        void getPostDetail(int postId);

        void getComment(int postId, int page, int size, boolean isRefresh);

        void deleteComment(int postId, int commentId, List<PostCommentBean> list, int position);

        void comment(int postId, String content, List<PostCommentBean> list);

        void reply(int postId, int commentId, String content, List<PostCommentBean> list, int position);

        void postLike(int postId, boolean isLike);

        void postCollect(int postId);

    }
}
