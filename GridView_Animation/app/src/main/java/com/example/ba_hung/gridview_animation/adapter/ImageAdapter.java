package com.example.ba_hung.gridview_animation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ba_hung.gridview_animation.R;
import com.example.ba_hung.gridview_animation.model.ImageModel;

import java.util.ArrayList;

/**
 * Created by ba-hung on 07/08/2017.
 */

public class ImageAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<ImageModel> datas;

    public ImageAdapter(Context context, ArrayList<ImageModel> datas) {
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

        ViewHolder holder ;

        Animation translate;

        translate = AnimationUtils.loadAnimation(context,R.anim.translate);

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.image_gridview, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtImg.setText(datas.get(position).getName());
        holder.img.setImageResource(datas.get(position).getImgID());

        convertView.startAnimation(translate);
        convertView.setAnimation(translate);
        return convertView;
    }
}

class ViewHolder {
    TextView txtImg;
    ImageView img;

    public ViewHolder(View v){
        this.txtImg = (TextView) v.findViewById(R.id.txtImg);
        this.img = (ImageView) v.findViewById(R.id.img);
    }

}