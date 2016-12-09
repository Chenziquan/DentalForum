package jqchen.dentalforum.post;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import jqchen.dentalforum.R;
import jqchen.dentalforum.library.BaseFragment;
import jqchen.dentalforum.util.ToastUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class PostFragment extends BaseFragment implements PostContract.View, BGARefreshLayout.BGARefreshLayoutDelegate, BaseQuickAdapter.RequestLoadMoreListener {
    @BindView(R.id.network_error_layout)
    ViewStub networkErrorLayout;
    @BindView(R.id.post_recycler)
    RecyclerView postRecycler;
    @BindView(R.id.post_refresh)
    BGARefreshLayout postRefresh;

    private RecyclerView postHeaderRecycler;
    private Unbinder unbinder;
    private View postHeader, networkErrorView;
    private List<String> header, posts;
    private PostAdapter postAdapter;
    private PostHeaderAdapter postHeaderAdapter;
    private PostPresenter mPresenter;
    private int page = 1, size = 10;

    public PostFragment() {
        // Required empty public constructor
    }

    public static PostFragment getInstance() {
        return new PostFragment();
    }


    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this, view);
        mPresenter = new PostPresenter(this);
        initHeader();
        initRefresh();
    }

    private void initRefresh() {
        postRefresh.setDelegate(this);
        postRefresh.setRefreshViewHolder(new BGANormalRefreshViewHolder(this.getContext(), false));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_post;
    }

    @Override
    public void initData() {
        header = new ArrayList<>();
        posts = new ArrayList<>();
        setAdapter();
        initListener();
        mPresenter.start();
    }

    private void initListener() {
        postHeaderRecycler.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ToastUtil.showLong(getContext(), "帖子头部");
            }
        });
        postRecycler.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ToastUtil.showLong(getContext(), "帖子内容");
            }
        });
        postAdapter.setOnLoadMoreListener(this);
    }

    private void initHeader() {
        postHeader = LayoutInflater.from(this.getContext()).inflate(R.layout.post_header, null);
        postHeaderRecycler = (RecyclerView) postHeader.findViewById(R.id.post_header_recycler);

    }

    private void setAdapter() {
        postAdapter = new PostAdapter(R.layout.item_post, posts);
        postAdapter.addHeaderView(postHeader);
        postRecycler.setLayoutManager(new LinearLayoutManager(this.getContext()));
        postRecycler.setAdapter(postAdapter);

        postHeaderAdapter = new PostHeaderAdapter(R.layout.item_post_header_item, header);
        postHeaderRecycler.setLayoutManager(new GridLayoutManager(this.getContext(), 3));
        postHeaderRecycler.setAdapter(postHeaderAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        mPresenter.destory();
    }

    @Override
    public void refresh(List<String> posts) {
        this.posts.clear();
        this.posts.addAll(posts);
        this.postAdapter.notifyDataSetChanged();
    }

    @Override
    public void load(List<String> posts) {
        this.posts.addAll(posts);
        this.postAdapter.loadMoreComplete();
    }

    @Override
    public void setHeader(List<String> header) {
        this.header.clear();
        this.header.addAll(header);
        this.postHeaderAdapter.notifyDataSetChanged();
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

    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        return false;
    }

    @Override
    public void onLoadMoreRequested() {
        postRecycler.postDelayed(new Runnable() {
            @Override
            public void run() {
                page++;
                mPresenter.getPost(page, size, false);
            }
        }, 1800);

    }
}
