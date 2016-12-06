package jqchen.dentalforum.recommend;


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
import jqchen.dentalforum.R;
import jqchen.dentalforum.library.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecommendFragment extends BaseFragment implements RecommendContract.View, BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.network_error_layout)
    ViewStub networkErrorLayout;
    @BindView(R.id.recommend_recycler)
    RecyclerView recommendRecycler;

    private View networkErrorView;
    private Unbinder unbinder;
    private RecommendPresenter mPresenter;
    private List<String> data;
    private RecommendAdapter recommendAdapter;
    private int page = 1;
    private int size = 10;

    public RecommendFragment() {
        // Required empty public constructor
    }

    public static RecommendFragment getInstance() {
        return new RecommendFragment();
    }


    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this, view);
        mPresenter = new RecommendPresenter(this);
        initRecyclerView();
        initListener();
    }

    private void initListener() {
        recommendAdapter.setOnLoadMoreListener(this);
    }

    private void initRecyclerView() {
        data = new ArrayList<>();
        recommendRecycler.setNestedScrollingEnabled(true);
        recommendRecycler.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recommendAdapter = new RecommendAdapter(R.layout.item_recommend, data);
        recommendRecycler.setAdapter(recommendAdapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recommend;
    }

    @Override
    public void initData() {
        mPresenter.start();
    }

    @Override
    public void refresh(List<String> list) {
        data.clear();
        data.addAll(list);
        recommendAdapter.notifyDataSetChanged();
    }

    @Override
    public void load(List<String> list) {
        data.addAll(list);
        recommendAdapter.loadMoreComplete();
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
    public void setPresenter(Object presenter) {

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        mPresenter.destory();
    }

    @Override
    public void onLoadMoreRequested() {
        recommendRecycler.postDelayed(new Runnable() {
            @Override
            public void run() {
                page++;
                mPresenter.getRecommend(page, size, false);
            }
        }, 2000);
    }
}
