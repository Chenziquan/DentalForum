package jqchen.dentalforum.frame.recommend;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.EditText;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.bingoogolapple.bgabanner.BGABanner;
import cn.bingoogolapple.refreshlayout.BGAMoocStyleRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import cn.bingoogolapple.refreshlayout.BGARefreshViewHolder;
import jqchen.dentalforum.R;
import jqchen.dentalforum.data.bean.ADListModel;
import jqchen.dentalforum.library.BaseFragment;
import jqchen.dentalforum.function.search.SearchActivity;
import jqchen.dentalforum.util.GlideUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecommendFragment extends BaseFragment implements RecommendContract.View, BaseQuickAdapter.RequestLoadMoreListener,
        BGARefreshLayout.BGARefreshLayoutDelegate, View.OnClickListener, BGABanner.Adapter {

    @BindView(R.id.network_error_layout)
    ViewStub networkErrorLayout;
    @BindView(R.id.recommend_recycler)
    RecyclerView recommendRecycler;
    @BindView(R.id.recommend_refresh)
    BGARefreshLayout recommendRefresh;

    private View networkErrorView;
    private Unbinder unbinder;
    private RecommendPresenter mPresenter;
    private List<String> data;
    private RecommendAdapter recommendAdapter;
    private View recommendHeader;
    private int page = 1;
    private int size = 10;
    private EditText recommendSearch;
    private BGABanner recommendBanner;


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
        initHeader();
        initRefresh();
        initRecyclerView();
        initListener();
    }

    private void initHeader() {
        recommendHeader = LayoutInflater.from(this.getContext()).inflate(R.layout.recommend_header, null);
        recommendSearch = (EditText) recommendHeader.findViewById(R.id.recommend_search);
        recommendBanner = (BGABanner) recommendHeader.findViewById(R.id.recommend_banner);
        recommendBanner.setAdapter(this);
    }

    private void initRefresh() {
        recommendRefresh.setDelegate(this);
        BGAMoocStyleRefreshViewHolder refreshViewHolder = new BGAMoocStyleRefreshViewHolder(this.getContext(), false);
        refreshViewHolder.setOriginalImage(R.drawable.home_search);
        refreshViewHolder.setUltimateColor(R.color.them_color);
        BGARefreshViewHolder bgaRefreshViewHolder = new BGANormalRefreshViewHolder(this.getContext(), false);
        BGANormalRefreshViewHolder normalRefreshViewHolder = new BGANormalRefreshViewHolder(this.getContext(), false);
        normalRefreshViewHolder.setRefreshingText("正在刷新1");
        normalRefreshViewHolder.setPullDownRefreshText("下拉刷新1");
        normalRefreshViewHolder.setReleaseRefreshText("松开刷新1");
        recommendRefresh.setRefreshViewHolder(normalRefreshViewHolder);

    }

    private void initListener() {
        recommendAdapter.setOnLoadMoreListener(this);
        recommendSearch.setOnClickListener(this);
    }

    private void initRecyclerView() {
        data = new ArrayList<>();
        recommendRecycler.setNestedScrollingEnabled(true);
        recommendRecycler.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recommendAdapter = new RecommendAdapter(R.layout.item_recommend, data);
        recommendAdapter.addHeaderView(recommendHeader);
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
        recommendRefresh.endRefreshing();
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
    public void setBanner(List<ADListModel.InfoBean> banner) {
        recommendBanner.setData(banner, null);
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
        }, 1800);
    }

    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
        recommendRefresh.postDelayed(new Runnable() {
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
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.recommend_search:
                startActivity(new Intent(this.getHoldingActivity(), SearchActivity.class));
                break;
        }
    }

    @Override
    public void fillBannerItem(BGABanner banner, View view, Object model, int position) {
        GlideUtil.getInstance().loadImage(this.getContext(), (ImageView) view,
                "http://114.55.64.30:8080/migocoo/img/migocooshow/" + ((ADListModel.InfoBean) model).getAd_pic(), false);
    }
}
