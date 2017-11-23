package com.example.ba_hung.tablayoutandroid.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ba_hung.tablayoutandroid.R;
import com.example.ba_hung.tablayoutandroid.ui.activity.MainActivity;
import com.example.ba_hung.tablayoutandroid.ui.adapter.MyAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragment extends Fragment {
    private View mView;
    public static TabFragment doiTuongMoi(String noidung){
        TabFragment tabFragment = new TabFragment();
        Bundle bd = new Bundle();
        bd.putString("noidung", noidung);
        tabFragment.setArguments(bd);
        return  tabFragment;
    }

    public TabFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_tab, container, false);

        ((MainActivity)getActivity()).getSupportActionBar().setElevation(0);

        ViewPager viewPager = (ViewPager) mView.findViewById(R.id.viewpager);
        TabLayout tabLayout =(TabLayout) mView.findViewById(R.id.tabLayout);
        MyAdapter adapter = new MyAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
