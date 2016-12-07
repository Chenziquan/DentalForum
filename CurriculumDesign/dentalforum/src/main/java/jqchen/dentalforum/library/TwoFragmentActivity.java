package jqchen.dentalforum.library;

import android.content.Intent;
import android.os.Bundle;

/**
 * Created by jqchen on 2016/12/7.
 * Use to
 */
public abstract class TwoFragmentActivity extends BaseActivity {
    //获取第一个fragment
    protected abstract BaseFragment getFirstFragment();

    //获取Intent
    protected void handleIntent(Intent intent) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());

        if (null != getIntent()) {
            handleIntent(getIntent());
        }
        //避免重复添加Fragment
        if (null == getSupportFragmentManager().getFragments()) {
            BaseFragment firstFragment = getFirstFragment();
            if (null != firstFragment) {
                addFragment(firstFragment);
            }
        }
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }*/

        ActivityManager.getInstance().addActivity(this);
    }

    @Override
    protected void addFragment(BaseFragment fragment) {
        if (getSupportFragmentManager().getBackStackEntryCount() == 1){
            hideFirstFragment();
        }else if (getSupportFragmentManager().getBackStackEntryCount() == 2){
            getSupportFragmentManager().popBackStack();
        }
        super.addFragment(fragment);
    }

    @Override
    protected void removeFragment() {
        super.removeFragment();
        if (getSupportFragmentManager().getBackStackEntryCount() == 2){
            showFirstFragment();
        }
    }

    protected void hideFirstFragment(){
        getSupportFragmentManager().beginTransaction()
                .hide(getFirstFragment())
                .commit();
    }
    protected void showFirstFragment(){
        getSupportFragmentManager().beginTransaction()
                .show(getFirstFragment())
                .commit();
    }

    @Override
    protected int getContentViewId() {
        return 0;
    }

    @Override
    protected int getFragmentContentId() {
        return 0;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManager.getInstance().finishActivity(this);
    }
}
