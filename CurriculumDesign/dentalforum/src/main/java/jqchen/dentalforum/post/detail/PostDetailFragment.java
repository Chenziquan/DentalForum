package jqchen.dentalforum.post.detail;

import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import jqchen.dentalforum.R;
import jqchen.dentalforum.library.BaseFragment;

/**
 * 帖子内容
 */
public class PostDetailFragment extends BaseFragment {
    private Unbinder unbinder;

    public static PostDetailFragment getInstance() {
        return new PostDetailFragment();
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this,view);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_post_detail;
    }

    @Override
    public void initData() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
