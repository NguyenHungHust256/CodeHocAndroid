package com.example.ba_hung.giaotiepgiuacacfragment.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.ba_hung.giaotiepgiuacacfragment.R;
import com.example.ba_hung.giaotiepgiuacacfragment.model.QuocGiaModel;
import com.example.ba_hung.giaotiepgiuacacfragment.ui.activity.MainActivity;
import com.example.ba_hung.giaotiepgiuacacfragment.ui.adapter.QuocGiaAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentA extends Fragment {


    public FragmentA() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_a, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final ArrayList<QuocGiaModel> datas = new ArrayList<>();
        datas.add(new QuocGiaModel("VietNam"));
        datas.add(new QuocGiaModel("Lao"));
        datas.add(new QuocGiaModel("ThaiLan"));
        datas.add(new QuocGiaModel("Campuchia"));
        datas.add(new QuocGiaModel("Singapore"));
        datas.add(new QuocGiaModel("AnDo"));
        datas.add(new QuocGiaModel("My"));
        datas.add(new QuocGiaModel("Anh"));
        datas.add(new QuocGiaModel("VietNam"));
        datas.add(new QuocGiaModel("Lao"));
        datas.add(new QuocGiaModel("ThaiLan"));
        datas.add(new QuocGiaModel("Campuchia"));
        datas.add(new QuocGiaModel("Singapore"));
        datas.add(new QuocGiaModel("AnDo"));
        datas.add(new QuocGiaModel("My"));
        datas.add(new QuocGiaModel("Anh"));
        datas.add(new QuocGiaModel("VietNam"));
        datas.add(new QuocGiaModel("Lao"));
        datas.add(new QuocGiaModel("ThaiLan"));
        datas.add(new QuocGiaModel("Campuchia"));
        datas.add(new QuocGiaModel("Singapore"));
        datas.add(new QuocGiaModel("AnDo"));
        datas.add(new QuocGiaModel("My"));
        datas.add(new QuocGiaModel("Anh"));

        super.onViewCreated(view, savedInstanceState);
        ListView lv = (ListView) view.findViewById(R.id.lvQG);

        QuocGiaAdapter adapter = new QuocGiaAdapter(getActivity(), datas);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                ((MainActivity) getActivity()).doiThongTin(datas.get(position));
                ((MainActivity) getActivity()).doiThongTin(datas.get(position));
            }
        });

    }

    public interface CallBacks {
        void doiThongTin(QuocGiaModel quocGia);
    }

}
