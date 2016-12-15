package jqchen.dentalforum.frame.posts;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import jqchen.dentalforum.R;
import jqchen.dentalforum.app.MyApplication;
import jqchen.dentalforum.common.DentalForumViewHolder;
import jqchen.dentalforum.data.bean.PostBean;

/**
 * Created by jqchen on 2016/12/9.
 * Use to
 */
public class PostsAdapter extends BaseQuickAdapter<PostBean, DentalForumViewHolder> {
    public PostsAdapter(int layoutResId, List<PostBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(DentalForumViewHolder dentalForumViewHolder, PostBean postBean) {
        dentalForumViewHolder.setText(R.id.item_post_name, postBean.getUname())
                .setText(R.id.item_post_group, postBean.getUgroup())
                .setText(R.id.item_post_them, postBean.getThem())
                .setText(R.id.item_post_title, postBean.getTitle())
                .setText(R.id.item_post_content, postBean.getContent())
                .setText(R.id.item_post_time, postBean.getTime())
                .setText(R.id.item_post_viewnum, postBean.getViewnum())
                .setText(R.id.item_post_commentnum, postBean.getCommentnum());
        dentalForumViewHolder.setImageUrl(R.id.item_post_image, postBean.getUimage());
        if (postBean.getPictures() != null && postBean.getPictures().size() != 0) {
            dentalForumViewHolder.setRecycler(R.id.item_post_recycler,
                    new LinearLayoutManager(MyApplication.getInstance(), LinearLayoutManager.HORIZONTAL, false),
                    new PostPictureAdapter(R.layout.item_post_content_image, postBean.getPictures()));
        }

    }

    @Override
    protected DentalForumViewHolder createBaseViewHolder(View view) {
        return new DentalForumViewHolder(view);
    }
}
