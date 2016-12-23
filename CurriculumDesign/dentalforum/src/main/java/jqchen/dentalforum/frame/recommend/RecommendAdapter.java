package jqchen.dentalforum.frame.recommend;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import jqchen.dentalforum.R;
import jqchen.dentalforum.common.DentalForumViewHolder;
import jqchen.dentalforum.data.bean.RecommendBean;

/**
 * Created by jqchen on 2016/12/2.
 * Use to
 */
public class RecommendAdapter extends BaseQuickAdapter<RecommendBean, DentalForumViewHolder> {
    public RecommendAdapter(int layoutResId, List<RecommendBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(DentalForumViewHolder dentalForumViewHolder, RecommendBean recommendBean) {
        dentalForumViewHolder.setImageUrl(R.id.item_recommend_image, recommendBean.getPicture())
                .setText(R.id.item_recommend_title, recommendBean.getName())
                .setText(R.id.item_recommend_content, recommendBean.getContent())
                .setText(R.id.item_recommend_user, recommendBean.getAuthorName())
                .setText(R.id.item_recommend_viewnum, recommendBean.getViewnum())
                .setText(R.id.item_recommend_commentnum, recommendBean.getCommentnum());
    }

    @Override
    protected DentalForumViewHolder createBaseViewHolder(View view) {
        return new DentalForumViewHolder(view);
    }
}