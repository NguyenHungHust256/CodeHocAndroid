package com.example.ba_hung.checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    private CheckBox cbxShopping, cbxPlayFootball, cbxTravel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbxShopping = (CheckBox) this.findViewById(R.id.cbShopping);
        cbxPlayFootball = (CheckBox) this.findViewById(R.id.cbFootball);
        cbxTravel = (CheckBox) this.findViewById(R.id.cbTravel);

        cbxShopping.setOnCheckedChangeListener(this);
        cbxPlayFootball.setOnCheckedChangeListener(this);
        cbxTravel.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(buttonView==cbxShopping && isChecked==true)
        {
            Toast.makeText(this, "You wanna go shopping", Toast.LENGTH_SHORT).show();
        }
        if(buttonView==cbxPlayFootball && isChecked==true){
            Toast.makeText(this, "You wanna play football", Toast.LENGTH_SHORT).show();
        }
        if(buttonView==cbxTravel && isChecked==true){
            Toast.makeText(this, "You wanna go travel",Toast.LENGTH_SHORT).show();
        }
    }
}
