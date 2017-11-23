package com.example.ba_hung.custom_toast.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ba_hung.custom_toast.R;
import com.example.ba_hung.custom_toast.model.MusicModel;

import java.util.ArrayList;

/**
 * Created by ba-hung on 03/08/2017.
 */

public class MusicAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<MusicModel> music;

    public MusicAdapter(Context context, ArrayList<MusicModel> music) {
        this.context = context;
        this.music = music;
    }

    @Override
    public int getCount() {
        return music.size();
    }

    @Override
    public Object getItem(int position) {
        return music.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        convertView = inflater.inflate(R.layout.customlistview,parent,false);
        TextView baiHat = (TextView) convertView.findViewById(R.id.txtBaiHat);
        TextView caSy = (TextView) convertView.findViewById(R.id.txtCaSy);

        baiHat.setText(music.get(position).getTenBaiHat());
        caSy.setText(music.get(position).getTenCaSy());
        return convertView;
    }
}
