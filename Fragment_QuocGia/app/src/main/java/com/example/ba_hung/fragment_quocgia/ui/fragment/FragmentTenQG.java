package com.example.ba_hung.fragment_quocgia.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.ba_hung.fragment_quocgia.R;
import com.example.ba_hung.fragment_quocgia.model.QuocGiaModel;
import com.example.ba_hung.fragment_quocgia.ui.activity.MainActivity;
import com.example.ba_hung.fragment_quocgia.ui.adapter.QuocGiaAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTenQG extends Fragment {


    public FragmentTenQG() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_ten_qg, container, false);
        // Inflate the layout for this fragment
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final ArrayList<QuocGiaModel> datas = new ArrayList<>();
        datas.add(new QuocGiaModel("VietNam"));
        datas.add(new QuocGiaModel("VietNam"));
        datas.add(new QuocGiaModel("VietNam"));
        datas.add(new QuocGiaModel("VietNam"));
        datas.add(new QuocGiaModel("VietNam"));
        datas.add(new QuocGiaModel("VietNam"));
        datas.add(new QuocGiaModel("VietNam"));
        datas.add(new QuocGiaModel("VietNam"));

        super.onViewCreated(view, savedInstanceState);
        ListView lv = (ListView) view.findViewById(R.id.lvTenQG);

        QuocGiaAdapter adapter = new QuocGiaAdapter(getActivity(), datas);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ((MainActivity) getActivity()).themFragment(R.id.myLayout, Fragment_Hien_Thi.doiTuongMoi(datas.get(position)));
            }
        });
    }
}
