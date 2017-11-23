package com.sang.findhotel;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseQuery;

import java.util.List;

public class DetailHotelActivity extends AppCompatActivity {
	private static final String INTENT_EXTRA = "DetailHotelActivity";
	private ViewPager mViewPager;
	private String objectId;
	private TextView phone, price, address;
	private Toolbar mToolbar;
	private FloatingActionButton fabCall;
	private TextView toolbarTitle;
	public static Intent newIntent(Context context, String id) {
		Intent intent = new Intent(context, DetailHotelActivity.class);
		intent.putExtra(INTENT_EXTRA, id);
		return intent;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_hotel);
		mToolbar = (Toolbar) findViewById(R.id.tool_bar);
		mToolbar.getBackground().setAlpha(0);
		setSupportActionBar(mToolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		mToolbar.setTitleTextColor(255);
		mViewPager = (ViewPager) findViewById(R.id.view_pager);
		fabCall = (FloatingActionButton) findViewById(R.id.fab_button);
		address = (TextView) findViewById(R.id.address_text_view);
		price = (TextView) findViewById(R.id.price_text_view);
		phone = (TextView) findViewById(R.id.phone_text_view);
		toolbarTitle = (TextView) findViewById(R.id.toolbar_title);
		objectId = getIntent().getStringExtra(INTENT_EXTRA);
		final ProgressDialog dialog = new ProgressDialog(DetailHotelActivity.this);
		dialog.setTitle("Please Wait");
		dialog.setMessage("Fetching Data");
		dialog.show();
		ParseQuery<Hotel> query = ParseQuery.getQuery(Hotel.class);
		query.getInBackground(objectId, new GetCallback<Hotel>() {
			@Override
			public void done(Hotel object, ParseException e) {
				dialog.dismiss();
				toolbarTitle.setText(object.getName());
				address.setText(object.getAddress());
				price.setText(object.getPriceDay().toString() + "/day\t" + object.getPriceHour().toString() + "/hour");
				phone.setText(object.getPhone().toString());
				fabCall.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						Intent intent = new Intent(Intent.ACTION_DIAL,
										Uri.parse("tel:" + phone.getText()));
						startActivity(intent);
					}
				});
				mViewPager.setAdapter(new ImagePageAdapter(getSupportFragmentManager(), object.getPhoto()));
			}
		});
	}

	private class ImagePageAdapter extends CustomFragmentStatePagerAdapter {
		private int num;
		private List<ParseFile> mList;

		public ImagePageAdapter(FragmentManager fragmentManager, List<ParseFile> list) {
			super(fragmentManager);
			this.num = list.size();
			this.mList = list;
		}

		@Override
		public Fragment getItem(int position) {
			return ImagePageFragment.newInstance(mList.get(position).getUrl());
		}

		@Override
		public int getCount() {
			return num;
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:
				onBackPressed();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}
}
