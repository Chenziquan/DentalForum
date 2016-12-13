package jqchen.dentalforum.user.login;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jqchen.dentalforum.R;
import jqchen.dentalforum.library.AppActivity;
import jqchen.dentalforum.library.BaseFragment;

public class LoginActivity extends AppActivity {

    @BindView(R.id.login_fragment)
    FrameLayout loginFragment;
    @BindView(R.id.login_toolbar)
    Toolbar loginToolbar;

    @Override
    protected BaseFragment getFirstFragment() {
        return LoginFragment.getInstance();
    }

    @Override
    protected int getFragmentContentId() {
        return R.id.login_fragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initToolbar();
    }

    private void initToolbar() {
        setSupportActionBar(loginToolbar);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_login;
    }

    @OnClick(R.id.login_back)
    public void onClick() {
        finish();
    }

    @Override
    public void onClick(View view) {

    }
}
