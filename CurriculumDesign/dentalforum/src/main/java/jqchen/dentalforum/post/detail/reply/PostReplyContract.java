package jqchen.dentalforum.post.detail.reply;

import java.util.List;

import jqchen.dentalforum.base.BasePresenter;
import jqchen.dentalforum.base.BaseView;
import jqchen.dentalforum.data.bean.CommentBean;

/**
 * Created by jqchen on 2016/12/19.
 * Use to
 */
public interface PostReplyContract {
    interface View extends BaseView {
        void setComment(CommentBean commentBean);

        void setReplyRefresh(List<CommentBean.ReplyBean> replyBeen);

        void setReplyLoad(List<CommentBean.ReplyBean> replyBeen);

        void refresh();

        void clearInput();
    }

    interface Presenter extends BasePresenter {
        void getComment(int commentId);

        void getReply(int page, int size, boolean isRefresh);

        void reply(int commentId, String content, List<CommentBean.ReplyBean> list);
    }

}
