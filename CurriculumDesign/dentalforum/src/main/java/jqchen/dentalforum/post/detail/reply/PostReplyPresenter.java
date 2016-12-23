package jqchen.dentalforum.post.detail.reply;

import java.util.List;

import jqchen.dentalforum.data.bean.PostCommentBean;

/**
 * Created by jqchen on 2016/12/19.
 * Use to
 */
public class PostReplyPresenter implements PostReplyContract.Presenter {
    private PostReplyContract.View mView;

    public PostReplyPresenter(PostReplyContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void getComment(int commentId) {

    }

    @Override
    public void getReply(int page, int size, boolean isRefresh) {

    }

    @Override
    public void reply(int commentId, String content, List<PostCommentBean.SecCommentBean> list) {

    }

    @Override
    public void start() {

    }

    @Override
    public void destory() {

    }
}
