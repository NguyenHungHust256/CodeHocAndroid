package com.example.ba_hung.filebasetraining.ui.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ba_hung.filebasetraining.R;
import com.example.ba_hung.filebasetraining.model.LopModel;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mData = FirebaseDatabase.getInstance().getReference();
    }

    public void doSomeThing(View view) {
        if(view.getId() == R.id.btnThemLop){
            final EditText edtMaLop, edtTenLop;
            Button btnXoaTrang, btnLuuLop;
            View v;
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            v = inflater.inflate(R.layout.giao_dien_dialog,null);

            edtMaLop = (EditText) v.findViewById(R.id.edtMaLop);
            edtTenLop = (EditText) v.findViewById(R.id.edtTenLop);
            btnXoaTrang = (Button) v.findViewById(R.id.btnXoaTrang);
            btnLuuLop = (Button) v.findViewById(R.id.btnLuuLop);


            Dialog dialog = new Dialog(MainActivity.this,R.style.theme_dialog);
            dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(v);
            dialog.show();

            btnXoaTrang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    edtMaLop.setText("");
                    edtTenLop.setText("");
                }
            });

            btnLuuLop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String maLop = edtMaLop.getText().toString();
                    String tenLop = edtTenLop.getText().toString();

                    LopModel lop = new LopModel(maLop, tenLop);
                    mData.child("lop").push().setValue(lop, new DatabaseReference.CompletionListener() {
                        @Override
                        public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                            Toast.makeText(MainActivity.this, "Completed!!!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            });


        }
        else if(view.getId() == R.id.btnXemDanhSachLop){
            Intent intent = new Intent(MainActivity.this, MainXemDanhSachLop.class);
            startActivity(intent);

        }
        else if(view.getId() == R.id.btnQuanLySinhVien){
            Intent intent = new Intent(MainActivity.this, MainQuanLySinhVien.class);
            startActivity(intent);

        }

    }


}
