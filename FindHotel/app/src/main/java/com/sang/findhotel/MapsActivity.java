package com.sang.findhotel;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

  private GoogleMap mMap;
  private Toolbar mToolbar;
  private List<LatLng> markerPoints, ListLstlngHotel;
  private String maddress, namehotel, priceday;
  private String cityname = null;
  private Button btndetail, btnstreet;
  private Marker mMarker;
  private List<String> listIDhotel, listNameHotel, listPriceDay;
  public LatLng latLng_hotel_loction;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_maps);
    // Obtain the SupportMapFragment and get notified when the map is ready to be used.

    mToolbar = (Toolbar) findViewById(R.id.tool_bar);
    mToolbar.setTitle("Map");
    setSupportActionBar(mToolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setTitle("Map");
    SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
            .findFragmentById(R.id.map);
    mMap = mapFragment.getMap();
    mMap.setMyLocationEnabled(true);
    mylocation();
    mMap.getUiSettings().setZoomControlsEnabled(true);
    mapFragment.getMapAsync(this);
    if (cityname != null) {
      addHotelList();
    }

    mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
      @Override
      public View getInfoWindow(Marker marker) {
        return null;
      }

      @Override
      public View getInfoContents(Marker marker) {
        View view = getLayoutInflater().inflate(R.layout.infowindow, null);
        TextView hotelname = (TextView) view.findViewById(R.id.tv_hotelname);
        TextView hotelprice = (TextView) view.findViewById(R.id.tv_hotelprice);
        hotelname.setText(marker.getTitle());
        hotelprice.setText(marker.getSnippet());
        return view;
      }
    });
    mMap.setOnMyLocationButtonClickListener(new GoogleMap.OnMyLocationButtonClickListener() {
      @Override
      public boolean onMyLocationButtonClick() {
        mylocation();
        if (cityname != null) {
          mMap.clear();
          addHotelList();
          btndetail.setVisibility(View.INVISIBLE);
        }
        return true;

      }
    });

    mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
      @Override
      public boolean onMarkerClick(Marker marker) {
        mMarker = marker;
        marker.showInfoWindow();
        btnstreet.setVisibility(View.VISIBLE);
        btndetail.setVisibility(View.VISIBLE);
        return true;
      }
    });

    btndetail = (Button) findViewById(R.id.button_detail);
    btndetail.setVisibility(View.INVISIBLE);
    btnstreet = (Button) findViewById(R.id.button_street);
    btnstreet.setVisibility(View.INVISIBLE);
    btnstreet.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        routes(mMarker);
        btnstreet.setVisibility(View.INVISIBLE);
      }
    });

    btndetail.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        for (int i = 0; i < ListLstlngHotel.size(); i++) {
          System.out.println(mMarker.getPosition());
          System.out.println(ListLstlngHotel.get(i));
          if (mMarker.getPosition().latitude == ListLstlngHotel.get(i).latitude && mMarker.getPosition().longitude == ListLstlngHotel.get(i).longitude) {
            String ID = listIDhotel.get(i);
            Intent intent = new Intent(MapsActivity.this, DetailHotelActivity.class);
            intent.putExtra("DetailHotelActivity", ID);
            btndetail.setVisibility(View.INVISIBLE);
            btnstreet.setVisibility(View.INVISIBLE);
            startActivity(intent);
          }

        }

      }
    });

  }


  /**
   * Manipulates the map once available.
   * This callback is triggered when the map is ready to be used.
   * This is where we can add markers or lines, add listeners or move the camera. In this case,
   * we just add a marker near Sydney, Australia.
   * If Google Play services is not installed on the device, the user will be prompted to install
   * it inside the SupportMapFragment. This method will only be triggered once the user has
   * installed Google Play services and returned to the app.
   */
  @Override
  public void onMapReady(GoogleMap googleMap) {
//    mMap.setMyLocationEnabled(true);
//    mylocation(mMap);
  }

  private void mylocation() {
    LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
    Criteria criteria = new Criteria();

    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
      // TODO: Consider calling
      //    ActivityCompat#requestPermissions
      // here to request the missing permissions, and then overriding
      //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
      //                                          int[] grantResults)
      // to handle the case where the user grants the permission. See the documentation
      // for ActivityCompat#requestPermissions for more details.
      return;
    }
    Location location = locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, true));
    if(location!= null){
      LatLng latLng = new LatLng(location.getLatitude(),location.getLongitude());
      Geocoder geocoder = new Geocoder(this, Locale.getDefault());
      try {
        List<Address> addressList =  geocoder.getFromLocation(latLng.latitude,latLng.longitude,1);
        cityname = addressList.get(0).getAdminArea();
      } catch (IOException e) {
        e.printStackTrace();
      }
      CameraPosition cameraPosition = new CameraPosition.Builder().target(latLng)
              .zoom(13)
              .bearing(0)
              .tilt(0)
              .build();
      mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

    }

  }

  private void routes(Marker marker) {

    markerPoints = new ArrayList<LatLng>();
    if (markerPoints.size() > 1) {
      markerPoints.clear();
    }
    mMap.clear();
    for (int i = 0 ;i<ListLstlngHotel.size();i++){
      addMarker(ListLstlngHotel.get(i),listNameHotel.get(i),listPriceDay.get(i));
    }
    Location mylocation = mMap.getMyLocation();
    LatLng mylatlng = new LatLng(mylocation.getLatitude(), mylocation.getLongitude());
    markerPoints.add(mylatlng);
    markerPoints.add(marker.getPosition());
    MarkerOptions options = new MarkerOptions();
    options.position(marker.getPosition()).title(marker.getTitle()).snippet(marker.getSnippet()).flat(false);
    if (markerPoints.size() == 2) {
      LatLng origin = markerPoints.get(0);
      LatLng dest = markerPoints.get(1);
      String url = getDirectionsUrl(origin, dest);
      DownloadStackDistance downloadTask1 = new DownloadStackDistance(mMap);
      downloadTask1.execute(url);
    }
    marker.showInfoWindow();

  }

  private String getDirectionsUrl(LatLng origin,LatLng dest){
    String str_origin = "origin="+origin.latitude+","+origin.longitude;
    String str_dest = "destination="+dest.latitude+","+dest.longitude;
    String sensor = "sensor=false";
    String parameters = str_origin+"&"+str_dest+"&"+sensor;
    String output = "json";
    String url = "https://maps.googleapis.com/maps/api/directions/"+output+"?"+parameters;
    return url;
  }

  private void addHotelList() {
    listNameHotel= new ArrayList<String>();
    listPriceDay = new ArrayList<String>();
    listIDhotel = new ArrayList<String>();
    ListLstlngHotel = new ArrayList<LatLng>();
    ParseQuery<ParseObject> query = ParseQuery.getQuery("Hotel");
    query.findInBackground(new FindCallback<ParseObject>() {
      @Override
      public void done(List<ParseObject> objects, ParseException e) {
        for (ParseObject object : objects) {
          String ID = object.getObjectId();
          System.out.println(ID);
          String city = removeAccent(object.getString("City"));
          String mCity = removeAccent(cityname);
          if (city.compareToIgnoreCase(mCity) == 0) {
            listIDhotel.add(ID);
            namehotel = object.getString("Name");
            listNameHotel.add(namehotel);
            maddress = object.getString("Address");
            priceday = String.valueOf(object.get("PriceDay"));
            listPriceDay.add(priceday);
            SearchLocation(maddress);
          }
        }
      }
    });
  }
  private void addMarker(LatLng latLng,String namehotel,String priceday) {
    MarkerOptions mkoption = new MarkerOptions();
    mkoption.position(latLng).title(namehotel).snippet(priceday + "đ");
    mkoption.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_marker));
    mMap.addMarker(mkoption);
  }

  private void SearchLocation(String location){
    if(location==null || location.equals("")){
      return;
    }
    String url = "https://maps.googleapis.com/maps/api/geocode/json?";
    try {
      location = URLEncoder.encode(location, "utf-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    String address = "address=" + location;
    String sensor = "sensor=false";
    url = url + address + "&" + sensor;
    StackSearchLocation stackSearchLocation = new StackSearchLocation(mMap,namehotel,priceday);
    stackSearchLocation.execute(url);
  }

  private static String removeAccent(String s) {
    s=s.replaceAll(" ","");
    String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
    Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
    return pattern.matcher(temp).replaceAll("");
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()){
      case android.R.id.home:
        onBackPressed();
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }





  private class StackSearchLocation extends AsyncTask<String,Integer,String> {
    private String data="";
    private GoogleMap mMap;
    private String namehotel,priceday;
    private JSONObject jsonObject;




    public StackSearchLocation(GoogleMap map, String namehotel,String priceday){
      this.mMap= map;
      this.namehotel= namehotel;
      this.priceday=priceday;
    }
    @Override
    protected String doInBackground(String... url) {
      try{
        data= downloadUrl(url[0]);
      }catch(Exception e){
      }
      if(data.equals("{   \"results\" : [],   \"status\" : \"ZERO_RESULTS\"}"))
        return null;
      return data;
    }
    private String downloadUrl(String strUrl) throws IOException {
      String data = "";
      System.out.println(strUrl);
      InputStream iStream = null;
      HttpURLConnection urlConnection = null;
      try {
        URL url = new URL(strUrl);
        urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.connect();
        iStream = urlConnection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(iStream));
        StringBuffer sb = new StringBuffer();
        String line = "";
        while ((line = br.readLine()) != null) {
          sb.append(line);
        }
        data = sb.toString();
        br.close();
      } catch (Exception e) {
      } finally {
        iStream.close();
        urlConnection.disconnect();
      }
      return data;
    }
    @Override
    protected void onPostExecute(String result) {
      if(result!=null) {
        addMarkerHotel(ParserTaskSearchLocation(result));
      }

    }

    private List<HashMap<String, String>>  ParserTaskSearchLocation(String result){
      List<HashMap<String, String>> places = null;
      GeocodeJSONParser parser = new GeocodeJSONParser();
      try {
        jsonObject = new JSONObject(result);
        places = parser.parse(jsonObject);
      } catch (Exception e) {
      }
      return places;
    }
    private void addMarkerHotel(List<HashMap<String, String>> list) {
      latLng_hotel_loction = new LatLng(Double.valueOf(list.get(0).get("lat")),Double.valueOf(list.get(0).get("lng")));
      ListLstlngHotel.add(latLng_hotel_loction);
      MarkerOptions mkoption = new MarkerOptions();
      mkoption.position(latLng_hotel_loction).title(namehotel).snippet(priceday + "đ");
      mkoption.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_marker));
      mMap.addMarker(mkoption);
    }
  }

}

