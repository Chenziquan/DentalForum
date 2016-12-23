package jqchen.dentalforum.post.detail.comment;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import jqchen.dentalforum.R;
import jqchen.dentalforum.app.MyApplication;
import jqchen.dentalforum.common.DentalForumViewHolder;
import jqchen.dentalforum.data.bean.PostCommentBean;

/**
 * Created by jqchen on 2016/12/17.
 * Use to
 */
public class PostDetailAdapter extends BaseQuickAdapter<PostCommentBean, DentalForumViewHolder> {
    public PostDetailAdapter(int layoutResId, List<PostCommentBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(DentalForumViewHolder dentalForumViewHolder, PostCommentBean commentBean) {
        dentalForumViewHolder.setPortrait(R.id.post_detail_comment_portrait, commentBean.getComment().getUimage())
//                .setReply(R.id.post_detail_comment_reply, commentBean.getReplyBeen())
                .setRecycler(R.id.post_detail_comment_reply, new LinearLayoutManager(MyApplication.getInstance()), new PostDetailReplyAdapter(R.layout.item_post_detail_reply, commentBean.getSecComment()))
                .setText(R.id.post_detail_comment_name, commentBean.getComment().getUserNickname())
                .setText(R.id.post_detail_comment_group, commentBean.getComment().getUgroup())
                .setText(R.id.post_detail_comment_time, commentBean.getComment().getCreateDate())
                .setText(R.id.post_detail_comment_content, commentBean.getComment().getContent());
    }

    @Override
    protected DentalForumViewHolder createBaseViewHolder(View view) {
        return new DentalForumViewHolder(view);
    }
}
