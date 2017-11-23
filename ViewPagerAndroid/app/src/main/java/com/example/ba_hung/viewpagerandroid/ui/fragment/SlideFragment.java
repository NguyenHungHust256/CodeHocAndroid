package com.example.ba_hung.viewpagerandroid.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ba_hung.viewpagerandroid.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SlideFragment extends Fragment {


    public SlideFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_slide, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView img = (ImageView) view.findViewById(R.id.img);
        Bundle bd = getArguments();
        if(bd!=null){
            int idAnh = bd.getInt("idAnh");
            img.setImageResource(idAnh);
        }
    }

    public static SlideFragment doiTuongMoi(int idAnh) {
        SlideFragment slideFragment = new SlideFragment();
        Bundle bd = new Bundle();
        bd.putInt("idAnh", idAnh);
        slideFragment.setArguments(bd);
        return slideFragment;
    }
}
