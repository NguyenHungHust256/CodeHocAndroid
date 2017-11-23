package com.example.ba_hung.loginwithfacebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.widget.ProfilePictureView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ProfilePictureView imgAvatar;
    LoginButton btnLoginFacebook;
    Button btnLogOutFace;
    TextView txtNameFace, txtEmailFace;
    CallbackManager callbackManager;
    String nameFace, emailFace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FacebookSdk.sdkInitialize(getApplicationContext());
        super.onCreate(savedInstanceState);

        callbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.activity_main);
        AnhXa();
        hideComponent();
        setListenerBtnLoginFaceBook();
    }

    private void setListenerBtnLoginFaceBook() {
        btnLoginFacebook.setReadPermissions(Arrays.asList("public_profile","email"));
        btnLoginFacebook.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(MainActivity.this, "OK SUCCESS", Toast.LENGTH_SHORT).show();
                btnLoginFacebook.setVisibility(View.INVISIBLE);
                imgAvatar.setVisibility(View.VISIBLE);
                btnLogOutFace.setVisibility(View.VISIBLE);
                txtNameFace.setVisibility(View.VISIBLE);
                txtEmailFace.setVisibility(View.VISIBLE);
                result();
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
    }

    private void result() {
        GraphRequest graphRequest = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                Log.d("JSON", response.toString());
                try {
                    Toast.makeText(MainActivity.this, "Ahihi duoc roi", Toast.LENGTH_SHORT).show();
                    nameFace = object.get("name").toString();
                    emailFace = object.get("email").toString();
                    imgAvatar.setProfileId(Profile.getCurrentProfile().getId());
                    txtNameFace.setText(nameFace);
                    txtEmailFace.setText(emailFace);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        });
        Bundle parameters = new Bundle();
        parameters.putString("fields","name,email,first_name");
        graphRequest.setParameters(parameters);
        graphRequest.executeAsync();

    }

    private void hideComponent() {
        imgAvatar.setVisibility(View.INVISIBLE);
        btnLogOutFace.setVisibility(View.INVISIBLE);
        txtNameFace.setVisibility(View.INVISIBLE);
        txtEmailFace.setVisibility(View.INVISIBLE);
    }

    private void AnhXa() {
        imgAvatar = (ProfilePictureView) findViewById(R.id.image_avatar);
        btnLoginFacebook = (LoginButton) findViewById(R.id.btnLoginFacebook);
        txtNameFace = (TextView) findViewById(R.id.txtNameFace);
        txtEmailFace = (TextView) findViewById(R.id.txtEmailFacebook);
        btnLogOutFace=(Button) findViewById(R.id.btnLogOut);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onStart() {
        LoginManager.getInstance().logOut();
        super.onStart();
    }
}
