package com.example.ba_hung.progressbar;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnDownload;
    ProgressBar pbXuLy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDownload = (Button) findViewById(R.id.btnDownload);
        pbXuLy = (ProgressBar) findViewById(R.id.pbXuLy);


        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CountDownTimer countDownTimer = new CountDownTimer(10000, 200) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        int current = pbXuLy.getProgress();
                        if (current >= pbXuLy.getMax())
                            current = 0;
                        pbXuLy.setProgress(current + 10);
                    }

                    @Override
                    public void onFinish() {
                        this.start();
                        Toast.makeText(MainActivity.this, "Hết Giờ.", Toast.LENGTH_SHORT).show();
                    }
                };
                countDownTimer.start();
            }

        });
    }
}
