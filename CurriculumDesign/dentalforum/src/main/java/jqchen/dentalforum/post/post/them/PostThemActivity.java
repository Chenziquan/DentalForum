package jqchen.dentalforum.post.post.them;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jqchen.dentalforum.R;
import jqchen.dentalforum.library.AppActivity;
import jqchen.dentalforum.library.BaseFragment;

public class PostThemActivity extends AppActivity {

    @BindView(R.id.post_them_toolbar)
    Toolbar postThemToolbar;

    @Override
    protected BaseFragment getFirstFragment() {
        return PostThemFragment.getInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initToolBar();
    }

    private void initToolBar() {
        setSupportActionBar(postThemToolbar);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_post_them;
    }

    @Override
    protected int getFragmentContentId() {
        return R.id.post_them_fragment;
    }

    @Override
    public void onClick(View view) {

    }

    @OnClick(R.id.post_them_back)
    public void onClick() {
        finish();
    }
}
