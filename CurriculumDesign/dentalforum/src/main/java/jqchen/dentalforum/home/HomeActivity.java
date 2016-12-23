package jqchen.dentalforum.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;

import java.util.LinkedHashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jqchen.dentalforum.R;
import jqchen.dentalforum.common.TabPagerAdapter;
import jqchen.dentalforum.frame.posts.PostsFragment;
import jqchen.dentalforum.frame.recommend.RecommendFragment;
import jqchen.dentalforum.frame.user.UserFragment;
import jqchen.dentalforum.function.search.SearchActivity;
import jqchen.dentalforum.library.AppActivity;
import jqchen.dentalforum.library.BaseFragment;
import jqchen.dentalforum.post.post.them.PostThemActivity;

public class HomeActivity extends AppActivity {


    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.home_viewpager)
    ViewPager homeViewpager;
    @BindView(R.id.home_tablayout)
    TabLayout homeTablayout;
    @BindView(R.id.home_toolbar)
    Toolbar homeToolbar;

    private long exitTime = 0;

    @Override
    protected BaseFragment getFirstFragment() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initToolbar();
        initAdapter();
        setListener();
        fab.hide();
    }

    private void setListener() {
        homeViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 1) {
                    fab.show();
                } else {
                    fab.hide();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initAdapter() {
        LinkedHashMap<String, Fragment> map = new LinkedHashMap<>();
        map.put(getString(R.string.fragment_recommend), RecommendFragment.getInstance());
        map.put(getString(R.string.fragment_post), PostsFragment.getInstance());
        map.put(getString(R.string.fragment_user), UserFragment.getInstance());
        TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), map);
        homeViewpager.setAdapter(tabPagerAdapter);
        homeTablayout.setupWithViewPager(homeViewpager);
    }

    private void initToolbar() {
        setSupportActionBar(homeToolbar);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_home;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            //两秒之内按返回键就会退出
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Snackbar.make(fab, getString(R.string.exit_text), Snackbar.LENGTH_LONG).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @OnClick({R.id.home_setup, R.id.home_search, R.id.fab})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home_setup:
                Snackbar.make(fab, getString(R.string.home_setup), Snackbar.LENGTH_LONG).show();
                break;
            case R.id.home_search:
//                Snackbar.make(fab, getString(R.string.home_search), Snackbar.LENGTH_LONG).show();
                startActivity(new Intent(HomeActivity.this, SearchActivity.class));
                break;
            case R.id.fab:
//                Snackbar.make(fab, getString(R.string.add_post), Snackbar.LENGTH_LONG).show();
                startActivity(new Intent(this, PostThemActivity.class));
                break;
        }
    }
}
