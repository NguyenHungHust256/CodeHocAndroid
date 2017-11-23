package com.example.ba_hung.hocfirebaseauth.ui.fragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ba_hung.hocfirebaseauth.R;
import com.example.ba_hung.hocfirebaseauth.ui.activity.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentForgotPass extends Fragment implements View.OnClickListener {
    private View view;
    FirebaseAuth auth;
    EditText edtEmailXacNhan;
    Button btnSubmit;
    String emailXacNhan;

    public FragmentForgotPass() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_forgot_pass, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((MainActivity)getActivity()).xacDinhKetNoiMangHayChua();
        auth = FirebaseAuth.getInstance();
        xuLyLoading();
        AnhXa();
        btnSubmit.setOnClickListener(this);
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
        edtEmailXacNhan = (EditText) view.findViewById(R.id.edtXacNhanEmail);
        btnSubmit = (Button) view.findViewById(R.id.btnSubmit);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSubmit) {
            emailXacNhan = edtEmailXacNhan.getText().toString();
            if (!emailXacNhan.equals("")) {
                if (validate(emailXacNhan)) {
                    auth.sendPasswordResetEmail(emailXacNhan)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getActivity(), "Email được gửi thành công!", Toast.LENGTH_SHORT).show();
                                        edtEmailXacNhan.setText("");
                                    } else {
                                        Toast.makeText(getActivity(), "Lỗi! Không gửi được đến email bạn yêu cầu.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                } else {
                    Toast.makeText(getActivity(), "Email bạn nhập không đúng.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getActivity(), "Mời bạn nhập Email.", Toast.LENGTH_SHORT).show();
            }

        }
    }

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }
}
