package jqchen.dentalforum.user.collection;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import jqchen.dentalforum.R;
import jqchen.dentalforum.data.bean.UserCollectionBean;

/**
 * Created by jqchen on 2016/12/21.
 * Use to
 */
public class UserCollectionAdapter extends BaseQuickAdapter<UserCollectionBean, BaseViewHolder> {
    public UserCollectionAdapter(int layoutResId, List<UserCollectionBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, UserCollectionBean userCollectionBean) {
        baseViewHolder.setText(R.id.item_user_posts_title, userCollectionBean.getTitle())
                .setText(R.id.item_user_posts_them, userCollectionBean.getThem())
                .setText(R.id.item_user_posts_time, userCollectionBean.getTime());
    }
}
