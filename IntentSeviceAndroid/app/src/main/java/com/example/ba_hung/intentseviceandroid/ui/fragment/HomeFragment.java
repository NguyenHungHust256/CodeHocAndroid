package com.example.ba_hung.intentseviceandroid.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ba_hung.intentseviceandroid.R;
import com.example.ba_hung.intentseviceandroid.services.MyService1;

public class HomeFragment extends Fragment implements View.OnClickListener {
    private View v;
    private Intent intent;

    Button btnStart, btnStop;
    public HomeFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       v =  inflater.inflate(R.layout.fragment_home, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AnhXa();
        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
    }

    private void AnhXa() {
        btnStart = v.findViewById(R.id.btnStart);
        btnStop =  v.findViewById(R.id.btnStop);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnStart){
//            De chuyen man hinh thi su dung intent
//            muon gui di tin hieu trong Boardcasr dungf intent
//            Khoi dong 1 service cung dung intent
            if(intent==null){
                intent = new Intent(getActivity(), MyService1.class);
                getActivity().startService(intent);
            }
        }
        else if(view.getId() == R.id.btnStop){
            if(intent!=null){
                getActivity().stopService(intent);
            }
        }
    }
}
