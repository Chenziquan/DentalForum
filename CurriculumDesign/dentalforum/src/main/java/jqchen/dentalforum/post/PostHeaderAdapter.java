package jqchen.dentalforum.post;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import jqchen.dentalforum.R;

/**
 * Created by jqchen on 2016/12/9.
 * Use to
 */
public class PostHeaderAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public PostHeaderAdapter(int layoutResId, List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, String s) {
        baseViewHolder.setText(R.id.post_header_item_text, s);
    }
}
