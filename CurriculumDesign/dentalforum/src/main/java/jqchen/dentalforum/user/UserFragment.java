package jqchen.dentalforum.user;


import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;

import jqchen.dentalforum.R;
import jqchen.dentalforum.library.LoadOnceFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends LoadOnceFragment {


    public UserFragment() {
        // Required empty public constructor
    }

    public static UserFragment getInstance(){
        return new UserFragment();
    }


    @Override
    protected View initView(LayoutInflater inflater) {
        return inflater.inflate(R.layout.fragment_user, null);
    }

    @Override
    public void initData() {

    }

}
