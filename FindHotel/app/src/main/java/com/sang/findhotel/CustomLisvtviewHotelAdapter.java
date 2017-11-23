package com.sang.findhotel;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ADMIN on 23-Dec-15.
 */
public class CustomLisvtviewHotelAdapter extends BaseAdapter {
    private Activity content;
    private List<String> listhotelname;
    public CustomLisvtviewHotelAdapter(Activity content,List<String> listhotelname){
        this.content=content;
        this.listhotelname=listhotelname;
    }
    @Override
    public int getCount() {
        return listhotelname.size();
    }

    @Override
    public Object getItem(int position) {
        return /*listhotelname.get(position)*/ null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater =  content.getLayoutInflater();
        View v = layoutInflater.inflate(R.layout.custom_adapter_listview_hotel, null);
        ImageView imageView = (ImageView) v.findViewById(R.id.imageview_hotel);
        TextView tvNamhotel = (TextView) v.findViewById(R.id.textview_hotelname);
        tvNamhotel.setText(listhotelname.get(position));
        return v;
    }
}
