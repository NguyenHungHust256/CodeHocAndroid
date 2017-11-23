package com.example.ba_hung.hocfirebaseauth.ui.fragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.facebook.login.widget.ProfilePictureView.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentRegister extends Fragment implements View.OnClickListener {
    private View view;
    private FirebaseAuth mAuth;
    Button btnDangKi;
    EditText edtEmail, editPass, edtRepeatPass;
    String email, password, repeatPass;

    public FragmentRegister() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_register, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((MainActivity)getActivity()).xacDinhKetNoiMangHayChua();
        mAuth = FirebaseAuth.getInstance();
//        ProgressDialog progressDialog = ProgressDialog.show(getActivity(), "Please wait...", "Processing",true);
        xuLyLoading();
        AnhXa();
        btnDangKi.setOnClickListener(this);
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
        edtEmail = (EditText) view.findViewById(R.id.edtEmail);
        editPass = (EditText) view.findViewById(R.id.edtPassword);
        btnDangKi = (Button) view.findViewById(R.id.btnDangKi);
        edtRepeatPass = (EditText) view.findViewById(R.id.edtRepeatePass);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnDangKi) {
            email = edtEmail.getText().toString();
            password = editPass.getText().toString();
            repeatPass = edtRepeatPass.getText().toString();
            if (validate(email)) {
                if (email.equals("") && password.equals("")) {
                    Toast.makeText(getActivity(), "Mời bạn nhập Email với Mật khẩu.", Toast.LENGTH_SHORT).show();
                } else if (email.equals("")) {
                    Toast.makeText(getActivity(), "Mời bạn nhập Email.", Toast.LENGTH_SHORT).show();
                } else if (password.equals("")) {
                    Toast.makeText(getActivity(), "Mời bạn nhập Mật khẩu.", Toast.LENGTH_SHORT).show();
                } else if (repeatPass.equals("")) {
                    Toast.makeText(getActivity(), "Mời bạn nhập Repeat Password", Toast.LENGTH_SHORT).show();
                } else if (password.length() <= 8) {
                    Toast.makeText(getActivity(), "Mật khẩu ít nhất phải 8 kí tự.", Toast.LENGTH_SHORT).show();
                } else if (!repeatPass.equals(password)) {
                    Toast.makeText(getActivity(), "Password với Repeat Password không giống nhau.", Toast.LENGTH_SHORT).show();
                } else if (repeatPass.equals(password)) {
                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Log.d("User", "createUserWithEmail:success");
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        edtEmail.setText("");
                                        editPass.setText("");
                                        hamGuiEmailXacNhan();
                                        FirebaseAuth.getInstance().signOut();
                                        Toast.makeText(getActivity(), "Mời bạn xác nhận tài khoản qua Email và sau đó đăng nhập.", Toast.LENGTH_SHORT).show();
                                        ((MainActivity) getActivity()).themFragment(R.id.myLayout, new FragmentLogin());

                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Log.w("User", "createUserWithEmail:failure", task.getException());
                                        Toast.makeText(getActivity(), "Lỗi! Email của bạn đã được đăng kí hoặc bạn chưa kết nối mạng.", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });
                }
            } else {
                Toast.makeText(getActivity(), "Email bạn nhập không đúng", Toast.LENGTH_SHORT).show();
            }

        }
    }

    private void hamGuiEmailXacNhan() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        user.sendEmailVerification()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "Email sent.");
                        }
                    }
                });
    }

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }
}
