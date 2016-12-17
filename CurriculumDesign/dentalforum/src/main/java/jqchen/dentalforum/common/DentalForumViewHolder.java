package jqchen.dentalforum.common;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import jqchen.dentalforum.R;
import jqchen.dentalforum.app.MyApplication;
import jqchen.dentalforum.data.bean.CommentBean;
import jqchen.dentalforum.util.GlideUtil;

/**
 * Created by jqchen on 2016/12/15.
 * Use to
 */
public class DentalForumViewHolder extends BaseViewHolder {
    public DentalForumViewHolder(View view) {
        super(view);
    }

    public DentalForumViewHolder setImageUrl(int id, String url) {
        GlideUtil.getInstance().loadImage(MyApplication.getInstance(), (ImageView) getView(id), url, true);
        return this;
    }

    public DentalForumViewHolder setImagePath(int id, String path) {
        GlideUtil.getInstance().loadPathImage(MyApplication.getInstance(), (ImageView) getView(id), path, false);
        return this;
    }

    public DentalForumViewHolder setRecycler(int id, RecyclerView.LayoutManager layoutManager, BaseQuickAdapter baseQuickAdapter) {
        RecyclerView recyclerView = getView(id);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(baseQuickAdapter);
        return this;
    }

    public DentalForumViewHolder setReply(int id, List<CommentBean.ReplyBean> replyBeen) {
        LinearLayout linearLayout = getView(id);
        if (replyBeen == null || replyBeen.size() == 0) {
            linearLayout.setVisibility(View.GONE);
            return this;
        } else {
            linearLayout.setVisibility(View.VISIBLE);
        }
        TextView textView = new TextView(getConvertView().getContext());
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
        TextView replyEnd = new TextView(getConvertView().getContext());
        replyEnd.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
        replyEnd.setGravity(Gravity.CENTER);
        replyEnd.setTextColor(getConvertView().getContext().getResources().getColor(R.color.navigatesigin_color));
        for (int i = 0; i < replyBeen.size(); i++) {
            if (i == 2) {
                replyEnd.setText(String.valueOf("更多" + (replyBeen.size() - 2) + "条点评"));
                break;
            }
            textView.setText(Html.fromHtml(getConvertView().getContext().getString(R.string.post_detail_reply, replyBeen.get(i).getuName(), replyBeen.get(i).getpName()) + replyBeen.get(i).getContent()));
            linearLayout.addView(textView);
        }

        return this;
    }
}
