package com.example.ba_hung.custom_listview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ba_hung.custom_listview.R;
import com.example.ba_hung.custom_listview.model.MusicModel;

import java.util.ArrayList;

/**
 * Created by ba-hung on 02/08/2017.
 **/

public class MusicAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<MusicModel> datas;

    public MusicAdapter(Context context, ArrayList<MusicModel> datas) {
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
        //Khi tao ra 1 giao diện bên ngoài
        //Phải chứa trong một đối tượng có kiểu là view
        // Muốn đưa được giao diện vào trong view cần có LayoutInflater
        LayoutInflater inflater = LayoutInflater.from(this.context);
        convertView = inflater.inflate(R.layout.custom_listview,parent, false);
        TextView txtName = (TextView) convertView.findViewById(R.id.txtName);
        TextView txtAuthor = (TextView) convertView.findViewById(R.id.txtAuthor);

        txtName.setText(datas.get(position).getName());
        txtAuthor.setText(datas.get(position).getAuthor());

        return convertView;
    }
}
