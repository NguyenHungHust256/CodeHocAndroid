package com.example.ba_hung.fragment_quocgia.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ba_hung.fragment_quocgia.R;
import com.example.ba_hung.fragment_quocgia.model.QuocGiaModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Hien_Thi extends Fragment {


    public Fragment_Hien_Thi() {

    }

    public  static Fragment_Hien_Thi doiTuongMoi(QuocGiaModel quocGia){
        Fragment_Hien_Thi fragment_hien_thi = new Fragment_Hien_Thi();
        Bundle bundle = new Bundle();
        bundle.putSerializable("tenqg",quocGia);
        fragment_hien_thi.setArguments(bundle);
        return fragment_hien_thi;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment__hien__thi, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        TextView txt = (TextView) view.findViewById(R.id.txtHienThi);
        QuocGiaModel noiDungCanLay =(QuocGiaModel) getArguments().getSerializable("tenqg");
        txt.setText(noiDungCanLay.getTenQuocGia());

    }
}
