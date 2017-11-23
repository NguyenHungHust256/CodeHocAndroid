package com.example.ba_hung.viewflipperandroid.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.example.ba_hung.viewflipperandroid.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private View mView;
    private ViewFlipper mViewFlipper;
    public float xDown, xUp;
    private ImageView img1, img2, img3;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_home, container, false);
        mView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        xDown = motionEvent.getX(); //Lay toa do khi nguoi dung cham tay xuong
                        break;
                    case MotionEvent.ACTION_UP:
                        xUp = motionEvent.getX(); // lay toan do nguoi dung khi nhac tay ra
                        if (xDown>xUp){
                            mViewFlipper.showNext();
                        } else if(xDown<xUp){
                            mViewFlipper.showPrevious();
                        }
                        break;
                }
                return true;
            }
        });
        return mView;
    }

    private void loadAnh() {
        Glide.with(getActivity()).load("http://cms.kienthuc.net.vn/zoom/1000/uploaded/nguyenanhson/2016_05_06/9/bi-chup-len-luc-nho-long-vit-gai-xinh-bat-ngo-noi-tieng-hinh-3.jpg").into(img1);
        Glide.with(getActivity()).load("https://s1.anh.im/2015/04/10/girl-xinh-gocsex.blogspot92b291.jpg").into(img2);
        Glide.with(getActivity()).load("http://www.tieuthien.com/wp-content/uploads/2016/10/hot-girl-gai-xinh-facebook-tieuthien.com-5.jpg").into(img3);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        anhXa();
        loadAnh();

        mViewFlipper= view.findViewById(R.id.viewFlipper);
//        mViewFlipper.setAutoStart(true);
//        mViewFlipper.setFlipInterval(1000);
        mViewFlipper.setInAnimation(getActivity(), android.R.anim.fade_in);
        mViewFlipper.setOutAnimation(getActivity(), android.R.anim.fade_out);
    }

    private void anhXa() {
        img1 = mView.findViewById(R.id.img1);
        img2 = mView.findViewById(R.id.img2);
        img3 = mView.findViewById(R.id.img3);
    }
}
