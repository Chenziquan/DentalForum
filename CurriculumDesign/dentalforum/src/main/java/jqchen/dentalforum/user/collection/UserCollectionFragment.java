package jqchen.dentalforum.user.collection;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import jqchen.dentalforum.R;
import jqchen.dentalforum.data.bean.PostBean;
import jqchen.dentalforum.library.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserCollectionFragment extends BaseFragment implements UserCollectionContract.View, BGARefreshLayout.BGARefreshLayoutDelegate, BaseQuickAdapter.RequestLoadMoreListener {


    @BindView(R.id.network_error_layout)
    ViewStub networkErrorLayout;
    @BindView(R.id.user_collection_recycler)
    RecyclerView userCollectionRecycler;
    @BindView(R.id.user_collection_refresh)
    BGARefreshLayout userCollectionRefresh;

    private Unbinder unbinder;
    private List<PostBean> list;
    private UserCollectionAdapter userCollectionAdapter;
    private int page = 1, size = 10;
    private UserCollectionPresenter mPresenter;
    private View networkErrorView;

    public UserCollectionFragment() {
        // Required empty public constructor
    }

    public static UserCollectionFragment getInstance() {
        return new UserCollectionFragment();
    }


    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this, view);
        mPresenter = new UserCollectionPresenter(this);
        initRefresh();
    }

    private void initRefresh() {
        userCollectionRefresh.setRefreshViewHolder(new BGANormalRefreshViewHolder(getContext(), false));
        userCollectionRefresh.setDelegate(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_user_collection;
    }

    @Override
    public void initData() {
        setAdapter();
        mPresenter.start();
    }

    private void setAdapter() {
        list = new ArrayList<>();
        userCollectionAdapter = new UserCollectionAdapter(R.layout.item_user_posts, list);
        userCollectionAdapter.setOnLoadMoreListener(this);
        userCollectionRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        userCollectionRecycler.setAdapter(userCollectionAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        mPresenter.destory();
    }

    @Override
    public void userCollectionRefresh(List<PostBean> list) {
        this.list.clear();
        this.list.addAll(list);
        userCollectionAdapter.notifyDataSetChanged();
        userCollectionRefresh.endRefreshing();
    }

    @Override
    public void userCollectionLoad(List<PostBean> list) {
        this.list.addAll(list);
        userCollectionAdapter.loadMoreComplete();
    }

    @Override
    public void onLoadFinish() {
        userCollectionAdapter.loadMoreEnd();
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

    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
        userCollectionRefresh.postDelayed(new Runnable() {
            @Override
            public void run() {
                mPresenter.start();
            }
        }, 1800);

    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        return false;
    }

    @Override
    public void onLoadMoreRequested() {
        userCollectionRecycler.postDelayed(new Runnable() {
            @Override
            public void run() {
                page++;
                mPresenter.getUserCollection(page, size, false);
            }
        }, 1800);
    }
}
