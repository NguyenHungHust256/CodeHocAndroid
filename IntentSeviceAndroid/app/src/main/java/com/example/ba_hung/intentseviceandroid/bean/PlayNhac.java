package com.example.ba_hung.intentseviceandroid.bean;

import android.content.Context;
import android.media.MediaPlayer;

import com.example.ba_hung.intentseviceandroid.R;
public class PlayNhac {
    // exoplayer : cuar google để play nhạc
    private MediaPlayer player ; // đối tượng để play nhạc
    public PlayNhac (Context context){
        player = MediaPlayer.create(context, R.raw.chieuhomay);
    }
//    hàm dùng để play bài hát
    public void play(){
        player.start();
    }
//    Hàm dùng để dừng chơi nhạc
    public void stop(){
        if(player!=null){
            player.stop();
            player.release();
        }
    }
}
