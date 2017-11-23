package com.example.ba_hung.logindangnhap25697.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.ba_hung.logindangnhap25697.R;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.widget.ProfilePictureView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentFacebook extends Fragment {
    private View view;
    ProfilePictureView avatar;
    TextView txtNameFace, txtEmailFace;
    Button btnLogOutFace;
    LoginButton btnLoginFacebook;
    CallbackManager callbackManager;
    String nameFacebook, emailFacebook, img_idFacebook;


    public FragmentFacebook() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_facebook, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        callBackFacebook();
        AnhXa();
        hideComponent();
        setListenerBtnLoginFacebook();
    }

    private void callBackFacebook() {

        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        // dùng để khi chúng ta gửi lên server 1
        // thông điệp thì bên server cũng guiwrlaij 1 thông diệp
    }
    private void AnhXa() {
        avatar = (ProfilePictureView) view.findViewById(R.id.avatar);
        txtNameFace = (TextView) view.findViewById(R.id.txtNameFace);
        txtEmailFace = (TextView) view.findViewById(R.id.txtEmailFace);
        btnLogOutFace = (Button) view.findViewById(R.id.btnLogOut);
        btnLoginFacebook = (LoginButton) view.findViewById(R.id.btnLoginFacebook);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void setListenerBtnLoginFacebook() {
        btnLoginFacebook.setReadPermissions(Arrays.asList("public_profile", "email"));
        btnLoginFacebook.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                result();
                btnLoginFacebook.setVisibility(View.INVISIBLE);
                txtEmailFace.setVisibility(View.VISIBLE);
                txtNameFace.setVisibility(View.VISIBLE);
                avatar.setVisibility(View.VISIBLE);
                btnLogOutFace.setVisibility(View.VISIBLE);
            }

            @Override
            public void onCancel() {
                Toast.makeText(getActivity(), "Cancel", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(getActivity(), error.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void result() {
        GraphRequest graphRequest = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                Log.d("JSON", response.toString());
                try {
                    emailFacebook = object.getString("email");
                    nameFacebook = object.getString("name");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                img_idFacebook = Profile.getCurrentProfile().getId();

                txtNameFace.setText(nameFacebook);
                txtEmailFace.setText(emailFacebook);
                avatar.setProfileId(img_idFacebook);

            }
        });
        Bundle bd = new Bundle();
        bd.putString("fields", "name,email,first_name");
        graphRequest.setParameters(bd);
        graphRequest.executeAsync();
    }


    private void hideComponent() {
        txtEmailFace.setVisibility(View.INVISIBLE);
        txtNameFace.setVisibility(View.INVISIBLE);
        avatar.setVisibility(View.INVISIBLE);
        btnLogOutFace.setVisibility(View.INVISIBLE);
    }

}
