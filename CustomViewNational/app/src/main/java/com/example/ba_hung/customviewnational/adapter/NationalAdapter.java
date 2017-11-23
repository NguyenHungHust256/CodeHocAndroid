package com.example.ba_hung.customviewnational.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ba_hung.customviewnational.R;
import com.example.ba_hung.customviewnational.model.NationalModel;

import java.util.ArrayList;

/**
 * Created by ba-hung on 14/08/2017.
 */

public class NationalAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<NationalModel> datas;

    public NationalAdapter(Context context, ArrayList<NationalModel> datas) {
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

        TextView txtQG;
        TextView txtDN;
        ImageView img;
        ViewHolder holder ;

        LayoutInflater inflater = LayoutInflater.from(this.context);

        if(convertView == null){
            convertView = inflater.inflate(R.layout.listview_nation,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtTen.setText(datas.get(position).getName());
        holder.txtDN.setText(datas.get(position).getdNghia());
        holder.img.setImageResource(datas.get(position).getImage());

        return convertView;
    }
}
class ViewHolder {
    TextView txtTen;
    TextView txtDN;
    ImageView img;

    public ViewHolder(View v) {
        txtTen = (TextView) v.findViewById(R.id.txtQG);
        txtDN = (TextView) v.findViewById(R.id.txtDN);
        img = (ImageView) v.findViewById(R.id.img);
    }
}