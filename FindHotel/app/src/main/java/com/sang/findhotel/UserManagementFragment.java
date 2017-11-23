package com.sang.findhotel;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by sang on 11/12/2015.
 */
public class UserManagementFragment extends Fragment{
  private ImageButton mUploadButton;
  private ListView listViewHotel;
  private List<String> listhotelname = new ArrayList<String>();
  private String username;
  private TextView tvUsername;
  private ImageView imageView;
  public static Fragment newInstance(){
    return new UserManagementFragment();
  }
  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_user_management, container, false);
    tvUsername = (TextView) view.findViewById(R.id.textview_username);
    mUploadButton = (ImageButton) view.findViewById(R.id.upload_button);
    listViewHotel = (ListView) view.findViewById(R.id.listview_hotel);
    username=ParseUser.getCurrentUser().getUsername();
    tvUsername.setText(username);
    imageView = (ImageView) view.findViewById(R.id.imageview_1);
    int[] colors = {0,0xff9400D3, 0};
    listViewHotel.setDivider(new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, colors));
    listViewHotel.setDividerHeight(4);


    ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery("Hotel");
    parseQuery.findInBackground(new FindCallback<ParseObject>() {
      @Override
      public void done(List<ParseObject> objects, ParseException e) {
        for (ParseObject object : objects) {
          if (ParseUser.getCurrentUser().getUsername().equals(object.getString("Owner"))) {
            listhotelname.add(object.getString("Name"));

          }
        }
        setlistview();
      }
    });

    mUploadButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        startActivity(new Intent(getActivity(), UploadActivity.class));
      }
    });
    return view;
  }

  private void setlistview(){
    CustomLisvtviewHotelAdapter listviewadapter = new CustomLisvtviewHotelAdapter(getActivity(), listhotelname);
    listViewHotel.setAdapter(listviewadapter);
  }
}
