package jqchen.dentalforum.search;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import jqchen.dentalforum.R;
import jqchen.dentalforum.library.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchDefaultFragment extends BaseFragment {

    public SearchDefaultFragment() {
        // Required empty public constructor
    }

    public static SearchDefaultFragment getInstance(){
        return new SearchDefaultFragment();
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_search_default;
    }

    @Override
    public void initData() {

    }

}
