package jqchen.dentalforum.search;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by jqchen on 2016/12/8.
 * Use to
 */
public class SearchHistoryAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public SearchHistoryAdapter(int layoutResId, List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, String s) {

    }
}
