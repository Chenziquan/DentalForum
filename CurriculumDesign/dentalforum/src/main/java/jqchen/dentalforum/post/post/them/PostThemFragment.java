package jqchen.dentalforum.post.post.them;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import jqchen.dentalforum.R;
import jqchen.dentalforum.data.bean.PostThemBean;
import jqchen.dentalforum.library.BaseFragment;
import jqchen.dentalforum.post.post.content.PostContentActivity;
import jqchen.dentalforum.util.ShowToast;

/**
 * A simple {@link Fragment} subclass.
 */
public class PostThemFragment extends BaseFragment implements PostThemContract.View {
    @BindView(R.id.post_them_flowlayout)
    TagFlowLayout postThemFlowlayout;
    @BindView(R.id.post_them_deal)
    TextView postThemDeal;
    private Unbinder unbinder;
    private PostThemPresenter mPresenter;
    private List<PostThemBean> themBeen;
    private PostThemAdapter postThemAdapter;

    public PostThemFragment() {
        // Required empty public constructor
    }

    public static PostThemFragment getInstance() {
        return new PostThemFragment();
    }


    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this, view);
        mPresenter = new PostThemPresenter(this);
        initAdapter();
        setListener();
    }

    private void setListener() {
        postThemFlowlayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                mPresenter.setClick(position, themBeen);
                return false;
            }
        });
    }

    private void initAdapter() {
        themBeen = new ArrayList<>();
        postThemAdapter = new PostThemAdapter(themBeen, this.getContext());
        postThemFlowlayout.setAdapter(postThemAdapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_post_them;
    }

    @Override
    public void initData() {
        mPresenter.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void load(List<PostThemBean> themBeen) {
        this.themBeen.clear();
        this.themBeen.addAll(themBeen);
        postThemAdapter.notifyDataChanged();
    }

    @Override
    public void refresh() {
        postThemAdapter.notifyDataChanged();
    }

    @Override
    public void setDeal() {
        postThemDeal.setClickable(true);
        postThemDeal.setBackgroundResource(R.drawable.post_them_deal);
    }

    @Override
    public void setUnDeal() {
        postThemDeal.setClickable(false);
        postThemDeal.setBackgroundResource(R.drawable.post_them_undeal);
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


    @OnClick(R.id.post_them_deal)
    public void onClick() {
        new ShowToast(getContext()).show("确定");
        Intent intent = new Intent(this.getHoldingActivity(), PostContentActivity.class);
        startActivity(intent);
        getHoldingActivity().finish();
    }
}
