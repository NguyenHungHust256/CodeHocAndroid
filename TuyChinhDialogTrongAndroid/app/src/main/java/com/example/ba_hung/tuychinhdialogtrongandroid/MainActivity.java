package com.example.ba_hung.tuychinhdialogtrongandroid;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void hienthiAlertDialog(View view) {
        if (view.getId() == R.id.btn1) {
            // Hien tho dialog dang binh thuong
            //Buowc 1: Tao ra 1 doi tuong co kieu la AlertDialog.Builter
            // Tu doi tuong nay co the thiet lap tieu de, noi dung, 2 nut button cho hop thoai
            AlertDialog.Builder hopThoai = new AlertDialog.Builder(MainActivity.this);
            hopThoai.setTitle("Chúc Mừng");
            hopThoai.setMessage("Bạn đã trúng Vietlot");
            hopThoai.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // Nếu ấn vào nút Yes thì code trong hàm này sẽ đc thực thi
                    Toast.makeText(MainActivity.this, "Bạn đã bị lừa", Toast.LENGTH_SHORT).show();
                }
            });
            hopThoai.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "Bạn rất tỉnh", Toast.LENGTH_SHORT).show();
                }
            });
            hopThoai.setIcon(R.drawable.ok);
            hopThoai.create().show();
        } else if (view.getId() == R.id.btn2) {
            //Hien thi dialog dang danh sach
            //Bước 1: Tạo ra AlertDialog.Builder
            AlertDialog.Builder hopThoaiList = new AlertDialog.Builder(MainActivity.this);
            // Bước 2: Tạo dữ liệu hiển thị trên Alert Dialog
            //Dung mang thuong de chua du liey
            final String[] khoaHoc = new String[]{
                    "Android","IOS","PHP","REACT NATIVE","NODE JS"
            };
            //Buoc 3: Dua du lieu vao trong AlertDialog
            //Item
            hopThoaiList.setItems(khoaHoc, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // An vao dong nao hien toasst cua thang aays
                    // which dong vai tro nhu position trong listview
                    Toast.makeText(MainActivity.this, khoaHoc[which], Toast.LENGTH_SHORT).show();
                }
            });
            hopThoaiList.setTitle("Tên các khóa học");
            hopThoaiList.setIcon(R.drawable.ok);
            hopThoaiList.create().show();

        } else if (view.getId() == R.id.btn3) {
            //Hien thi dialog dang custom
            //Buoc 1 : Tu tao ra giao dien do chinh minh tu dinh nghia
            // Bước 2: Đưa giao diện vào trong một đối tượng view
            View v;
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            v = inflater.inflate(R.layout.giao_dien_hop_thoai, null);

            //Buoc 3: Tao ra 1 doi tuong co kieu dialog
            Dialog hopThoaiCustom = new Dialog(MainActivity.this, R.style.theme_dialog);

            //Xoa tieu de cua Dialog
            hopThoaiCustom.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
            //Buoc 4: Dua giao dien vao Dialog
            hopThoaiCustom.setContentView(v);


            // buoc 5: Hien thi hop thoai len man hinh
            hopThoaiCustom.show();

        }
    }
}
