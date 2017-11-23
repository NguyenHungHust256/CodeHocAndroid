package com.example.ba_hung.hocdatabase_sqlite.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.ba_hung.hocdatabase_sqlite.R;
import com.example.ba_hung.hocdatabase_sqlite.model.SinhVienModel;

import java.util.ArrayList;

/**
 * Created by ba-hung on 21/08/2017.
 **/

public class SinhVienAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<SinhVienModel> datas;

    public SinhVienAdapter(Context context, ArrayList<SinhVienModel> datas) {
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
        ViewHolder holder = null;
        LayoutInflater inflater = LayoutInflater.from(this.context);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.giao_dien_sinh_vien, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.txtTen.setText(datas.get(position).getTen().toString());
        holder.txtTuoi.setText(datas.get(position).getTuoi()+"");
        return convertView;
    }
}

class ViewHolder {
    TextView txtTen, txtTuoi;
    ImageButton imgBtnXoa, imgBtnSua;

    public ViewHolder(View v) {
        txtTen = (TextView) v.findViewById(R.id.txtTen);
        txtTuoi = (TextView) v.findViewById(R.id.txtTuoi);
        imgBtnXoa = (ImageButton) v.findViewById(R.id.imgCacel);
        imgBtnSua = (ImageButton) v.findViewById(R.id.imgEdit);

    }
}
