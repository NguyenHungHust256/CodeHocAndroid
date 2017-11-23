package com.example.ba_hung.breakingmath;

import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.RunnableFuture;

public class PlayActivity extends AppCompatActivity implements View.OnClickListener {

    // Time to play each level
    private final int TIME_PLAY_EACH_LEVEL = 1000;
    // define background color of playing screen
    private String[] arrColor = {"#FA8072","#DC143C", "#B22222", "#FF4500", "#FF8C00", "#328B22", "#32CD32","#008000", "#9ACD32","#8FBCC8E"};

    // view on screen
    private TextView lblFomular, lblResult, lblScore;
    private ImageView btnCorrect, btnWrong;
    private RelativeLayout layoutPlay;

    //timer
    private Timer timer;
    private TimerTask timerTask;

    //player score
    private int score = 0;

    //level model
    private LevelModel model;
    private Random rand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_play);

        //find views
        lblFomular = (TextView) findViewById(R.id.lbl_formular);
        lblResult = (TextView) findViewById(R.id.lbl_score);
        layoutPlay = (RelativeLayout) findViewById(R.id.layout_play);
        lblScore = (TextView) findViewById(R.id.lbl_score);

        btnCorrect = (ImageView) findViewById(R.id.btn_correct);
        btnWrong = (ImageView) findViewById(R.id.btn_wrong);

        //handle click event on buttons
        btnCorrect.setOnClickListener(this);
        btnWrong.setOnClickListener(this);

        //create random
        rand = new Random();

        // generate the first level
        model = GenerateLevel.generateLevel(1);


        //show level info on screen
        displayNewLevel(model);

        //create timer, timertask
        createTimerTask();

    }

    //display info of level
    private void displayNewLevel(LevelModel model){
        lblFomular.setText(model.strOperator);
        lblResult.setText(model.strResult);

        //set random background color
        int indexColor = rand.nextInt(arrColor.length);
        layoutPlay.setBackground(Color.parseColor(arrColor[indexColor]));
    }

    //set calculate time for playing

    private void createTimerTask(){
        //create time
        timer = new Timer();

        //create time task
        timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //show gameover screen
                        showGameover(score);
                    }
                });
            }
        };
        //set time to run timertask
        timer.schedule(timerTask,TIME_PLAY_EACH_LEVEL);
    }



    @Override
    public void onClick(View v) {
        int id = v.getId();
        //player select correct button
        if(id==R.id.btn_correct)
        {
            if(model.correctWrong==true){
                score +=1;
                //next level
                nextLevel(score);
            }
            else
            {
                //show game over
                showGameover(score);
            }
        }
        if(id==R.id.btn_wrong)
        {
            if(model.correctWrong==false){
                score+=1;
                nextLevel(score);

            }
            else
            {
                showGameover(score);
            }
        }
    }
    private void nextLevel(int score)
    {
        // update score
        lblScore.setText(String.valueOf(score));

    }
    private void showGameover(final int score)
    {
        //disable button
        btnCorrect.setEnabled(false);
        btnWrong.setEnabled(false);

        //cancel timer
        cancelTimer();

        //show gameover UI
        new AlertDialog.Builder(this)
                .setTitle("GAME OVER")
                .setMessage("YOUR SCORE: "+score)
                .setPositiveButton(R.string.replay, (dialog, which) ->{
                    dialog.dismiss();
                    //enable buttons
                    btnCorrect.setEnabled(true);
                    btnWrong.setEnabled(true);

                    //play again
                    lblScore.setText("0");
                    PlayActivity.this.score = 0;
                    PlayActivity.this.nextLevel(score);
                } )
                .setNegativeButton(R.string.home, (dialog, which)-> {
                    dialog.dismiss();
                    //Back to home activity
                    PlayActivity.this.finish();
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
    private void cancelTimer(){
        timer.cancel();
        timerTask.cancel();
    }
}
