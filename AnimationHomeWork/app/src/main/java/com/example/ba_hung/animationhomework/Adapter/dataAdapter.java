package com.example.ba_hung.animationhomework.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ba_hung.animationhomework.R;

import java.util.ArrayList;

import static com.example.ba_hung.animationhomework.R.id.txt;

/**
 * Created by ba-hung on 05/08/2017.
 */

public class dataAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<String> datas;

    public dataAdapter(Context context, ArrayList<String> datas) {
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
//        View rowView = convertView;
//        TextView txt;
//        Animation translate;
//        translate = AnimationUtils.loadAnimation(context, R.anim.translate);
//        if(rowView==null){
//            LayoutInflater inflater = LayoutInflater.from(context);
//            rowView = inflater.inflate(R.layout.listview,parent,false);
//        }
//
//        txt = (TextView) rowView.findViewById(R.id.txt);
//        txt.setText(datas.get(position));
//        txt.startAnimation(translate);
//        return rowView;
        ViewHolder viewHolder;
        Animation translate;
        translate = AnimationUtils.loadAnimation(context, R.anim.translate);
        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.listview,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.txt = (TextView) convertView.findViewById(txt);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
       viewHolder.txt.setText(datas.get(position));
        viewHolder.txt.startAnimation(translate);


        return convertView;
    }
}

class ViewHolder{
    TextView txt;
    public ViewHolder(){

    }
}
