package com.example.ba_hung.fragment_quocgia.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ba_hung.fragment_quocgia.R;
import com.example.ba_hung.fragment_quocgia.model.QuocGiaModel;

import java.util.ArrayList;

/**
 * Created by ba-hung on 06/09/2017.
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
        TextView txtTenQG;
        LayoutInflater inflater = LayoutInflater.from(this.context);
        convertView = inflater.inflate(R.layout.giao_dien_quoc_gia,parent, false);
        txtTenQG = (TextView) convertView.findViewById(R.id.txtTenQG);
        txtTenQG.setText(datas.get(position).getTenQuocGia());
        return convertView;
    }
}
