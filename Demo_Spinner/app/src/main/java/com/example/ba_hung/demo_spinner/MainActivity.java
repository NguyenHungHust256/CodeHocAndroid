package com.example.ba_hung.demo_spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private Spinner spnPhoneType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnPhoneType = (Spinner) findViewById(R.id.spn_phoneType);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.phone_type, R.layout.support_simple_spinner_dropdown_item);
        spnPhoneType.setAdapter(adapter);
    }
}
