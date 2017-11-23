package com.example.ba_hung.filebasetraining.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ba_hung.filebasetraining.R;
import com.example.ba_hung.filebasetraining.model.SinhVienModel;

import java.util.ArrayList;

/**
 * Created by ba-hung on 24/08/2017.
 */

public class SinhVienAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<SinhVienModel> dataOfSV;


    public SinhVienAdapter(Context context, ArrayList<SinhVienModel> dataOfSV) {
        this.context = context;
        this.dataOfSV = dataOfSV;
    }

    @Override
    public int getCount() {
        return dataOfSV.size();
    }

    @Override
    public Object getItem(int position) {
        return dataOfSV.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView txtStt, txtTenSV, txtNgaySinh;
        LayoutInflater inflater = LayoutInflater.from(this.context);
        convertView = inflater.inflate(R.layout.giao_dien_item_sinh_vien,parent,false);

        txtStt = (TextView) convertView.findViewById(R.id.txtSTTSV);
        txtTenSV = (TextView) convertView.findViewById(R.id.txtTenSV);
        txtNgaySinh = (TextView) convertView.findViewById(R.id.txtNgaySinh);

        txtStt.setText(position+1+"");
        txtTenSV.setText(dataOfSV.get(position).getTenSV());
        txtNgaySinh.setText(dataOfSV.get(position).getNgaySinh());

        return convertView;
    }
}
