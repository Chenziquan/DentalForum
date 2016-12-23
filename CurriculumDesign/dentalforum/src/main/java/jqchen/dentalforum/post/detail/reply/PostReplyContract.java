package jqchen.dentalforum.post.detail.reply;

import java.util.List;

import jqchen.dentalforum.base.BasePresenter;
import jqchen.dentalforum.base.BaseView;
import jqchen.dentalforum.data.bean.PostCommentBean;

/**
 * Created by jqchen on 2016/12/19.
 * Use to
 */
public interface PostReplyContract {
    interface View extends BaseView {
        void setComment(PostCommentBean commentBean);

        void setReplyRefresh(List<PostCommentBean.SecCommentBean> replyBeen);

        void setReplyLoad(List<PostCommentBean.SecCommentBean> replyBeen);

        void refresh();

        void clearInput();
    }

    interface Presenter extends BasePresenter {
        void getComment(int commentId);

        void getReply(int page, int size, boolean isRefresh);

        void reply(int commentId, String content, List<PostCommentBean.SecCommentBean> list);
    }

}
