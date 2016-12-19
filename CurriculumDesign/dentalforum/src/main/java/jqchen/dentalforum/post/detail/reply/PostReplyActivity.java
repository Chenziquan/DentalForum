package jqchen.dentalforum.post.detail.reply;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jqchen.dentalforum.R;
import jqchen.dentalforum.library.AppActivity;
import jqchen.dentalforum.library.BaseFragment;

public class PostReplyActivity extends AppActivity {

    @BindView(R.id.post_reply_title)
    TextView postReplyTitle;
    @BindView(R.id.post_reply_toolbar)
    Toolbar postReplyToolbar;

    @Override
    protected BaseFragment getFirstFragment() {
        PostReplyFragment postReplyFragment = PostReplyFragment.getInstance();
        Intent intent = getIntent();
        Bundle bundle = new Bundle();
        bundle.putParcelable(getString(R.string.post_reply_bean), intent.getParcelableExtra(getString(R.string.post_reply_bean)));
        postReplyFragment.setArguments(bundle);
        return postReplyFragment;
    }

    @Override
    protected int getFragmentContentId() {
        return R.id.post_reply_fragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initToolBar();
    }

    private void initToolBar() {
        setSupportActionBar(postReplyToolbar);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_post_reply;
    }

    @Override
    public void onClick(View view) {

    }

    @OnClick(R.id.post_reply_back)
    public void onClick() {
        finish();
    }
}
