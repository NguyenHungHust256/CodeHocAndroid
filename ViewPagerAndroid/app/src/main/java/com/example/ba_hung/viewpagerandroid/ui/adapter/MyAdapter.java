package com.example.ba_hung.viewpagerandroid.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.ba_hung.viewpagerandroid.R;
import com.example.ba_hung.viewpagerandroid.ui.fragment.SlideFragment;

/**
 * Created by ba-hung on 11/09/2017.
 **/
// RecycleView
public class MyAdapter extends FragmentPagerAdapter {
    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return SlideFragment.doiTuongMoi(R.drawable.index1);
            case 1:
                return SlideFragment.doiTuongMoi(R.drawable.index2);
            case 2:
                return SlideFragment.doiTuongMoi(R.drawable.index3);
            case 3:
                return SlideFragment.doiTuongMoi(R.drawable.index4);
            case 4:
                return SlideFragment.doiTuongMoi(R.drawable.index5);
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return 5; // Bởi vì chỉ có 5 ảnh
    }


}
