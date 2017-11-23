package com.example.ba_hung.asynctaskandroid.ui.fragment;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ba_hung.asynctaskandroid.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
    private Button btnRun;
    private EditText edtSecond;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnRun = (Button) view.findViewById(R.id.btnRun);
        edtSecond = (EditText) view.findViewById(R.id.edtSecond);
        btnRun.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnRun){
            String soGiay = edtSecond.getText().toString();
            new MyThread().execute(soGiay);// soGiay nay se chuyen den tham so cua doInBackGround
        }
    }
    public class MyThread extends AsyncTask<String, String, String>{
//
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
//            thuong dung de tao progressBar
//            Ham nay se duoc thuc thi truoc khi tien trinh duoc goi
        }

        @Override
        protected String doInBackground(String... strings) {

//            dung de viet chuc nang. khong viet cap nhat giao dien
//            Day la noi xay ra cong viec chinh cua tien trinh
//            khong co kha nang cap nhat giao dien
//            string[0] = soGiay
//            nhan tham so tu execute
//            Xong ham nay no chuyen den ham onPostExecute, gia tri cua ham nay tra ve se chuyen den onPostExecute
// gia su soGiay =3
//            time = 3000 miligiay
//            result = "da ngu trong vong 3 giay"
            String result = null;
            int time = Integer.parseInt(strings[0]) * 1000; // don vi mili giay
            try {
                Thread.sleep(time);
                result = "Slept for " + strings[0] + " seconds";
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return result;
        }

        @Override
        protected void onProgressUpdate(String... values) {
//            Muon cap nhat giao dien thi viet lai vao day
            super.onProgressUpdate(values);

        }

        @Override
        protected void onPostExecute(String s) {
//            Sau khi tien trinh thuc hien xong se goi ham nay
            super.onPostExecute(s);
            Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
        }
    }
}
