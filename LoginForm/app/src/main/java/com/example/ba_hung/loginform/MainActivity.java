package com.example.ba_hung.loginform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txtUserName,txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUserName = (EditText) findViewById(R.id.txtUserName);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
    }

    public void doSomeThing(View view) {
        String username = txtUserName.getText().toString();

        String password = txtPassword.getText().toString();
        if(username.equals("admin@gmail.com") && password.equals("12345678")){
            Toast.makeText(this, "Login successed", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Login didn't success", Toast.LENGTH_SHORT).show();
            txtUserName.setText("");
            txtPassword.setText("");
        }
    }
}
