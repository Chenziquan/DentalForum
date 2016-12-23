package jqchen.dentalforum.post.detail.reply;

import android.text.Html;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import jqchen.dentalforum.R;
import jqchen.dentalforum.app.MyApplication;
import jqchen.dentalforum.common.DentalForumViewHolder;
import jqchen.dentalforum.data.bean.PostCommentBean;

/**
 * Created by jqchen on 2016/12/19.
 * Use to
 */
public class PostReplyAdapter extends BaseQuickAdapter<PostCommentBean.SecCommentBean, DentalForumViewHolder> {


    public PostReplyAdapter(int layoutResId, List<PostCommentBean.SecCommentBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected DentalForumViewHolder createBaseViewHolder(View view) {
        return new DentalForumViewHolder(view);
    }

    @Override
    protected void convert(DentalForumViewHolder dentalForumViewHolder, PostCommentBean.SecCommentBean secCommentBean) {
        dentalForumViewHolder.setText(R.id.item_post_reply, Html.fromHtml(MyApplication.getInstance().getString(R.string.post_detail_reply, secCommentBean.getUserNickname(), secCommentBean.getToUserNickname()) + secCommentBean.getContent()));
    }

}
