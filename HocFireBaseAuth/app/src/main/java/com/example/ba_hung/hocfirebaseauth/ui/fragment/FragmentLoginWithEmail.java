package com.example.ba_hung.hocfirebaseauth.ui.fragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentLoginWithEmail extends Fragment implements View.OnClickListener {
    private View view;
    TextView txtSignUp, txtForgot;
    EditText edtEmailLogin, edtPassWord;
    Button btnLogin, btnDangXuat;
    private FirebaseAuth mAuth;
    String email, pass;

    public FragmentLoginWithEmail() {
        // Required empty public constructor
    }
    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            btnDangXuat.setVisibility(View.VISIBLE);
            AnGiaoDien();
        }
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_login_with_email, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((MainActivity)getActivity()).xacDinhKetNoiMangHayChua();
        mAuth = FirebaseAuth.getInstance();
        xuLyLoading();
        AnhXa();
        btnDangXuat.setVisibility(View.INVISIBLE);
        btnLogin.setOnClickListener(this);
        txtSignUp.setOnClickListener(this);
        txtForgot.setOnClickListener(this);
        btnDangXuat.setOnClickListener(this);


    }
    private void AnhXa() {
        btnDangXuat = (Button) view.findViewById(R.id.btnDangXuat);
        edtEmailLogin = (EditText) view.findViewById(R.id.edtEmailLogin);
        edtPassWord = (EditText) view.findViewById(R.id.edtPassLogin);
        btnLogin = (Button) view.findViewById(R.id.btnLogin);
        txtSignUp = (TextView) view.findViewById(R.id.txtSignUp);
        txtForgot = (TextView) view.findViewById(R.id.txtForgot);
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

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnLogin) {
            email = edtEmailLogin.getText().toString();
            pass = edtPassWord.getText().toString();
            if (!pass.equals("") && !email.equals("")) {
                if (validate(email)) {
                    mAuth.signInWithEmailAndPassword(email, pass)
                            .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        if(user.isEmailVerified()){
                                            toastLogIn(R.layout.toast_success_login);

                                            ((MainActivity) getActivity()).themFragment( R.id.myLayout, new FragmentProfile());
                                        } else{
                                            FirebaseAuth.getInstance().signOut();
                                            Toast.makeText(getActivity(), "Bạn chưa xác nhận đăng kí qua gmail", Toast.LENGTH_SHORT).show();
                                        }

                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText(getActivity(), "Email hoặc mật khẩu không đúng", Toast.LENGTH_SHORT).show();
                                        toastLogIn(R.layout.toast_login_failure);
                                    }
                                }
                            });
                } else {
                    Toast.makeText(getActivity(), "Email bạn nhập không đúng!", Toast.LENGTH_SHORT).show();
                }
            } else if (email.equals("")) {
                if(pass.equals("")){
                    Toast.makeText(getActivity(), "Bạn quên nhập email và password", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "Bạn quên nhập email", Toast.LENGTH_SHORT).show();
                }
            } else if (pass.equals("") && !email.equals("")) {
                Toast.makeText(getActivity(), "Bạn quên nhập mật khẩu", Toast.LENGTH_SHORT).show();
            }

        } else if (v.getId() == R.id.txtSignUp) {
            ((MainActivity) getActivity()).themFragment( R.id.myLayout, new FragmentRegister());
        } else if (v.getId() == R.id.txtForgot) {
            ((MainActivity) getActivity()).themFragment(R.id.myLayout, new FragmentForgotPass());
        } else if(v.getId()==R.id.btnDangXuat){
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            if(user!=null){
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(getActivity(), "Logout thành công", Toast.LENGTH_SHORT).show();
                hienGiaoDien();
                btnDangXuat.setVisibility(View.INVISIBLE);
            }
        }
    }
    private void AnGiaoDien() {
        edtEmailLogin.setVisibility(View.INVISIBLE);
        edtPassWord.setVisibility(View.INVISIBLE);
        txtSignUp.setVisibility(View.INVISIBLE);
        txtForgot.setVisibility(View.INVISIBLE);
        btnLogin.setVisibility(View.INVISIBLE);
    }
    private void hienGiaoDien() {
        edtEmailLogin.setVisibility(View.VISIBLE);
        edtPassWord.setVisibility(View.VISIBLE);
        txtSignUp.setVisibility(View.VISIBLE);
        txtForgot.setVisibility(View.VISIBLE);
        btnLogin.setVisibility(View.VISIBLE);
    }

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    private void toastLogIn(int a) {
        Toast toast = new Toast(getActivity());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 0);
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View v = inflater.inflate(a, null);
        toast.setView(v);
        toast.show();

    }
}
