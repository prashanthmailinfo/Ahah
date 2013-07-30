package com.echoandd.ahah;


import foo.AlAudioRecord;
import android.content.Intent;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends FragmentActivity implements OnClickListener{

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;
	

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());
		mSectionsPagerAdapter.getItem(2);
		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.activity_home, menu);
		super.onCreateOptionsMenu(menu);
		menu.add(0, 1, 1, "设置");
		menu.add(0, 2, 2, "信息");
		menu.add(0, 3, 3, "关于"); 
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
	
		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		// TODO Auto-generated method stub
		Log.i("menu", (featureId+"=="+item.getItemId()));
		Intent intent = new Intent();
		switch (item.getItemId()) {
		case 1:
			Log.i("menu", "11");
			startActivity(new Intent(HomeActivity.this, SingleHaActivity.class));
			overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
			break;
		case 2:
			Log.i("menu", "22");
			startActivity(new Intent(HomeActivity.this, TestActivity.class));
			overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
			break;
		case 3:
			Log.i("menu", "33");
			intent.setClass(this, AboutActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
		return true;
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a DummySectionFragment (defined as a static inner class
			// below) with the page number as its lone argument.
			Fragment fragment = new DummySectionFragment();
			Bundle args = new Bundle();
			args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
			fragment.setArguments(args);
			return fragment;
		}

		@Override
		public int getCount() {
			// Show 3 total pages.
			return 3;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			switch (position) {
			case 0:
				return getString(R.string.ranktab).toUpperCase();
			case 1:
				return getString(R.string.goah).toUpperCase();
			case 2:
				return getString(R.string.abouttab).toUpperCase();
			}
			return null;
		}
	}

	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	public static class DummySectionFragment extends Fragment{
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_tab_number";
		public DummySectionFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			// Create a new TextView and set its text to the fragment's section
			// number argument value.
			TextView textView = new TextView(getActivity());
			textView.setGravity(Gravity.CENTER);
			int tabNo = getArguments().getInt(ARG_SECTION_NUMBER); 
			switch (tabNo) {
			case 1:
				textView.setText("haha~~1");
				break;
			case 2:
//				Toast.makeText(getActivity(),String.valueOf(tabNo), Toast.LENGTH_SHORT).show();
//				textView.setText("33333333333");
				View layoutView = inflater.inflate(R.layout.activity_go_ah,null);
				Button tButton = (Button)layoutView.findViewById(R.id.goButton);
				final TextView textViewsub = (TextView)layoutView.findViewById(R.id.textView1);
				final ProgressBar dbBar = (ProgressBar)layoutView.findViewById(R.id.dbProgressBar);
				dbBar.setProgress(0);
				return layoutView;
			case 3:
				if (container == null)
	                return null;

	            TextView text = new TextView(getActivity());
	            text.setId(1);
	            text.setGravity(Gravity.CENTER);
	            Log.i("fragment", "");
	            text.setText("开始");
	            text.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Toast.makeText(getActivity(),"开始了~", Toast.LENGTH_SHORT).show();
					}
				});
	            return text;
			default:
				break;

			}
			return textView;
		}

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	
}
