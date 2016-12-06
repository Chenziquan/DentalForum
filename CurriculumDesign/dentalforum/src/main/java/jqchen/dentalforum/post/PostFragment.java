package jqchen.dentalforum.post;


import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;

import jqchen.dentalforum.R;
import jqchen.dentalforum.library.LoadOnceFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class PostFragment extends LoadOnceFragment {


    public PostFragment() {
        // Required empty public constructor
    }

    public static PostFragment getInstance(){
        return new PostFragment();
    }


    @Override
    protected View initView(LayoutInflater inflater) {
        return inflater.inflate(R.layout.fragment_post, null);
    }

    @Override
    public void initData() {

    }

}
