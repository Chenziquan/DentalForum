package jqchen.dentalforum.post.post.content;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jqchen.dentalforum.R;
import jqchen.dentalforum.common.ForumAlertDialog;
import jqchen.dentalforum.library.AppActivity;
import jqchen.dentalforum.library.BaseFragment;

public class PostContentActivity extends AppActivity {

    @BindView(R.id.post_content_toolbar)
    Toolbar postContentToolbar;
    @BindView(R.id.post_content_title)
    EditText postContentTitle;
    @BindView(R.id.post_content_content)
    EditText postContentContent;
    private ForumAlertDialog forumAlertDialog;

    @Override
    protected BaseFragment getFirstFragment() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initToolBar();

    }

    private void initToolBar() {
        setSupportActionBar(postContentToolbar);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_post_content;
    }


    @OnClick({R.id.post_content_cancel, R.id.post_content_submit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.post_content_cancel:
                break;
            case R.id.post_content_submit:
                break;
        }
    }
}
