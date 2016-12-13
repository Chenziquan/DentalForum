package jqchen.dentalforum.function.search.search_default;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.SimpleClickListener;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagFlowLayout;

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
    TagFlowLayout searchDefaultHotFlowlayout;
    @BindView(R.id.search_default_history_recycler)
    RecyclerView searchDefaultHistoryRecycler;
    @BindView(R.id.network_error_layout)
    ViewStub networkErrorLayout;

    private Unbinder unbinder;
    private View networkErrorView;
    private List<String> hot, history;
    private SearchHotFlowAdapter hotFlowAdapter;
    private SearchHistoryAdapter historyAdapter;
    private SearchDefaultPresenter mPresenter;
    private SearchDefaultCallBack callBack;

    public void setCallBack(SearchDefaultCallBack callBack) {
        this.callBack = callBack;
    }

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
        setListener();
        mPresenter.start();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden){
            mPresenter.start();
        }
    }

    private void setListener() {
        searchDefaultHotFlowlayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                if (callBack != null) {
                    callBack.onSearchContent(hot.get(position));
                }
                return false;
            }
        });
        searchDefaultHistoryRecycler.addOnItemTouchListener(new SimpleClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                if (callBack != null) {
                    callBack.onSearchContent(hot.get(i));
                }
            }

            @Override
            public void onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {

            }

            @Override
            public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                mPresenter.deleteSearchHistory(history.get(i));
            }

            @Override
            public void onItemChildLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {

            }
        });

    }

    private void setAdapter() {
        hotFlowAdapter = new SearchHotFlowAdapter(this.getContext(), hot);
        searchDefaultHotFlowlayout.setAdapter(hotFlowAdapter);
        historyAdapter = new SearchHistoryAdapter(R.layout.item_search_history, history);
        historyAdapter.setEnableLoadMore(false);
        searchDefaultHistoryRecycler.setLayoutManager(new LinearLayoutManager(this.getContext()));
        searchDefaultHistoryRecycler.setAdapter(historyAdapter);
    }

    @Override
    public void showSearchHot(List<String> hot) {
        this.hot.clear();
        this.hot.addAll(hot);
        this.hotFlowAdapter.notifyDataChanged();
    }

    @Override
    public void showSearchHistory(List<String> history) {
        this.history.clear();
        this.history.addAll(history);
        this.historyAdapter.notifyDataSetChanged();
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
