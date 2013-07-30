package com.echoandd.ahah;

import foo.AlAudioRecord;
import android.app.Activity;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class SingleHaActivity extends Activity implements
		ViewSwitcher.ViewFactory,View.OnClickListener, OnLongClickListener {
	private int seconds=5000;
	private int recBufSize = AudioRecord.getMinBufferSize(8000,
			AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT);
	private AudioRecord audioRecord;
	private AlAudioRecord alAudioRecord;
	private TextSwitcher voiceScore;
	private TextView textViewInfo;

	@Override
	public void onClick(View arg0) {
		voiceScore.setText(String.valueOf(alAudioRecord.getVoice()));
	}


	@Override
	public boolean onLongClick(View arg0) {
		// TODO Auto-generated method stub
		Log.i("mmmm", "点击了");
		//初始化
		this.changetext(0);
		audioRecord = new AudioRecord(MediaRecorder.AudioSource.MIC, 8000,
				AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT, recBufSize);
		alAudioRecord = new AlAudioRecord(
				audioRecord, seconds, recBufSize);
		
		
		if(alAudioRecord.getRunStatus()){
			Toast.makeText(this,"已经点击，请等待~", Toast.LENGTH_SHORT).show();
			return false;
		}
		alAudioRecord.goRecord();
		int time = 5000;
 		while (true) {
			try {
				Thread.sleep(200);
				time -= 500;
				if(time<0){
					alAudioRecord.setRun(false);
					break;
				}
				this.changetext(alAudioRecord.getVoice());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.changetext(alAudioRecord.getVoice());
		Toast.makeText(this, "可以松开手指啦~\n^_^", Toast.LENGTH_LONG).show();
		return true;

	}

	@Override
	public View makeView() {
		TextView t = new TextView(this);
        t.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
        t.setTextSize(36);
        return t;
	}

	private void changetext(Object obj) {
		voiceScore.setText(String.valueOf(obj));
    }
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_single_ha);
		voiceScore = (TextSwitcher)findViewById(R.id.textSwitcher1);
		voiceScore.setFactory(this);

        Animation in = AnimationUtils.loadAnimation(this,
                android.R.anim.fade_in);
        Animation out = AnimationUtils.loadAnimation(this,
                android.R.anim.fade_out);
        voiceScore.setInAnimation(in);
        voiceScore.setOutAnimation(out);
        this.changetext(0);
        
        Button button = (Button) findViewById(R.id.goSButton);
        button.setOnLongClickListener(this);
		
        textViewInfo = (TextView) findViewById(R.id.textViewInfo);
        textViewInfo.setText("0");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		return false;
	}

}
