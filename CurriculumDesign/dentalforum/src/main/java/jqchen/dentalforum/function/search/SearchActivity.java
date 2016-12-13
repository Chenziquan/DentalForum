package jqchen.dentalforum.function.search;

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
import jqchen.dentalforum.function.search.search_content.SearchContentFragment;
import jqchen.dentalforum.function.search.search_default.SearchDefaultCallBack;
import jqchen.dentalforum.function.search.search_default.SearchDefaultFragment;
import jqchen.dentalforum.util.ShowToast;

public class SearchActivity extends TwoFragmentActivity implements SearchContract.View{

    @BindView(R.id.search_edittext)
    EditText searchEdittext;
    @BindView(R.id.search_toolbar)
    Toolbar searchToolbar;

    private SearchDefaultFragment defaultFragment;
    private SearchContentFragment contentFragment;
    private ShowToast mShowToast;
    private SearchPresenter mPresenter;

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
        init();
        mPresenter = new SearchPresenter(this);
        mPresenter.start();
        setListener();
    }

    private void setListener() {
        defaultFragment.setCallBack(new SearchDefaultCallBack() {
            @Override
            public void onSearchContent(String content) {
                searchEdittext.setText(content);
                mPresenter.search(content);
            }
        });
    }

    private void init() {
        mShowToast = new ShowToast(this);
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
                mPresenter.search(searchEdittext.getText().toString());
                break;
        }
    }

    @Override
    public void showKeyNullError() {
        mShowToast.show(getString(R.string.search_null_hint));
    }

    @Override
    public void showSearchContent(BaseFragment baseFragment) {
        addFragment(baseFragment);
    }

    @Override
    public void setPresenter(Object presenter) {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showNormal() {

    }
}
