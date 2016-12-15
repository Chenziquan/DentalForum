package jqchen.dentalforum.frame.posts;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import jqchen.dentalforum.R;
import jqchen.dentalforum.common.DentalForumViewHolder;

/**
 * Created by jqchen on 2016/12/15.
 * Use to
 */
public class PostPictureAdapter extends BaseQuickAdapter<String,DentalForumViewHolder> {
    public PostPictureAdapter(int layoutResId, List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(DentalForumViewHolder dentalForumViewHolder, String s) {
        dentalForumViewHolder.setImageUrl(R.id.item_post_content_image,s);
    }

    @Override
    protected DentalForumViewHolder createBaseViewHolder(View view) {
        return new DentalForumViewHolder(view);
    }
}
