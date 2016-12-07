package jqchen.dentalforum.search;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jqchen.dentalforum.R;
import jqchen.dentalforum.library.BaseFragment;
import jqchen.dentalforum.library.TwoFragmentActivity;

public class SearchActivity extends TwoFragmentActivity {

    @BindView(R.id.search_edittext)
    EditText searchEdittext;
    @BindView(R.id.search_toolbar)
    Toolbar searchToolbar;

    private SearchDefaultFragment defaultFragment;
    private SearchContentFragment contentFragment;

    @Override
    protected BaseFragment getFirstFragment() {
        if (defaultFragment == null) {
            defaultFragment = SearchDefaultFragment.getInstance();
        }
        return defaultFragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        initToolBar();
    }

    private void initToolBar() {
        setSupportActionBar(searchToolbar);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_search;
    }

    @Override
    protected int getFragmentContentId() {
        return R.id.search_fragment;
    }

    @OnClick({R.id.search_back, R.id.search_submit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.search_back:
                removeFragment();
                break;
            case R.id.search_submit:
                addFragment(SearchContentFragment.getInstance());
                break;
        }
    }
}