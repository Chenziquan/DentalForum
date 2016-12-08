package jqchen.dentalforum.search;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;

import com.zhy.view.flowlayout.FlowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import jqchen.dentalforum.R;
import jqchen.dentalforum.library.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchDefaultFragment extends BaseFragment implements SearchDefaultContract.View {
    @BindView(R.id.search_default_hot_flowlayout)
    FlowLayout searchDefaultHotFlowlayout;
    @BindView(R.id.search_default_history_recycler)
    RecyclerView searchDefaultHistoryRecycler;
    @BindView(R.id.network_error_layout)
    ViewStub networkErrorLayout;

    private Unbinder unbinder;
    private View networkErrorView;
    private List<String> hot, history;
    private SearchDefaultPresenter mPresenter;

    public SearchDefaultFragment() {
        // Required empty public constructor
    }

    public static SearchDefaultFragment getInstance() {
        return new SearchDefaultFragment();
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this, view);
        mPresenter = new SearchDefaultPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_search_default;
    }

    @Override
    public void initData() {
        hot = new ArrayList<>();
        history = new ArrayList<>();
        setAdapter();
    }

    private void setAdapter() {

    }

    @Override
    public void showSearchHot(List<String> hot) {

    }

    @Override
    public void showSearchHistory(List<String> history) {

    }

    @Override
    public void setPresenter(Object presenter) {

    }

    @Override
    public void showError() {
        if (networkErrorView != null) {
            networkErrorView.setVisibility(View.VISIBLE);
            return;
        }
        networkErrorView = networkErrorLayout.inflate();
    }

    @Override
    public void showNormal() {
        if (networkErrorView != null) {
            networkErrorView.setVisibility(View.GONE);
        }
    }

    @OnClick({R.id.search_default_hot_refresh, R.id.search_default_history_clear})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.search_default_hot_refresh:
                mPresenter.getSearchHot();
                break;
            case R.id.search_default_history_clear:
                mPresenter.clearSearchHistory();
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
