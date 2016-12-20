package jqchen.dentalforum.user.info;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jqchen.dentalforum.R;
import jqchen.dentalforum.library.AppActivity;
import jqchen.dentalforum.library.BaseFragment;

public class UserInfoActivity extends AppActivity {

    @BindView(R.id.user_info_toolbar)
    Toolbar userInfoToolbar;

    @Override
    protected BaseFragment getFirstFragment() {
        return UserInfoFragment.getInstance();
    }

    @Override
    protected int getFragmentContentId() {
        return R.id.user_info_fragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initToolBar();
    }

    private void initToolBar() {
        setSupportActionBar(userInfoToolbar);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_user_info;
    }


    @Override
    public void onClick(View view) {

    }

    @OnClick(R.id.user_info_back)
    public void onClick() {
        finish();
    }
}
