package jqchen.dentalforum.register;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jqchen.dentalforum.R;
import jqchen.dentalforum.library.AppActivity;
import jqchen.dentalforum.library.BaseFragment;

public class RegisterActivity extends AppActivity {

    @BindView(R.id.register_toolbar)
    Toolbar registerToolbar;

    @Override
    protected BaseFragment getFirstFragment() {
        return RegisterFragment.getInstance();
    }

    @Override
    protected int getFragmentContentId() {
        return R.id.register_fragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initToolBar();
    }

    private void initToolBar() {
        setSupportActionBar(registerToolbar);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_register;
    }

    @Override
    public void onClick(View view) {

    }

    @OnClick(R.id.register_back)
    public void onClick() {
        finish();
    }
}
