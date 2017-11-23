package com.example.ba_hung.demolistview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by ba-hung on 28/06/2017.
 */

public class ContactAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<ContactModel> arrContact;
    public ContactAdapter(Context context, ArrayList<ContactModel> arr)
    {
        this.context = context;
        this.arrContact = arr;
    }

    @Override
    public int getCount() {
        if(arrContact != null)
            return arrContact.size();
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return arrContact.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View rowView = inflater.inflate(R.layout.item_layout, parent, false);

        ImageView img = (ImageView) rowView.findViewById(R.id.imageView);
        TextView lblName = (TextView) rowView.findViewById(R.id.lbl_name);
        TextView lblPhone = (TextView) rowView.findViewById(R.id.lbl_phone);

        ContactModel model = arrContact.get(position);
        img.setImageResource(model.getImage());
        lblName.setText(model.getName());
        lblPhone.setText(model.getPhone());

        return rowView;
    }
}
