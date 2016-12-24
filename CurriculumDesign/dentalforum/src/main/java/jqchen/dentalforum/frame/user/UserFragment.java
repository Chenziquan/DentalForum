package jqchen.dentalforum.frame.user;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import jqchen.dentalforum.R;
import jqchen.dentalforum.data.bean.UserBean;
import jqchen.dentalforum.library.BaseFragment;
import jqchen.dentalforum.user.collection.UserCollectionActivity;
import jqchen.dentalforum.user.info.UserInfoActivity;
import jqchen.dentalforum.user.navigatesigin.NavigateSiginActivity;
import jqchen.dentalforum.user.posts.UserPostsActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends BaseFragment implements UserContract.View {
    @BindView(R.id.user_sign_out)
    LinearLayout userSignOut;
    @BindView(R.id.user_sign_portrait)
    ImageView userSignPortrait;
    @BindView(R.id.user_sign_in_name)
    TextView userSignInName;
    @BindView(R.id.user_sign_in_integration)
    TextView userSignInIntegration;
    @BindView(R.id.user_sign_in)
    RelativeLayout userSignIn;
    @BindView(R.id.user_num_posts)
    TextView userNumPosts;
    @BindView(R.id.user_num_wealth)
    TextView userNumWealth;
    @BindView(R.id.user_num_collection)
    TextView userNumCollection;
    private Unbinder unbinder;
    private UserPresenter mPresenter;

    public UserFragment() {
        // Required empty public constructor
    }

    public static UserFragment getInstance() {
        return new UserFragment();
    }


    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this, view);
        mPresenter = new UserPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_user;
    }

    @Override
    public void initData() {

    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void showSignOut() {
        userSignOut.setVisibility(View.VISIBLE);
        userSignIn.setVisibility(View.GONE);
        userNumPosts.setText("0");
        userNumWealth.setText("0");
        userNumCollection.setText("0");
    }

    @Override
    public void showSignIn(UserBean bean) {
        userSignIn.setVisibility(View.VISIBLE);
        userSignOut.setVisibility(View.GONE);
        userSignInName.setText(bean.getPhone());
        userSignInIntegration.setText(bean.getIntegration());
        userNumPosts.setText(bean.getPosts());
        userNumWealth.setText(bean.getWealth());
        userNumCollection.setText(bean.getCollections());
    }

    @Override
    public void goLoginIn() {
        Intent intent = new Intent(getHoldingActivity(), NavigateSiginActivity.class);
        startActivity(intent);
    }

    @Override
    public void goUserInfo() {
        Intent intent = new Intent(getHoldingActivity(), UserInfoActivity.class);
        startActivity(intent);
    }

    @Override
    public void goUserPosts() {
        Intent intent = new Intent(getHoldingActivity(), UserPostsActivity.class);
        startActivity(intent);
    }

    @Override
    public void setPresenter(Object presenter) {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showNormal() {

    }

    @OnClick({R.id.user_sign_out, R.id.user_sign_in, R.id.user_posts, R.id.user_wealth, R.id.user_collection, R.id.user_exit_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.user_sign_out:
                goLoginIn();
                break;
            case R.id.user_sign_in:
                goUserInfo();
                break;
            case R.id.user_posts:
                mPresenter.goUserPosts();
                break;
            case R.id.user_wealth:
                break;
            case R.id.user_collection:
                mPresenter.goUserCollection();
                break;
            case R.id.user_exit_login:
                mPresenter.signOut();
                break;
        }
    }


    @Override
    public void goUserCollection() {
        Intent intent = new Intent(getHoldingActivity(), UserCollectionActivity.class);
        startActivity(intent);
    }
}
