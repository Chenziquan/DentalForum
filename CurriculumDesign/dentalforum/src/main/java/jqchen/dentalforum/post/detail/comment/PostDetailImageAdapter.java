package jqchen.dentalforum.post.detail.comment;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import jqchen.dentalforum.R;
import jqchen.dentalforum.common.DentalForumViewHolder;

/**
 * Created by jqchen on 2016/12/19.
 * Use to
 */
public class PostDetailImageAdapter extends BaseQuickAdapter<String, DentalForumViewHolder> {

    public PostDetailImageAdapter(int layoutResId, List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(DentalForumViewHolder dentalForumViewHolder, String s) {
        dentalForumViewHolder.setImageUrl(R.id.item_post_detail_image, s);
    }

    @Override
    protected DentalForumViewHolder createBaseViewHolder(View view) {
        return new DentalForumViewHolder(view);
    }
}
