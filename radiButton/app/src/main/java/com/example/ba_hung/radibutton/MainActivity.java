package com.example.ba_hung.radibutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    private RadioButton radMale, radFemale;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radMale = (RadioButton) this.findViewById(R.id.rdMale);
        radFemale = (RadioButton) this.findViewById(R.id.rdFemale);

        radMale.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) this);

        radFemale.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) this);

    }

    

}
