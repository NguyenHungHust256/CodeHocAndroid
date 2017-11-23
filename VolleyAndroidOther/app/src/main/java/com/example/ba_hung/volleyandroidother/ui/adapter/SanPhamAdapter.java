package com.example.ba_hung.volleyandroidother.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ba_hung.volleyandroidother.R;
import com.example.ba_hung.volleyandroidother.model.SanPhamModel;

import java.util.ArrayList;

/**
 * Created by ba-hung on 30/08/2017.
 */

public class SanPhamAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<SanPhamModel> dataSanPham;

    public SanPhamAdapter(Context context, ArrayList<SanPhamModel> dataSanPham) {
        this.context = context;
        this.dataSanPham = dataSanPham;
    }

    @Override
    public int getCount() {
        return dataSanPham.size();
    }

    @Override
    public Object getItem(int position) {
        return dataSanPham.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.giao_dien_san_pham, parent, false);
        ImageView imgSanPham = (ImageView) convertView.findViewById(R.id.imageSanPham);
        TextView txtTenSanPham = (TextView) convertView.findViewById(R.id.txtTenSanPham);
        TextView txtGiaSanPham = (TextView) convertView.findViewById(R.id.txtGiaSanPham);
        Glide.with(context).load(dataSanPham.get(position).getAnh_sanpham()).into(imgSanPham);
        txtTenSanPham.setText(dataSanPham.get(position).getTen_sanpham());
        txtGiaSanPham.setText(dataSanPham.get(position).getGia_sanpham() + "");
        return convertView;
    }
}
