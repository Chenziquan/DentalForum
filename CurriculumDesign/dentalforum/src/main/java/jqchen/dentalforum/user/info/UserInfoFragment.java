package jqchen.dentalforum.user.info;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import jqchen.dentalforum.R;
import jqchen.dentalforum.data.bean.UserInfoBean;
import jqchen.dentalforum.library.BaseFragment;
import jqchen.dentalforum.util.GlideUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserInfoFragment extends BaseFragment implements UserInfoContract.View {
    @BindView(R.id.user_info_protrait)
    ImageView userInfoProtrait;
    @BindView(R.id.user_info_name)
    TextView userInfoName;
    @BindView(R.id.network_error_layout)
    ViewStub networkErrorLayout;
    private Unbinder unbinder;
    private UserInfoPresenter mPresenter;
    private View networkErrorView;

    public static UserInfoFragment getInstance() {
        return new UserInfoFragment();
    }


    public UserInfoFragment() {
        // Required empty public constructor
    }


    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this, view);
        mPresenter = new UserInfoPresenter(this);
        mPresenter.start();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_user_info;
    }

    @Override
    public void initData() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        mPresenter.destory();
    }

    @Override
    public void setUserInfo(UserInfoBean userInfoBean) {
        GlideUtil.getInstance().loadCircleImage(getContext(), userInfoProtrait, userInfoBean.getuImage());
        userInfoName.setText(userInfoBean.getuName());
    }

    @Override
    public void updateProtrait(String url) {
        GlideUtil.getInstance().loadCircleImage(getContext(), userInfoProtrait, url);
    }

    @Override
    public void updateName(String name) {
        userInfoName.setText(name);
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

}
