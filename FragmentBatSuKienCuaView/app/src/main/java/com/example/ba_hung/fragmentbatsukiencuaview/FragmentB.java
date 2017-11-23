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

public class FragmentB extends Fragment {
    TextView txtB;
    EditText edtB;
    Button btnB;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_b, container, false);
        txtB = (TextView) v.findViewById(R.id.txtB);
        edtB = (EditText) v.findViewById(R.id.edtB);
        btnB = (Button) v.findViewById(R.id.btnB);

        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txtB = (TextView) getActivity().findViewById(R.id.txtA);
                txtB.setText(edtB.getText().toString());
            }
        });
        return v;
    }
}
