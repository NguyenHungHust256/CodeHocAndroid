package com.example.ba_hung.customgridview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ba_hung.customgridview.Model.imageModel;
import com.example.ba_hung.customgridview.R;

import java.util.ArrayList;

/**
 * Created by ba-hung on 04/08/2017.
* */

public class imageAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<imageModel> datas;

    public imageAdapter(Context context, ArrayList<imageModel> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
         ImageView img;
         TextView txtImg;

        LayoutInflater hung = LayoutInflater.from(this.context);
        convertView = hung.inflate(R.layout.image_grid_view,parent,false);

        img = (ImageView) convertView.findViewById(R.id.img);
        txtImg =(TextView) convertView.findViewById(R.id.txtImg);


        img.setImageResource(datas.get(position).getImageId());

        txtImg.setText(datas.get(position).getName());
        return convertView;

    }
}
