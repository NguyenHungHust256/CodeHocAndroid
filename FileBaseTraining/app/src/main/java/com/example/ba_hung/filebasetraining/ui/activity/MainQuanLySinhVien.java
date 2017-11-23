package com.example.ba_hung.filebasetraining.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ba_hung.filebasetraining.R;
import com.example.ba_hung.filebasetraining.model.SinhVienModel;
import com.example.ba_hung.filebasetraining.ui.adapter.SinhVienAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainQuanLySinhVien extends AppCompatActivity {
    private ListView lvSV;
    private Spinner spnLop;
    private EditText edtNameSV, edtNgay;
    ArrayList<String> datas;
    DatabaseReference mData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_quan_ly_sinh_vien);

        spnLop = (Spinner) findViewById(R.id.spnLop);
        edtNameSV = (EditText) findViewById(R.id.edtTenSV);
        edtNgay = (EditText) findViewById(R.id.edtNgaySinh);
        lvSV = (ListView) findViewById(R.id.lvSinhVien);

        mData = FirebaseDatabase.getInstance().getReference();
        datas = new ArrayList<>();

        final ArrayAdapter adapter = new ArrayAdapter(MainQuanLySinhVien.this, android.R.layout.simple_spinner_item, datas);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spnLop.setAdapter(adapter);


//Doan code list view SinhVien khi an spinner
        spnLop.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                final ArrayList<SinhVienModel> dataOfSV = new ArrayList<>();

                final SinhVienAdapter svAdapter = new SinhVienAdapter(MainQuanLySinhVien.this, dataOfSV);
                lvSV.setAdapter(svAdapter);
                mData.child("lop").addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        String tenLop = spnLop.getSelectedItem().toString();
                        if(tenLop.equals(dataSnapshot.child("tenLop").getValue().toString())){
                            String key1Lop = dataSnapshot.getKey().toString();
                            mData.child("lop").child(key1Lop).child("dsSinhVien").addChildEventListener(new ChildEventListener() {
                                @Override
                                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                                    SinhVienModel sv1 = new SinhVienModel(dataSnapshot.child("tenSV").getValue().toString()
                                                                        , dataSnapshot.child("ngaySinh").getValue().toString());
                                    dataOfSV.add(sv1);
                                    svAdapter.notifyDataSetChanged();
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
                        }
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
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


            // Lay ten spinner
        mData.child("lop").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String tenLopHoc = dataSnapshot.child("tenLop").getValue().toString();
                datas.add(tenLopHoc);
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




    }


    public void ThemSinhVien(View view) {
        mData.child("lop").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String tenSV = edtNameSV.getText().toString();
                String ngaySinh = edtNgay.getText().toString();
                String tenLop = spnLop.getSelectedItem().toString();
                String keyLop;
                if(tenLop.equals(dataSnapshot.child("tenLop").getValue().toString())){
                    SinhVienModel sv = new SinhVienModel(tenSV, ngaySinh);
                    keyLop = dataSnapshot.getKey().toString();
                    String[] date = ngaySinh.split("[-]");

                    if( !tenSV.equals("") && !ngaySinh.equals("") && date.length ==3 ){
                        int ngay = Integer.parseInt(date[0]);
                        int thang = Integer.parseInt(date[1]);
                        int nam = Integer.parseInt(date[2]);
                        if(ngay<=31 && ngay>=1 && thang>=0 && thang<=12 && nam>=1980 && nam <= 2017)
                            mData.child("lop").child(keyLop).child("dsSinhVien").push().setValue(sv);
                        else{
                            Toast.makeText(MainQuanLySinhVien.this, "Mời bạn kiểm tra lại ngày sinh", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(MainQuanLySinhVien.this, "Bạn phải nhập tên và ngày sinh (dd/mm/yyyy)", Toast.LENGTH_SHORT).show();
                    }
                }
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
        // Doan code hien thi mau cho item

    }


}
