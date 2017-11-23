package com.example.ba_hung.tuhoc_volley.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.ba_hung.tuhoc_volley.R;
import com.example.ba_hung.tuhoc_volley.model.SanPhamModel;
import com.example.ba_hung.tuhoc_volley.ui.adapter.SanPhamAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.example.ba_hung.tuhoc_volley.R.id.gvSanPham;

public class MainActivity extends AppCompatActivity {
    private GridView gv;
    private ArrayList<SanPhamModel> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gv = (GridView) findViewById(gvSanPham);
        datas = new ArrayList<>();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, "http://ntdat.esy.es/getJsonSanPham.php", null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject object = response.getJSONObject(i);
                        SanPhamModel sanpham = new SanPhamModel(
                                object.getInt("id_sanpham"),
                                object.getString("ten_sanpham"),
                                object.getInt("id_danhmuc"),
                                object.getInt("gia_sanpham"),
                                object.getString("mota_sanpham"),
                                object.getInt("sanpham_noibat"),
                                object.getString("anh_sanpham")
                        );
                        datas.add(sanpham);

                        SanPhamAdapter adapter = new SanPhamAdapter(MainActivity.this, datas);
                        gv.setAdapter(adapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        queue.add(jsonArrayRequest);
    }
}
