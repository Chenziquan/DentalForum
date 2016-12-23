package jqchen.dentalforum.post.detail.comment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jqchen.dentalforum.R;
import jqchen.dentalforum.library.AppActivity;
import jqchen.dentalforum.library.BaseFragment;
import jqchen.dentalforum.util.StringUtil;

public class PostDetailActivity extends AppActivity {

    @BindView(R.id.post_detail_title)
    TextView postDetailTitle;
    @BindView(R.id.post_detail_toolbar)
    Toolbar postDetailToolbar;
    private String title;
    private int postId;
    private PostDetailFragment postDetailFragment;

    @Override
    protected BaseFragment getFirstFragment() {
        Intent intent = getIntent();
        postId = intent.getIntExtra(getString(R.string.post_id), 0);
        title = intent.getStringExtra(getString(R.string.post_title));
        Bundle bundle = new Bundle();
        bundle.putInt(getString(R.string.post_id), postId);
        postDetailFragment = PostDetailFragment.getInstance(bundle);
        return postDetailFragment;
    }

    @Override
    protected int getFragmentContentId() {
        return R.id.post_detail_fragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initToolBar();
        if (!StringUtil.isEmpty(title)) {
            postDetailTitle.setText(title);
        }
    }

    private void initToolBar() {
        setSupportActionBar(postDetailToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_post_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.post_detail_refresh:
                Log.e("menu", "refresh");
                postDetailFragment.refresh();
                break;
            case R.id.post_detail_collect:
                Log.e("menu", "collect");
                postDetailFragment.collection(postId);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_post_detail;
    }

    @Override
    public void onClick(View view) {

    }

    @OnClick(R.id.post_detail_back)
    public void onClick() {
        finish();
    }
}
