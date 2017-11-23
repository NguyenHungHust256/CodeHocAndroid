package com.example.ba_hung.giaotieptrongfragment.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ba_hung.giaotieptrongfragment.R;
import com.example.ba_hung.giaotieptrongfragment.model.CauHoiModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentB extends Fragment {

    private ArrayList<CauHoiModel> duLieuCauHoi;
    private int viTriCauHoi = 0;

    public FragmentB() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        duLieuCauHoi = new ArrayList<>();
        taoCauHoi();
        final TextView txtCauHoi = (TextView) view.findViewById(R.id.txtCauHoi);
        Button btnTrue = (Button) view.findViewById(R.id.btnTrue);
        Button btnFalse = (Button) view.findViewById(R.id.btnFalse);
        txtCauHoi.setText(duLieuCauHoi.get(viTriCauHoi).getTenCauHoi());
        btnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Khi nguoi choi chon dap an la True

                if (duLieuCauHoi.get(viTriCauHoi).isDapAnDung()) {
                    // Tra loi dung chuyen sang cau tiep theo
                    if (viTriCauHoi > duLieuCauHoi.size()) {
                        Toast.makeText(getActivity(), "You Win!!!", Toast.LENGTH_SHORT).show();
                    } else {
                        viTriCauHoi++;
                        txtCauHoi.setText(duLieuCauHoi.get(viTriCauHoi).getTenCauHoi());
                    }
                } else {
                    Toast.makeText(getActivity(), "Game Over", Toast.LENGTH_SHORT).show();

                }
            }
        });
        btnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!duLieuCauHoi.get(viTriCauHoi).isDapAnDung()) {

                    if (viTriCauHoi > duLieuCauHoi.size()) {
                        Toast.makeText(getActivity(), "You Win!!!", Toast.LENGTH_SHORT).show();
                    } else {
                        viTriCauHoi++;// Tra loi dung chuyen sang cau tiep theo
                        txtCauHoi.setText(duLieuCauHoi.get(viTriCauHoi).getTenCauHoi());
                    }
                } else {

                    Toast.makeText(getActivity(), "Game Over", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    private void taoCauHoi() {
//        Tao cau hoi o trong nay
        duLieuCauHoi.add(new CauHoiModel("2 + 3 = 5", true));
        duLieuCauHoi.add(new CauHoiModel("2 + 7 = 9", true));
        duLieuCauHoi.add(new CauHoiModel("11 + 5 = 17", false));
        duLieuCauHoi.add(new CauHoiModel("4 + 3 = 7", true));
        duLieuCauHoi.add(new CauHoiModel("2 + 88 = 101", false));
        duLieuCauHoi.add(new CauHoiModel("19 + 83 = 102", true));
        duLieuCauHoi.add(new CauHoiModel("29 + 345 = 354", true));
        duLieuCauHoi.add(new CauHoiModel("67 + 34 = 101", true));
        duLieuCauHoi.add(new CauHoiModel("23 + 35 = 58", true));

    }
}
