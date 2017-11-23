package com.example.ba_hung.customlistview.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ba_hung.customlistview.R;

import java.util.List;

/**
 * Created by ba-hung on 02/08/2017.
 */

public class ListAdapter extends ArrayAdapter<String> {
    private Context context;
    private int resource;
    private List<String> objects;
    public ListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
        this.objects = objects;
        this.resource = resource;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v= convertView;
        LayoutInflater inflater = LayoutInflater.from(this.context);
        v = inflater.inflate(R.layout.custom_listview, null);

        TextView txt = (TextView) v.findViewById(R.id.txt);
        txt.setText(objects.get(position));
        return v;
    }
}
