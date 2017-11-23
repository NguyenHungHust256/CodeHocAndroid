package com.example.ba_hung.fragmentbatsukiencuaview;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by ba-hung on 25/08/2017.
 **/

public class FragmentA extends Fragment {
    TextView txtA;
    EditText edtA;
    Button btnA;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v;
        v = inflater.inflate(R.layout.fragment_a, container, false);
        txtA = (TextView)v.findViewById(R.id.txtA);
        edtA = (EditText) v.findViewById(R.id.edtA);
        btnA = (Button) v.findViewById(R.id.btnA);

        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txtChangedText = (TextView) getActivity().findViewById(R.id.txtText);
                txtChangedText.setText(edtA.getText().toString());
            }
        });
        return v;
    }
}
