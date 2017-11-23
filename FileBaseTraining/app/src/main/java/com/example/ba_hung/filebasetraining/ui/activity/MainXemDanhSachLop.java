package com.example.ba_hung.filebasetraining.ui.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ba_hung.filebasetraining.R;
import com.example.ba_hung.filebasetraining.model.LopModel;
import com.example.ba_hung.filebasetraining.ui.adapter.LopAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainXemDanhSachLop extends AppCompatActivity {
    private ListView lv;
    private ArrayList<LopModel> datas;
    private DatabaseReference mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_xem_danh_sach_lop);

        lv = (ListView) findViewById(R.id.lvTenLop);
        mData = FirebaseDatabase.getInstance().getReference();

        datas = new ArrayList<>();

        final LopAdapter adapter = new LopAdapter(MainXemDanhSachLop.this, datas);
        lv.setAdapter(adapter);


        mData.child("lop").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                LopModel lopModel = new LopModel(dataSnapshot.child("maLop").getValue().toString(), dataSnapshot.child("tenLop").getValue().toString(),dataSnapshot.getKey());
                datas.add(lopModel);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, final View view, final int position, long id) {
                final TextView txtMaLop, txtTenLop;

                txtMaLop = (TextView) view.findViewById(R.id.txtMaLop);
                txtTenLop = (TextView) view.findViewById(R.id.txtTenLop);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainXemDanhSachLop.this);
                builder.setMessage("Bạn có muốn xóa [ " + txtMaLop.getText().toString() + " - "+ txtTenLop.getText().toString()+" ] không?" );
                builder.setTitle("Xóa");
                builder.setNegativeButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mData.child("lop").child(datas.get(position).getKey()).removeValue();
                        datas.remove(position);
                        Toast.makeText(MainXemDanhSachLop.this, "Đã Xóa", Toast.LENGTH_SHORT).show();
                        adapter.notifyDataSetChanged();

                    }
                });
                builder.setPositiveButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        adapter.notifyDataSetChanged();
                    }
                });
                builder.create().show();
                return false;
            }
        });


    }
}

