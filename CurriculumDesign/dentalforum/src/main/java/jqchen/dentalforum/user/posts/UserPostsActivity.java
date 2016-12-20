package jqchen.dentalforum.user.posts;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jqchen.dentalforum.R;
import jqchen.dentalforum.library.AppActivity;
import jqchen.dentalforum.library.BaseFragment;

public class UserPostsActivity extends AppActivity {

    @BindView(R.id.user_posts_toolbar)
    Toolbar userPostsToolbar;

    @Override
    protected BaseFragment getFirstFragment() {
        return null;
    }

    @Override
    protected int getFragmentContentId() {
        return super.getFragmentContentId();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initToolBar();
    }

    private void initToolBar() {
        setSupportActionBar(userPostsToolbar);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_user_posts;
    }

    @Override
    public void onClick(View view) {

    }

    @OnClick(R.id.user_posts_back)
    public void onClick() {
        finish();
    }
}
