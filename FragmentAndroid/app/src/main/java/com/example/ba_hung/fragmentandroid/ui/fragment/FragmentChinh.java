package com.example.ba_hung.fragmentandroid.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ba_hung.fragmentandroid.R;

/**
 * Created by ba-hung on 01/09/2017.
 **/

public class FragmentChinh extends Fragment{
//    Hàm này giúp ta kết nối file java bên này với file giao diện bên kia
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_chinh, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final TextView txtHello = (TextView) view.findViewById(R.id.txtHello);
        Button btnChange = (Button) view.findViewById(R.id.btnChange);
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtHello.setText("Hello Ba Hung");
            }
        });
    }

}
