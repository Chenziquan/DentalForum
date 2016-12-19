package jqchen.dentalforum.post.detail.comment;

import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import jqchen.dentalforum.R;
import jqchen.dentalforum.app.MyApplication;
import jqchen.dentalforum.common.DentalForumViewHolder;
import jqchen.dentalforum.data.bean.CommentBean;

/**
 * Created by jqchen on 2016/12/19.
 * Use to
 */
public class PostDetailReplyAdapter extends BaseQuickAdapter<CommentBean.ReplyBean, BaseViewHolder> {
    private List<CommentBean.ReplyBean> list;
    private int LayoutId;

    public PostDetailReplyAdapter(int layoutResId, List<CommentBean.ReplyBean> data) {
        super(layoutResId, data);
        LayoutId = layoutResId;
        list = data;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, CommentBean.ReplyBean replyBean) {
        if (baseViewHolder instanceof ReplyEndViewHolder) {
            ((TextView) baseViewHolder.getView(R.id.item_post_detail_reply)).setGravity(Gravity.CENTER);
            baseViewHolder.setText(R.id.item_post_detail_reply, "更多" + (list.size() - 2) + "条回复");

        } else if (baseViewHolder instanceof DentalForumViewHolder) {
            baseViewHolder.setText(R.id.item_post_detail_reply, Html.fromHtml(MyApplication.getInstance().getString(R.string.post_detail_reply, replyBean.getuName(), replyBean.getpName()) + replyBean.getContent()));
        }
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                return new ReplyEndViewHolder(LayoutInflater.from(MyApplication.getInstance()).inflate(LayoutId, parent, false));
            case 1:
                return new DentalForumViewHolder(LayoutInflater.from(MyApplication.getInstance()).inflate(LayoutId, parent, false));
        }
        return super.onCreateViewHolder(parent, viewType);
    }

    @Override
    public int getItemCount() {
        return list.size() > 2 ? 3 : list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 2) {
            return 0;
        } else return 1;
    }

    class ReplyEndViewHolder extends BaseViewHolder {
        public ReplyEndViewHolder(View view) {
            super(view);
        }
    }

}
