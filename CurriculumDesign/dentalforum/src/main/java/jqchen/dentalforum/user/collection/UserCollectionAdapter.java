package jqchen.dentalforum.user.collection;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import jqchen.dentalforum.R;
import jqchen.dentalforum.data.bean.PostBean;

/**
 * Created by jqchen on 2016/12/21.
 * Use to
 */
public class UserCollectionAdapter extends BaseQuickAdapter<PostBean, BaseViewHolder> {

    public UserCollectionAdapter(int layoutResId, List<PostBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, PostBean postBean) {
        baseViewHolder.setText(R.id.item_user_posts_title, postBean.getName())
                .setText(R.id.item_user_posts_them, postBean.getModuleName())
                .setText(R.id.item_user_posts_time, postBean.getCreateTime());
    }

}
