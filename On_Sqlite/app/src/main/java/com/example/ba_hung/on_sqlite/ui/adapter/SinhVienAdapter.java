package com.example.ba_hung.on_sqlite.ui.adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.ba_hung.on_sqlite.R;
import com.example.ba_hung.on_sqlite.data.QuanLySinhVienDao;
import com.example.ba_hung.on_sqlite.model.SinhVienModel;

import java.util.ArrayList;

/**
 * Created by ba-hung on 18/08/2017.
 */

public class SinhVienAdapter extends BaseAdapter {
    Context context;
    private ArrayList<SinhVienModel> datas;
    private QuanLySinhVienDao dao;

    public SinhVienAdapter(Context context, ArrayList<SinhVienModel> datas, QuanLySinhVienDao dao) {
        this.context = context;
        this.datas = datas;
        this.dao = dao;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        final LayoutInflater inflater = LayoutInflater.from(this.context);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.giao_dien_danh_sach_sinh_vien, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtTen.setText(datas.get(position).getTen());
        holder.txtTuoi.setText(datas.get(position).getTuoi() + "");
//        holder.imgCancel.setImageResource(R.drawable.cancel);
//        holder.imgEdit.setImageResource(R.drawable.edit);

        // Lắng nghe sự kiện khi ấn vòa 2 ảnh delete va edit
        holder.imgCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // đoạn code được thực hiện khi ảnh dekete được ấn
                dao.deleteSV(datas.get(position).getId());

//                Xoá ở trên listview cho người dùng
                datas.remove(position);
                notifyDataSetChanged();
            }
        });

        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                đoạn code được thực hiện khi ảnh edit được ấn
//                Hiển thị ra 1 custom alert dialog gồm 2 editext để người dùng nhập tên mới và tổi mới
//                Nếu như họ không nhập và nút ok ngay thì giữ nguyên giá trị cũ
                View vi;
                final EditText edtSuaTen, edtSuaTuoi;
                Button btnOk;
                LayoutInflater inflater1 = LayoutInflater.from(context);
                vi = inflater.inflate(R.layout.giao_dien_dialog, null);

                final Dialog dialog = new Dialog(context, R.style.theme_dialog);
                dialog.setTitle("Chỉnh Sửa Sinh Viên");
                dialog.setContentView(vi);


                btnOk = (Button) vi.findViewById(R.id.btnOk);
                edtSuaTen = (EditText) vi.findViewById(R.id.edtSuaTen);
                edtSuaTuoi = (EditText) vi.findViewById(R.id.edtSuaTuoi);

                edtSuaTen.setText(datas.get(position).getTen().toString());
                edtSuaTuoi.setText(datas.get(position).getTuoi()+"");
                dialog.show();

                btnOk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SinhVienModel sv = datas.get(position);

                        String tenSV = edtSuaTen.getText().toString();
                        int tuoiSV = Integer.parseInt(edtSuaTuoi.getText().toString());

                        sv.setTuoi(tuoiSV);
                        sv.setTen(tenSV);

                        dao.editSV(sv);
                        dialog.cancel();
                        notifyDataSetChanged();
                    }
                });


            }
        });


        return convertView;
    }
}

class ViewHolder {
    TextView txtTen, txtTuoi;
    ImageButton imgCancel, imgEdit;

    public ViewHolder(View v) {
        txtTen = (TextView) v.findViewById(R.id.txtTen);
        txtTuoi = (TextView) v.findViewById(R.id.txtTuoi);
        imgCancel = (ImageButton) v.findViewById(R.id.imgCacel);
        imgEdit = (ImageButton) v.findViewById(R.id.imgEdit);
    }
}
