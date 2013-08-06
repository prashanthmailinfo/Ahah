package com.echoandd.ahah;

import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ToggleButton;

public class LightActivity extends Activity {

	public ToggleButton lightButton;
	public Camera camera;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_light);
		lightButton = (ToggleButton)findViewById(R.id.toggleLightButton);
		
		lightButton.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				Log.i("", isChecked+"------");
				if(isChecked && camera == null){
				camera = Camera.open();	
				Camera.Parameters parameters = camera.getParameters();
				parameters.setFlashMode(Parameters.FLASH_MODE_TORCH);
				camera.setParameters(parameters);
				}else if(!isChecked){
					camera.release();
					camera = null;
				}else{
					camera = null;
				}
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_light, menu);
		return true;
	}

}
