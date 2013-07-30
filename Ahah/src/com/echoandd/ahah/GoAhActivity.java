package com.echoandd.ahah;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GoAhActivity extends Activity implements OnClickListener{

	private Button aButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_go_ah);
		// go 按钮设置
		aButton = (Button)findViewById(R.id.goButton);
		Log.i("mmmm", "初始化"+R.id.goButton);
		aButton.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_go_ah, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Log.i("mmmm", ""+v.getId());
		switch (v.getId()) {
		case R.id.goButton:
			TextView textView = (TextView) findViewById(R.id.textView1);
			Log.i("mmmm", "点击了");
			textView.setText("点击了");
			break;
			
		default:
			Log.i("mmm", ""+v.getId());
			break;
		}
	}
}
