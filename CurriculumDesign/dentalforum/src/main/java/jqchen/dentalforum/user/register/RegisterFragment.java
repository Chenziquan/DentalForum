package jqchen.dentalforum.user.register;


import android.content.Intent;
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
public class RegisterFragment extends BaseFragment implements RegisterContract.View {

    @BindView(R.id.regiser_tel)
    ClearableEditText regiserTel;
    @BindView(R.id.network_error_layout)
    ViewStub networkErrorLayout;
    private RegisterPresenter mPresenter;
    private View networkErrorView;
    private Unbinder unbinder;

    public RegisterFragment() {
        // Required empty public constructor
    }

    public static RegisterFragment getInstance() {
        return new RegisterFragment();
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this, view);
        mPresenter = new RegisterPresenter(this);
        mPresenter.start();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_register;
    }

    @Override
    public void initData() {

    }

    @Override
    public void showTelFormatError() {
        regiserTel.setError(getString(R.string.register_tel_format_error));
    }

    @Override
    public void showTelNullError() {
        regiserTel.setError(getString(R.string.register_tel_error));
    }

    @Override
    public void showTelError() {

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
    public void goNextStep() {
        Intent intent = new Intent(this.getHoldingActivity(), RegisterNextActivity.class);
        intent.putExtra(getString(R.string.transfer_tel), regiserTel.getText().toString());
        startActivity(intent);
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


    @OnClick(R.id.register_next)
    public void onClick() {
        mPresenter.goNextStep(regiserTel.getText().toString());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        mPresenter.destory();
    }
}
