package jqchen.dentalforum.login;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewStub;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import jqchen.dentalforum.R;
import jqchen.dentalforum.library.BaseFragment;
import jqchen.dentalforum.widget.ClearableEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends BaseFragment implements LoginContract.View {

    @BindView(R.id.network_error_layout)
    ViewStub networkErrorLayout;
    private LoginPresenter mPresenter;

    @BindView(R.id.login_username)
    ClearableEditText loginUsername;
    @BindView(R.id.login_password)
    ClearableEditText loginPassword;
    private Unbinder unbinder;
    private View networkErrorView;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment getInstance() {
        return new LoginFragment();
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this, view);
        mPresenter = new LoginPresenter(this);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    public void initData() {
        mPresenter.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        mPresenter.destory();
    }

    @OnClick({ R.id.login_forget, R.id.login_submit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_forget:
                break;
            case R.id.login_submit:
                mPresenter.login(loginUsername.getText().toString(), loginPassword.getText().toString());
                break;
        }
    }

    @Override
    public void setUsername(String username) {
        loginUsername.setText(username);
    }

    @Override
    public void showUsernameError() {
        loginUsername.setError(getString(R.string.login_username_error));
//        ToastUtil.showLong(this.getContext(), getString(R.string.login_username_error));
    }

    @Override
    public void showPasswordError() {
        loginPassword.setError(getString(R.string.login_password_error));
//        ToastUtil.showLong(this.getContext(), getString(R.string.login_password_error));
    }

    @Override
    public void navigateToHome() {
        getActivity().finish();
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
}
