package com.example.ba_hung.hocfirebaseauth.ui.fragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ba_hung.hocfirebaseauth.R;
import com.example.ba_hung.hocfirebaseauth.ui.activity.MainActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentProfile extends Fragment implements View.OnClickListener {
    private FirebaseAuth mAuth;
    private View view;
    ImageView imgAvatar;
    TextView txtEmail, txtName;
    Button btnDangXuat;



    public FragmentProfile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((MainActivity)getActivity()).xacDinhKetNoiMangHayChua();
        xuLyLoading();
        AnhXa();

        hamXuLyKhiDangCoDangNhap();
        btnDangXuat.setOnClickListener(this);
    }

    private void hamXuLyKhiDangCoDangNhap() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user!=null){
            txtName.setText(user.getDisplayName());
            txtEmail.setText(user.getEmail());
            if(user.getPhotoUrl()!=null)
                Picasso.with(getActivity()).load(user.getPhotoUrl()).into(imgAvatar);
        }
        else{
            return;
        }
    }

    private void xuLyLoading() {
        final ProgressDialog progress = new ProgressDialog(getActivity(), R.style.AppCompatAlertDialogStyle);
        progress.setTitle("Processing");
        progress.setMessage("Please wait...");
        progress.show();

        Runnable progressRunnable = new Runnable() {

            @Override
            public void run() {
                progress.cancel();
            }
        };

        Handler pdCanceller = new Handler();
        pdCanceller.postDelayed(progressRunnable, 1500);
    }

    private void AnhXa() {
        txtName = (TextView) view.findViewById(R.id.txtName);
        imgAvatar = (ImageView) view.findViewById(R.id.imgAvatar);
        btnDangXuat = (Button) view.findViewById(R.id.btnDangXuatProfile);
        txtEmail = (TextView) view.findViewById(R.id.txtEmail);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnDangXuatProfile) {
            FirebaseAuth.getInstance().signOut();
        }
        ((MainActivity) getActivity()).themFragment( R.id.myLayout, new FragmentLogin());
    }

}
