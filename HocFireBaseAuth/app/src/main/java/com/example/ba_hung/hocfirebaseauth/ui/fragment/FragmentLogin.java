package com.example.ba_hung.hocfirebaseauth.ui.fragment;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ba_hung.hocfirebaseauth.R;
import com.example.ba_hung.hocfirebaseauth.ui.activity.ActivityLoginFacebook;
import com.example.ba_hung.hocfirebaseauth.ui.activity.MainActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentLogin extends Fragment implements View.OnClickListener {
    private View view;
    Button btnLoginSdt, btnLoginEmail,btnLoginFacebook, btnLoginGoogle;
    private FirebaseAuth mAuth;

    public FragmentLogin() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_login, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((MainActivity)getActivity()).xacDinhKetNoiMangHayChua();
        mAuth = FirebaseAuth.getInstance();
        xuLyLoading();
        AnhXa();
        btnLoginSdt.setOnClickListener(this);
        btnLoginEmail.setOnClickListener(this);
        btnLoginGoogle.setOnClickListener(this);
        btnLoginFacebook.setOnClickListener(this);
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
        btnLoginSdt = (Button) view.findViewById(R.id.btnLoginWithNumberPhone);
        btnLoginEmail = (Button) view.findViewById(R.id.btnLoginWithEmail);
        btnLoginFacebook = (Button) view.findViewById(R.id.btnLoginFaceInSigIn);
        btnLoginGoogle = (Button) view.findViewById(R.id.btnLogInGoogleLogin);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnLoginWithNumberPhone){
            ((MainActivity) getActivity()).themFragment(R.id.myLayout, new FragmentLoginWithPhoneNumber());
        }
        else if(v.getId() == R.id.btnLoginWithEmail){
            ((MainActivity)getActivity()).themFragment( R.id.myLayout, new FragmentLoginWithEmail());
        }
        else if (v.getId() == R.id.btnLogInGoogleLogin) {
            ((MainActivity) getActivity()).themFragment( R.id.myLayout, new FragmentLoginGoogle());
        } else if (v.getId() == R.id.btnLoginFaceInSigIn) {
            Intent intent = new Intent(getActivity(), ActivityLoginFacebook.class);
            startActivity(intent);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
//        updateUI(currentUser);
    }



}
