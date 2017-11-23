package com.example.ba_hung.logindangnhap25697.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ba_hung.logindangnhap25697.R;
import com.example.ba_hung.logindangnhap25697.ui.activity.MainActivity;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSignIn extends Fragment {

    private DatabaseReference mData;
    private View view;
    private EditText edtUserName, edtPassWord;
    private Button btnLogin;
    private TextView txtSignUp, txtForgot;
    private Button btnLoginFacebook, btnLoginGoogle;


    public FragmentSignIn() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sign_in, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        Tao FireBase Manager
        referenceFireBase();
//        Anh xa
        AnhXa();
//        Bat su kien khi an button
        setListenerBtnLogin();
//        bat su kien khi an vao sign up
        setListenerTxtSigUp();
// bat su kien khi an vao forgot pass
        setListenerTxtForgotPassw();
//        Bat su kien khi an vao login facebook
// Bat su kien khi an vao button Login with facebook
        setListenerBtnLoginFaceBook();
//bat su kien khi an vao button Login with google
        setListenerBtnLoginGoogle();
    }

    private void setListenerBtnLoginGoogle() {
        btnLoginGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).themFragment(R.id.myLayout, new FragmentLoginWithGoogle());
            }
        });
    }

    private void setListenerBtnLoginFaceBook() {
        btnLoginFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).themFragment(R.id.myLayout, new FragmentFacebook());
            }
        });
    }

    private void setListenerTxtForgotPassw() {
        txtForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).themFragment(R.id.myLayout, new FragmentForgotPassword());
            }
        });
    }

    private void setListenerTxtSigUp() {
        txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).themFragment(R.id.myLayout, new FragmentSignUp());
            }
        });
    }

    private void setListenerBtnLogin() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mData.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        String userName = edtUserName.getText().toString();
                        String pass = edtPassWord.getText().toString();


                        if (dataSnapshot.child("passWord").getValue().toString().equals(pass) &&
                                dataSnapshot.child("userName").getValue().toString().equals(userName)) {
                            Toast.makeText(getActivity(), "Login Success", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getActivity(), "Fail", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onChildRemoved(DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }

    private void AnhXa() {
        edtUserName = (EditText) view.findViewById(R.id.edtUserNameSignUp);
        edtPassWord = (EditText) view.findViewById(R.id.edtPassWordSignUp);
        btnLogin = (Button) view.findViewById(R.id.btnLogin);
        txtSignUp = (TextView) view.findViewById(R.id.txtSignUp);
        txtForgot = (TextView) view.findViewById(R.id.txtForgot);
        btnLoginFacebook = (Button) view.findViewById(R.id.btnLoginFaceInSigIn);
        btnLoginGoogle = (Button) view.findViewById(R.id.btnLogInGoogleSignIn);
    }

    private void referenceFireBase() {
        mData = FirebaseDatabase.getInstance().getReference();
    }




}
