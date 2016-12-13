package jqchen.dentalforum.function.search.search_default;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import jqchen.dentalforum.R;

/**
 * Created by jqchen on 2016/12/8.
 * Use to
 */
public class SearchHistoryAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public SearchHistoryAdapter(int layoutResId, List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, String s) {
        baseViewHolder.setText(R.id.search_history_content, s)
                .addOnClickListener(R.id.search_history_delete);
    }
}
