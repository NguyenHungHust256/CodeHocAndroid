package com.example.ba_hung.girdviewcustom.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ba_hung.girdviewcustom.R;
import com.example.ba_hung.girdviewcustom.model.MusicModel;

import java.util.ArrayList;

/**
 * Created by ba-hung on 04/08/2017.
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
         TextView txtBaiHat;
         TextView txtCaSy;

        LayoutInflater inflater = LayoutInflater.from(this.context);
        convertView = inflater.inflate(R.layout.custom_grid_view,parent,false);
        txtBaiHat = (TextView) convertView.findViewById(R.id.txtBaiHat);
        txtCaSy = (TextView) convertView.findViewById(R.id.txtCaSy);
        txtBaiHat.setText(music.get(position).getTenBaiHat());
        txtCaSy.setText(music.get(position).getTenCaSy());
        return convertView;
    }
}
