package jqchen.dentalforum.function.search.search_default;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;

import java.util.List;

import jqchen.dentalforum.R;

/**
 * Created by jqchen on 2016/12/8.
 * Use to
 */
public class SearchHotFlowAdapter extends TagAdapter<String> {
    private Context mContext;

    public SearchHotFlowAdapter(Context context, List<String> datas) {
        super(datas);
        this.mContext = context;
    }

    @Override
    public View getView(FlowLayout parent, int position, String s) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_search_hot, null);
        ((TextView) view.findViewById(R.id.item_search_hot_content)).setText(s);
        return view;
    }
}
