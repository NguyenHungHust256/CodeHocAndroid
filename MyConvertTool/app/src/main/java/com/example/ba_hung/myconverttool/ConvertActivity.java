package com.example.ba_hung.myconverttool;

import android.support.annotation.FloatRange;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class ConvertActivity extends AppCompatActivity implements OnItemSelectedListener {
    private EditText edtInput;
    private TextView lblResult;
    private Spinner spnUnit;

    private int convertType;



    private int currentUnit = 0; // meter
                                                        // meter           | mile           | cm            |inch             |yd
    private float[][] arrDistanceConvertRate = {        { 1,                0.000621371f,    100f,          39.3701f,         1.09361f},
                                                        {1609.339f,         1,               160933.9f,     63359.8f,         1759.99f},
                                                        {0.01f,             9.999969f,       1,             0.39369f,         0.01093f},
                                                        {0.025399f,         1.5782f,         2.53999f,      1,                0.02777f},
                                                        {0.914f,            0.000568f,       91.4397f,      35.999f,          1}
                                               };

    private String[] arrUnit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);
        //convert Type
        convertType = getIntent().getExtras().getInt("convert_type");
        //find View
        edtInput = (EditText) this.findViewById(R.id.edt_input);
        lblResult = (TextView) this.findViewById(R.id.lbl_result);
        spnUnit = (Spinner) this.findViewById(R.id.spn_unit);

        // get values of arUnit

        arrUnit = getResources().getStringArray(R.array.unit);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.unit,R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spnUnit.setAdapter(adapter);

        spnUnit.setOnItemSelectedListener(this);



        edtInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                convert(currentUnit, getConvertRateMatrix(convertType));
            }
        });
    }
    private void convert(int currentUnit, float[][] arrConvertRate)
    {
        //check input
        if(edtInput.getText().toString().trim().length()<=0)
        {
            lblResult.setText("Result");
            return;
        }

        //convert
        float input = Float.parseFloat(edtInput.getText().toString());
        String result = "";
        for(int i=0;i<arrUnit.length;i++)
        {
            if(currentUnit != i)
            {
                result+=arrUnit[i];
                result += " : ";
                result += input*arrConvertRate[currentUnit][i] + "\n";

            }
        }
        lblResult.setText(result);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        currentUnit = position;
        convert(currentUnit,arrDistanceConvertRate);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private float[][] getConvertRateMatrix(int convertType){
        switch(convertType)
        {
            case MainActivity.DISTANCE_CONVERT :
                return arrDistanceConvertRate;
            default:
                return null;
        }
    }
}
