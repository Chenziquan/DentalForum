package jqchen.dentalforum.user.register;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import jqchen.dentalforum.R;
import jqchen.dentalforum.library.BaseFragment;
import jqchen.dentalforum.util.ShowToast;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterNextFragment extends BaseFragment implements RegisterNextContract.View {
    @BindView(R.id.network_error_layout)
    ViewStub networkErrorLayout;
    @BindView(R.id.register_next_tel)
    TextView registerNextTel;
    @BindView(R.id.register_next_code)
    EditText registerNextCode;
    @BindView(R.id.register_next_send)
    TextView registerNextSend;
    @BindView(R.id.register_next_passowrd)
    EditText registerNextPassowrd;
    private Unbinder unbinder;
    private View networkErrorView;
    private String telnum;
    private RegisterNextPresenter mPresenter;
    private ShowToast mShowToast;

    public RegisterNextFragment() {
        // Required empty public constructor
    }

    public static RegisterNextFragment getInstance() {
        return new RegisterNextFragment();
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this, view);
        mPresenter = new RegisterNextPresenter(this);
        mShowToast = new ShowToast(this.getContext());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_register_next;
    }

    @Override
    public void initData() {
        telnum = getArguments().getString(getString(R.string.transfer_tel));
        registerNextTel.setText(telnum);
        mPresenter.sendCode(telnum);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        mPresenter.destory();
    }

    @Override
    public void showCodeNullError() {
        registerNextCode.setError(getString(R.string.code_null_error));
    }

    @Override
    public void showCodeError() {
        registerNextCode.setError(getString(R.string.code_error));
    }

    @Override
    public void registerSuccess() {
        Log.e("registernext", "成功");
    }

    @Override
    public void setSendCode(String time) {
        registerNextSend.setText(getString(R.string.send_code_string, time));
    }

    @Override
    public void showPasswordNullError() {
        registerNextPassowrd.setError(getString(R.string.login_password_error));
    }

    @Override
    public void showPasswordLengthError() {
        registerNextPassowrd.setError(getString(R.string.password_length_error));
    }

    @Override
    public void setCanSendCode() {
        registerNextSend.setClickable(true);
        registerNextSend.setText(getString(R.string.send_code));
    }

    @Override
    public void setCanNotSendCode() {
        registerNextSend.setClickable(false);
    }

    @Override
    public void showRegisterFail() {
        mShowToast.show(getString(R.string.register_fail));
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


    @OnClick({R.id.register_next_send, R.id.register_next_submit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register_next_send:
                mPresenter.sendCode(telnum);
                break;
            case R.id.register_next_submit:
                mPresenter.registerNext(telnum, registerNextCode.getText().toString(), registerNextPassowrd.getText().toString());
                break;
        }
    }
}
