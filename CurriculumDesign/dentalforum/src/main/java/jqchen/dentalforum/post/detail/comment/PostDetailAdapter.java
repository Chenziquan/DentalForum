package jqchen.dentalforum.post.detail.comment;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import jqchen.dentalforum.R;
import jqchen.dentalforum.app.MyApplication;
import jqchen.dentalforum.common.DentalForumViewHolder;
import jqchen.dentalforum.data.bean.CommentBean;

/**
 * Created by jqchen on 2016/12/17.
 * Use to
 */
public class PostDetailAdapter extends BaseQuickAdapter<CommentBean, DentalForumViewHolder> {
    public PostDetailAdapter(int layoutResId, List<CommentBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(DentalForumViewHolder dentalForumViewHolder, CommentBean commentBean) {
        dentalForumViewHolder.setPortrait(R.id.post_detail_comment_portrait, commentBean.getuImage())
//                .setReply(R.id.post_detail_comment_reply, commentBean.getReplyBeen())
                .setRecycler(R.id.post_detail_comment_reply, new LinearLayoutManager(MyApplication.getInstance()), new PostDetailReplyAdapter(R.layout.item_post_detail_reply, commentBean.getReplyBeen()))
                .setText(R.id.post_detail_comment_name, commentBean.getuName())
                .setText(R.id.post_detail_comment_group, commentBean.getuGroup())
                .setText(R.id.post_detail_comment_time, commentBean.getTime())
                .setText(R.id.post_detail_comment_content, commentBean.getContent());
    }

    @Override
    protected DentalForumViewHolder createBaseViewHolder(View view) {
        return new DentalForumViewHolder(view);
    }
}
