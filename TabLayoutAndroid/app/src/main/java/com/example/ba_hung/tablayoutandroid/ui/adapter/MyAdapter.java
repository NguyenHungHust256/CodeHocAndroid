package com.example.ba_hung.tablayoutandroid.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.ba_hung.tablayoutandroid.ui.fragment.AFragment;
import com.example.ba_hung.tablayoutandroid.ui.fragment.BFragment;
import com.example.ba_hung.tablayoutandroid.ui.fragment.CFragment;

/**
 * Created by ba-hung on 13/09/2017.
 */

public class MyAdapter extends FragmentPagerAdapter {
    public static final int PAGE_COUNT = 3;
    public static final String tieuDeTabs[] = new String[]{"Tab 1", "Tab 2", "Tab 3"};

    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if(position == 0){
            fragment = new AFragment();

        } else if(position == 1){
            fragment = new BFragment();
        } else if(position == 2){
            fragment = new CFragment();
        }
        return  fragment;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tieuDeTabs[position];
    }
}
