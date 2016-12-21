package jqchen.dentalforum.user.posts;

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
import jqchen.dentalforum.data.bean.UserPostsBean;
import jqchen.dentalforum.library.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserPostsFragment extends BaseFragment implements UserPostsContract.View, BGARefreshLayout.BGARefreshLayoutDelegate, BaseQuickAdapter.RequestLoadMoreListener {
    @BindView(R.id.user_posts_recycler)
    RecyclerView userPostsRecycler;
    @BindView(R.id.user_posts_refresh)
    BGARefreshLayout userPostsRefresh;
    @BindView(R.id.network_error_layout)
    ViewStub networkErrorLayout;
    private Unbinder unbinder;
    private List<UserPostsBean> list;
    private UserPostsAdapter userPostsAdapter;
    private UserPostsPresenter mPresenter;
    private int page = 1, size = 10;
    private View netwrokErrorView;

    public static UserPostsFragment getInstance(){
        return new UserPostsFragment();
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this, view);
        mPresenter = new UserPostsPresenter(this);
        initRefresh();
    }

    private void initRefresh() {
        userPostsRefresh.setRefreshViewHolder(new BGANormalRefreshViewHolder(getContext(), false));
        userPostsRefresh.setDelegate(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_user_posts;
    }

    @Override
    public void initData() {
        setAdapter();
        mPresenter.start();
    }

    private void setAdapter() {
        list = new ArrayList<>();
        userPostsAdapter = new UserPostsAdapter(R.layout.item_user_posts, list);
        userPostsAdapter.setOnLoadMoreListener(this);
        userPostsRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        userPostsRecycler.setAdapter(userPostsAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        mPresenter.destory();
    }

    @Override
    public void userPostsRefresh(List<UserPostsBean> list) {
        this.list.clear();
        this.list.addAll(list);
        userPostsAdapter.notifyDataSetChanged();
        userPostsRefresh.endRefreshing();
    }

    @Override
    public void userPostsLoad(List<UserPostsBean> list) {
        this.list.addAll(list);
        userPostsAdapter.loadMoreComplete();
    }

    @Override
    public void setPresenter(Object presenter) {

    }

    @Override
    public void showError() {
        if (netwrokErrorView != null) {
            netwrokErrorView.setVisibility(View.VISIBLE);
            return;
        }
        netwrokErrorView = networkErrorLayout.inflate();
    }

    @Override
    public void showNormal() {
        if (netwrokErrorView != null) {
            netwrokErrorView.setVisibility(View.GONE);
        }
    }

    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
        userPostsRefresh.postDelayed(new Runnable() {
            @Override
            public void run() {
                mPresenter.start();
            }
        },1800);

    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        return false;
    }

    @Override
    public void onLoadMoreRequested() {
        userPostsRecycler.postDelayed(new Runnable() {
            @Override
            public void run() {
                page++;
                mPresenter.getUserPosts(page, size, false);
            }
        }, 1800);

    }

}
