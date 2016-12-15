package jqchen.dentalforum.post.post.content;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import jqchen.dentalforum.R;
import jqchen.dentalforum.common.DentalForumViewHolder;

/**
 * Created by jqchen on 2016/12/15.
 * Use to
 */
public class PostContentAdapter extends BaseQuickAdapter<String, DentalForumViewHolder> {
    public PostContentAdapter(int layoutResId, List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(DentalForumViewHolder dentalForumViewHolder, String s) {
        dentalForumViewHolder.setImagePath(R.id.item_post_content_image, s);
    }

    @Override
    protected DentalForumViewHolder createBaseViewHolder(View view) {
        return new DentalForumViewHolder(view);
    }
}