package com.example.ba_hung.hocfirebaseauth.ui.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
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
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentLoginWithPhoneNumber extends Fragment implements View.OnClickListener {
    private View view;
    private EditText etxtPhone;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private Button btnSendMeAnSMS, btnSignIn, btnLogOut;
    private EditText etxtPhoneCode;
    private String mVerificationId;
    private TextView txtNhap, txtSDT;
    public FragmentLoginWithPhoneNumber() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            AnGiaoDien();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_login_with_phone_number, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((MainActivity)getActivity()).xacDinhKetNoiMangHayChua();
        AnhXa();
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null) {
                    Toast.makeText(getActivity(), "Chưa Logout", Toast.LENGTH_SHORT).show();
                }
            }
        };
        btnLogOut.setVisibility(View.INVISIBLE);
        btnSendMeAnSMS.setOnClickListener(this);
        btnSignIn.setOnClickListener(this);
        btnLogOut.setOnClickListener(this);


    }

    private void AnhXa() {
        txtSDT = (TextView) view.findViewById(R.id.txtSDT);
        txtNhap = (TextView) view.findViewById(R.id.txtNhap);
        btnLogOut = (Button) view.findViewById(R.id.btnLogOutPhone);
        btnSignIn = (Button) view.findViewById(R.id.btnSignInPhone);
        btnSendMeAnSMS = (Button) view.findViewById(R.id.btnSendMeAnSMS);
        etxtPhone = (EditText) view.findViewById(R.id.etxtPhone);
        etxtPhoneCode = (EditText) view.findViewById(R.id.etxtPhoneCode);
        etxtPhone.setText("+84");

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSendMeAnSMS) {
            String phoneNumber = etxtPhone.getText().toString();
            if (TextUtils.isEmpty(phoneNumber)){
                Toast.makeText(getActivity(), "Mời bạn nhập số điện thoại.", Toast.LENGTH_SHORT).show();
                return;
            }
            if(validate(phoneNumber)){
                etxtPhone.setEnabled(false);
                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        phoneNumber, 60, TimeUnit.SECONDS, getActivity(), new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                                //Called if it is not needed to enter verification code
                                Log.d(TAG, "onVerificationCompleted:" + phoneAuthCredential);
                                signInWithCredential(phoneAuthCredential);
                            }

                            @Override
                            public void onVerificationFailed(FirebaseException e) {
                                //incorrect phone number, verification code, emulator, etc.
                                Toast.makeText(getActivity(), "Xác nhận thất bại: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCodeSent(String verificationId, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                //now the code has been sent, save the verificationId we may need it
                                super.onCodeSent(verificationId, forceResendingToken);
                                Toast.makeText(getActivity(), "Đã gửi tin nhắn", Toast.LENGTH_SHORT).show();
                                mVerificationId = verificationId;
                            }

                            @Override
                            public void onCodeAutoRetrievalTimeOut(String verificationId) {
                                //called after timeout if onVerificationCompleted has not been called
                                super.onCodeAutoRetrievalTimeOut(verificationId);
                                etxtPhone.setEnabled(true);
                            }
                        }
                );
            } else {
                Toast.makeText(getActivity(), "Bạn nhập số điện thoại không đúng", Toast.LENGTH_SHORT).show();
            }
        } else if(v.getId() == R.id.btnSignInPhone){
            if(validate(etxtPhone.getText().toString()))
                signIn();
            else{
                Toast.makeText(getActivity(), "Mời bạn nhập số điện thoại chính xác", Toast.LENGTH_SHORT).show();
            }
        } else if(v.getId() == R.id.btnLogOutPhone){
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            if(user!=null){
                FirebaseAuth.getInstance().signOut();
                etxtPhone.setText("+84");
                etxtPhoneCode.setText("");
                Toast.makeText(getActivity(), "Logout thành công", Toast.LENGTH_SHORT).show();
                hienGiaoDien();
                etxtPhone.setEnabled(true);
            }
        }
    }

    public void signIn() {
        String code = etxtPhoneCode.getText().toString();
        if (TextUtils.isEmpty(code)){
            Toast.makeText(getActivity(), "Mời bạn nhập mã xác nhận", Toast.LENGTH_SHORT).show();
        }
        else{
            signInWithCredential(PhoneAuthProvider.getCredential(mVerificationId, code));
        }


    }

    private void signInWithCredential(PhoneAuthCredential phoneAuthCredential) {
        mAuth.signInWithCredential(phoneAuthCredential)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getActivity(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                            AnGiaoDien();
                        } else {
                            Toast.makeText(getActivity(),"Đăng nhập thất bại" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public static final Pattern VALID_PHONE_REGEX =
            Pattern.compile("(\\+84)\\d{9,10}", Pattern.CASE_INSENSITIVE);


    public static boolean validate(String phoneNumberStr) {
        Matcher matcher = VALID_PHONE_REGEX.matcher(phoneNumberStr);
        return matcher.find();
    }

    public void AnGiaoDien(){
        txtSDT.setVisibility(View.INVISIBLE);
        btnLogOut.setVisibility(View.VISIBLE);
        btnSendMeAnSMS.setVisibility(View.INVISIBLE);
        etxtPhone.setVisibility(View.INVISIBLE);
        txtNhap.setVisibility(View.INVISIBLE);
        etxtPhoneCode.setVisibility(View.INVISIBLE);
        btnSignIn.setVisibility(View.INVISIBLE);

    }

    public void hienGiaoDien(){
        txtSDT.setVisibility(View.VISIBLE);
        btnLogOut.setVisibility(View.INVISIBLE);
        btnSendMeAnSMS.setVisibility(View.VISIBLE);
        etxtPhone.setVisibility(View.VISIBLE);
        txtNhap.setVisibility(View.VISIBLE);
        etxtPhoneCode.setVisibility(View.VISIBLE);
        btnSignIn.setVisibility(View.VISIBLE);
    }

}
