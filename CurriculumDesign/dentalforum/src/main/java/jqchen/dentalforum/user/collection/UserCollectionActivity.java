package jqchen.dentalforum.user.collection;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jqchen.dentalforum.R;
import jqchen.dentalforum.library.AppActivity;
import jqchen.dentalforum.library.BaseFragment;

public class UserCollectionActivity extends AppActivity {

    @BindView(R.id.user_collection_toolbar)
    Toolbar userCollectionToolbar;

    @Override
    protected BaseFragment getFirstFragment() {
        return UserCollectionFragment.getInstance();
    }

    @Override
    protected int getFragmentContentId() {
        return R.id.user_collection_fragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initToolBar();
    }

    private void initToolBar() {
        setSupportActionBar(userCollectionToolbar);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_user_collection;
    }

    @Override
    public void onClick(View view) {

    }

    @OnClick(R.id.user_collection_back)
    public void onClick() {
        finish();
    }
}
