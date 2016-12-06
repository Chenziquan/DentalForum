package jqchen.dentalforum.recommend;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import jqchen.dentalforum.R;

/**
 * Created by jqchen on 2016/12/2.
 * Use to
 */
public class RecommendAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public RecommendAdapter(int layoutResId, List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, String s) {
        baseViewHolder.setText(R.id.item_recommend_text,s);
    }
}
