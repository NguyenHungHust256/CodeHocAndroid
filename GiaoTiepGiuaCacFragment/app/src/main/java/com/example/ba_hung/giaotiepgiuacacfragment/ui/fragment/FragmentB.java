package com.example.ba_hung.giaotiepgiuacacfragment.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ba_hung.giaotiepgiuacacfragment.R;
import com.example.ba_hung.giaotiepgiuacacfragment.model.QuocGiaModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentB extends Fragment {

    TextView txtHienThiQG;

    public FragmentB() {
        // Required empty public constructor
    }

    public  static FragmentB doiTuongMoi(QuocGiaModel quocGia){
        FragmentB fragmentB = new FragmentB();
        Bundle bundle = new Bundle();
        bundle.putSerializable("tenqg",quocGia);
        fragmentB.setArguments(bundle);
        return fragmentB;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txtHienThiQG = (TextView) view.findViewById(R.id.txtHienThiTen);
    }

    public void thayDoiChuoi(QuocGiaModel quocGia){
        txtHienThiQG.setText(quocGia.getTenQuocGia());
    }
}
