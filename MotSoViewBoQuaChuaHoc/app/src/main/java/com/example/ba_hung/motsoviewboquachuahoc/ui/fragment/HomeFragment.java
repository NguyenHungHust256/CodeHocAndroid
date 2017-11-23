package com.example.ba_hung.motsoviewboquachuahoc.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.ba_hung.motsoviewboquachuahoc.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private View mView;
    @BindView(R.id.cbMusic)
    CheckBox cbMusic;
    @BindView(R.id.cbFilm)
    CheckBox cbFilm;
    @BindView(R.id.cbDance)
    CheckBox cbDance;
    @BindView(R.id.rgGioiTinh)
    RadioGroup rgGioiTinh;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, mView);
        return mView;
    }

    @OnCheckedChanged({R.id.cbMusic, R.id.cbFilm, R.id.cbDance})
    public void listentCheckBox(CompoundButton view, boolean isChecked) {
        switch (view.getId()) {
            case R.id.cbMusic:
                if (cbMusic.isChecked()) {
                    Toast.makeText(getActivity(), "Music được tích", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "Music bỏ tích", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.cbFilm:
                if (cbFilm.isChecked()) {
                    Toast.makeText(getActivity(), "Film được tích", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "Film bỏ tích", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.cbDance:
                if (cbDance.isChecked()) {
                    Toast.makeText(getActivity(), "Movie được tích", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "Movie bỏ tích", Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }

    @OnClick({R.id.rbNam, R.id.rbNu})
    public void radioGroupUpdate(RadioButton rbButton) {
        switch (rbButton.getId()){
            case R.id.rbNam:
                Toast.makeText(getContext(), "Nam", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbNu:
                Toast.makeText(getActivity(), "Nu", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}


