package com.example.ba_hung.listviewanimation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ba_hung.listviewanimation.R;
import com.example.ba_hung.listviewanimation.model.QuocGiaModel;

import java.util.ArrayList;

/**
 * Created by ba-hung on 07/08/2017.
 */

public class QuocGiaAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<QuocGiaModel> datas;

    public QuocGiaAdapter(Context context, ArrayList<QuocGiaModel> datas) {
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
        Animation scale;
        ViewHolder holder ;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(this.context);
            convertView = inflater.inflate(R.layout.quocgia_listview, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.txtTenQuocGia.setText(datas.get(position).getTenQuocGia());
        scale = AnimationUtils.loadAnimation(context,R.anim.scale);
        holder.txtTenQuocGia.startAnimation(scale);
        return convertView;
    }
}

class ViewHolder {
        public TextView txtTenQuocGia;

        public ViewHolder(View view) {
            txtTenQuocGia = (TextView) view.findViewById(R.id.txtQuocGia);
        }
    }

