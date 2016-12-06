package jqchen.dentalforum.common;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Created by jqchen on 2016/10/17.
 * Use to
 */
public class TabPagerAdapter extends FragmentPagerAdapter {
    private LinkedHashMap<String, Fragment> fragments;
    private ArrayList<String> titles;

    public TabPagerAdapter(FragmentManager fm, LinkedHashMap<String, Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
        titles = new ArrayList<>();
        titles.addAll(fragments.keySet());
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(titles.get(position));
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
