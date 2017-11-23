package com.example.ba_hung.volleyandroidother.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.GridView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.ba_hung.volleyandroidother.R;
import com.example.ba_hung.volleyandroidother.model.SanPhamModel;
import com.example.ba_hung.volleyandroidother.ui.adapter.SanPhamAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<SanPhamModel> dulieu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final GridView gvSanPham = (GridView) findViewById(R.id.gv);

        dulieu = new ArrayList<>();

//        Bước 1: Tạo ra yêu cầu
        JsonArrayRequest yeuCau = new JsonArrayRequest(Request.Method.GET, "http://ntdat.esy.es/getJsonSanPham.php", null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<response.length();i++){
                    try {
                        JSONObject object = response.getJSONObject(i);
                        SanPhamModel sanPham = new SanPhamModel(
                                object.getInt("id_sanpham"),
                                object.getString("ten_sanpham"),
                                object.getInt("id_danhmuc"),
                                object.getInt("gia_sanpham"),
                                object.getString("mota_sanpham"),
                                object.getInt("sanpham_noibat"),
                                object.getString("anh_sanpham")
                        );
                        dulieu.add(sanPham);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                SanPhamAdapter adapter = new SanPhamAdapter(MainActivity.this, dulieu);
                gvSanPham.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error","Can't load data from server");
            }
        });

        //Bước 2: Thực thi yêu cầu
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        queue.add(yeuCau);
    }
}
