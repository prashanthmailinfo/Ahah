package com.echoandd.ahah;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TestActivity extends Activity implements OnClickListener{

	private TextView tText;
	private Button tButton;
	private int flag = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		// Show the Up button in the action bar.
		tText = (TextView)findViewById(R.id.testText);
		tButton  = (Button)findViewById(R.id.testButton);
		tButton.setOnClickListener(this);
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_test, menu);
		return true;
	}
	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Log.i("button", ""+v.getId());
		switch (v.getId()) {
		case R.id.testButton:
			if(this.flag == 0){
				tText.setText("设置项是文本，haha~");
				flag =1;
			}else{
				Toast.makeText(this, "文本已清理", Toast.LENGTH_SHORT).show();
				tText.setText("");
				flag = 0;
			}
			break;

		default:
			break;
		}
	}

}
