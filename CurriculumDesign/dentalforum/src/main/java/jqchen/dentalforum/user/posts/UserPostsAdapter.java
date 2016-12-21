package jqchen.dentalforum.user.posts;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import jqchen.dentalforum.R;
import jqchen.dentalforum.data.bean.UserPostsBean;

/**
 * Created by jqchen on 2016/12/21.
 * Use to
 */
public class UserPostsAdapter extends BaseQuickAdapter<UserPostsBean,BaseViewHolder> {
    public UserPostsAdapter(int layoutResId, List<UserPostsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, UserPostsBean userPostsBean) {
        baseViewHolder.setText(R.id.item_user_posts_title,userPostsBean.getTitle())
                .setText(R.id.item_user_posts_them,userPostsBean.getThem())
                .setText(R.id.item_user_posts_time,userPostsBean.getTime());
    }
}
