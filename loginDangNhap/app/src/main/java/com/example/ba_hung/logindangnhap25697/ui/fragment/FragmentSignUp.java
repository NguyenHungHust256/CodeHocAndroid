package com.example.ba_hung.logindangnhap25697.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ba_hung.logindangnhap25697.R;
import com.example.ba_hung.logindangnhap25697.model.UserModel;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSignUp extends Fragment {

    private DatabaseReference mData;
    private View view;
    private EditText edtUserName, edtPass, edtRepeatPass, edtEmail;
    private Button btnCreateAccount;

    public FragmentSignUp() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//              Xử lí firebase
        referenceFireBase();
//        Anh xa
        AnhXa();
//Lay du lieu
        setListenerCreateAccount();
    }

    private void setListenerCreateAccount() {
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = edtUserName.getText().toString();
                String password = edtPass.getText().toString();
                String repeatePass = edtRepeatPass.getText().toString();
                String email = edtEmail.getText().toString();

                UserModel user = new UserModel(email, userName, password);
                validate(email);
                if (userName.length() != 0 && repeatePass.equals(password) && password.length() != 0) {
                    if (validate(email)) {
                        mData.push().setValue(user, new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                                Toast.makeText(getActivity(), "da them thanh cong", Toast.LENGTH_SHORT).show();
                            }
                        });
                    } else {
                        Toast.makeText(getActivity(), "Email bạn cho đã sai", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getActivity(), "Fail", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

    private void referenceFireBase() {
        mData = FirebaseDatabase.getInstance().getReference();
    }

    private void AnhXa() {
        edtUserName = (EditText) view.findViewById(R.id.edtUserNameSignUp);
        edtPass = (EditText) view.findViewById(R.id.edtPassWordSignUp);
        edtRepeatPass = (EditText) view.findViewById(R.id.edtRepeatPassSignUp);
        edtEmail = (EditText) view.findViewById(R.id.edtEmail);
        btnCreateAccount = (Button) view.findViewById(R.id.btnCreateAccount);
    }

    private void SignUpSuccess() {
        Toast toast = new Toast(getActivity());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View v = inflater.inflate(R.layout.view_sign_in_success, null);
        toast.setView(v);
        toast.show();

    }

    //    Ham check email
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

}


