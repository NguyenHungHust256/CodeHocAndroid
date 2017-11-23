package com.example.ba_hung.implimentintend;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doSomeThing(View view) {
        if (view.getId() == R.id.btnCall) {
            //Day la noi viet chuvc nang goi dien thoai
            // Buoc1: Tao doi tuog intend
            Intent iCall = new Intent(Intent.ACTION_CALL);


            //Buoc 2: Thiet lap du lieu cho intend
            iCall.setData(Uri.parse("tel:0979390058"));

            // Se chi thuc thi cong viec nay khi va chi khi may nguoi dung co ung dung
            //co kha nang dap ung yeu cau nay
            if (iCall.resolveActivity(getPackageManager()) != null) {
                startActivity(iCall);
            }
        } else if (view.getId() == R.id.btnOpenWeb) {

            //Buoc 1 : Tao 1 Intend de mo mot chuc nang mo website
            //Buoc1: Tao 1 Itend de foi ra chuc nang mo website
            Intent iWeb = new Intent(Intent.ACTION_VIEW);

            //Buoc 2: Thiet lap du lieu cho intent
            iWeb.setData(Uri.parse("http://google.com"));
            //
            if (iWeb.resolveActivity(getPackageManager()) != null) {
                startActivity(iWeb);
            }

        }
        else if(view.getId()==R.id.btnSms){
            // Day la noi viet chuc nang gui tn nhan
            //Buoc1 +2: Tao intent de gui tin nhan, va setData
            Intent iSms = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:01695932469"));
            iSms.putExtra("sms_body","Hello Android");

            if(iSms.resolveActivity(getPackageManager())!=null){
                startActivity(iSms);
            }
        }
    }
}
