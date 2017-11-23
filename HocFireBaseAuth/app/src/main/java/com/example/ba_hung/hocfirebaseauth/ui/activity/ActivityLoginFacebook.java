package com.example.ba_hung.hocfirebaseauth.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ba_hung.hocfirebaseauth.R;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.squareup.picasso.Picasso;

public class ActivityLoginFacebook extends AppCompatActivity implements View.OnClickListener {

    private CallbackManager mCallbackManager;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private TextView txtEmail, txtUser;
    private ImageView imgProfile;
    LoginButton loginButton;
    Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_facebook);
        xacDinhKetNoiMangHayChua();
        anhXa();
        mAuth = FirebaseAuth.getInstance();
        callBack();
        mAuthListener();
        anGiaoDien();
        logoutButton.setOnClickListener(this);

    }

    private void mAuthListener() {
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Log.d("", "onAuthStateChanged:signed_in:" + user.getUid());
                    hienGiaoDien();
                    txtUser.setText(user.getDisplayName());
                    txtEmail.setText(user.getEmail());
                    Picasso.with(ActivityLoginFacebook.this).load(user.getPhotoUrl()).into(imgProfile);
                } else {
                    Log.d("TG", "SIGNED OUT");
                }
            }
        };
    }

    private void callBack() {
        mCallbackManager = CallbackManager.Factory.create();
        loginButton.setReadPermissions("email", "public_profile");
        loginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                handleFacebookAccessToken(loginResult.getAccessToken());
                Log.d("", "facebook:onSuccess:" + loginResult);
            }

            @Override
            public void onCancel() {
                Log.d("TAG", "facebook:onCancel");
            }

            @Override
            public void onError(FacebookException error) {
                Log.d("TAG", "facebook:onError", error);
            }
        });
    }

    private void anhXa() {
        logoutButton = (Button) findViewById(R.id.btnLogOutFace);
        loginButton = (LoginButton) findViewById(R.id.login_button);
        txtUser = (TextView) findViewById(R.id.txtUser);
        txtEmail = (TextView) findViewById(R.id.txtEmail);
        imgProfile = (ImageView) findViewById(R.id.imgProfile);
    }


    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    private void handleFacebookAccessToken(AccessToken token) {
        Log.d("", "handleFacebookAccessToken:" + token);

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d("", "signInWithCredential:onComplete:" + task.isSuccessful());
                        if (!task.isSuccessful()) {
                            Log.w("", "signInWithCredential", task.getException());
                            Toast.makeText(ActivityLoginFacebook.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                            if (user != null) {

                                for (UserInfo userInfo : user.getProviderData()) {
                                    Log.d("TAG", userInfo.getProviderId());
                                }
                                hienGiaoDien();
                                txtUser.setText(user.getDisplayName());
                                txtEmail.setText(user.getEmail());
                                Picasso.with(ActivityLoginFacebook.this).load(user.getPhotoUrl()).into(imgProfile);
                            }
                        }

                    }
                });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode,
                resultCode, data);
    }

    public void anGiaoDien(){
        loginButton.setVisibility(View.VISIBLE);
        logoutButton.setVisibility(View.INVISIBLE);
        txtEmail.setVisibility(View.INVISIBLE);
        txtUser.setVisibility(View.INVISIBLE);
        imgProfile.setVisibility(View.INVISIBLE);
    }
    public void hienGiaoDien(){
        loginButton.setVisibility(View.INVISIBLE);
        logoutButton.setVisibility(View.VISIBLE);
        txtEmail.setVisibility(View.VISIBLE);
        txtUser.setVisibility(View.VISIBLE);
        imgProfile.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnLogOutFace){
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            if(user != null){
                FirebaseAuth.getInstance().signOut();
                anGiaoDien();
                LoginManager.getInstance().logOut();
            }
        }
    }
    public void xacDinhKetNoiMangHayChua() {
        ConnectivityManager cm =
                (ConnectivityManager) (ActivityLoginFacebook.this).getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        if (!isConnected) {
            Toast.makeText(this, "Bạn chưa kết nối mạng.", Toast.LENGTH_SHORT).show();
        }
    }
}
