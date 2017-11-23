package com.example.ba_hung.butterknifeandroid.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ba_hung.butterknifeandroid.R;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private View view;
    @BindView(R.id.txtHello)
    TextView txtHello;
   

    @BindString(R.string.hello_java) String helloJava;
    @BindString(R.string.hello_android) String helloAndroid;
    @BindString(R.string.hello_ios) String helloIOS;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.btnChange, R.id.btnChangeAndroid, R.id.btnChangeIOS })
    public void onClick(View view) {
        if(view.getId()==R.id.btnChange){
            txtHello.setText(helloJava);
        }
        else if(view.getId() == R.id.btnChangeAndroid){
            txtHello.setText(helloAndroid);
        }else if(view.getId() ==R.id.btnChangeIOS){
            txtHello.setText(helloIOS);
        }
    }


}
