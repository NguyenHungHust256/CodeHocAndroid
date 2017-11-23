package com.example.ba_hung.tuhoc_volley.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ba_hung.tuhoc_volley.R;
import com.example.ba_hung.tuhoc_volley.model.SanPhamModel;

import java.util.ArrayList;

/**
 * Created by ba-hung on 04/09/2017.
 **/

public class SanPhamAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<SanPhamModel> datas;

    public SanPhamAdapter(Context context, ArrayList<SanPhamModel> datas) {
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
        ImageView imgAnhSP;
        TextView txtTenSP, txtGiaSP;
        LayoutInflater inflater = LayoutInflater.from(this.context);
        convertView = inflater.inflate(R.layout.giao_dien_item_sanpham, parent, false);

        imgAnhSP = (ImageView) convertView.findViewById(R.id.imgAnhSP);
        txtTenSP = (TextView) convertView.findViewById(R.id.txtTenSP);
        txtGiaSP = (TextView) convertView.findViewById(R.id.txtGiaSP);

        Glide.with(context).load(datas.get(position).getAnh_sanpham()).into(imgAnhSP);
        txtTenSP.setText(datas.get(position).getTen_sanpham());
        txtGiaSP.setText(datas.get(position).getGia_sanpham() + "");
        return convertView;
    }
}
