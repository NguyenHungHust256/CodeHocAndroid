package com.example.ba_hung.filebasetraining.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ba_hung.filebasetraining.R;
import com.example.ba_hung.filebasetraining.model.LopModel;

import java.util.ArrayList;

/**
 * Created by ba-hung on 23/08/2017.
 */

public class LopAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<LopModel> datas;

    public LopAdapter(Context context, ArrayList<LopModel> datas) {
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
        TextView txtStt, txtMaLop, txtTenLop;
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.giao_dien_listview_lop_hoc,parent,false);

        txtStt = (TextView) convertView.findViewById(R.id.txtStt);
        txtMaLop = (TextView) convertView.findViewById(R.id.txtMaLop);
        txtTenLop = (TextView) convertView.findViewById(R.id.txtTenLop);

        txtStt.setText((position+1)+"");
        txtMaLop.setText(datas.get(position).getMaLop().toString());
        txtTenLop.setText(datas.get(position).getTenLop().toString());

        return convertView;
    }
}
