package jqchen.dentalforum.search;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import jqchen.dentalforum.R;
import jqchen.dentalforum.library.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchContentFragment extends BaseFragment {
    @BindView(R.id.text)
    TextView text;
    private Unbinder unbinder;

    public SearchContentFragment() {
        // Required empty public constructor
    }

    public static SearchContentFragment getInstance() {
        return new SearchContentFragment();
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this, view);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_search_content;
    }

    @Override
    public void initData() {

    }

    public void reset() {
        text.setText("搜索内容");
    }
}
