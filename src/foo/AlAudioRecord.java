package foo;

import android.media.AudioRecord;
import android.util.Log;
import android.widget.TextSwitcher;
import android.widget.Toast;

public class AlAudioRecord {

	private AudioRecordThread audioRecordThread;
	private int seconds;
	private AudioRecord audioRecord;
	private int recBufSize;
	private int voice;
	private int runVoice;
	private double db;
	
	private boolean isRun = false;
	public boolean getRunStatus() {
		return isRun;
	}

	public void setRun(boolean isRun) {
		this.isRun = isRun;
	}


	public AlAudioRecord(AudioRecord audioRecord, int seconds, int recBufSize) {
		this.audioRecord = audioRecord;
		this.seconds = seconds;
		this.audioRecordThread = new AudioRecordThread();
		this.recBufSize = recBufSize;
	}
	
	public void goRecord(){
		if (!isRun) {
			 audioRecordThread.start();
		}
	}
	public int getVoiceLevel() {
		return 0;
	}
	
	
	/**
	 * 获取分贝量
	 * @return
	 */
	public double getDB() {
		return db;
	}
	
	
	public int getVoice() {
		return runVoice;
	}
	class AudioRecordThread extends Thread {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			isRun = true;
			audioRecord.startRecording();
			Log.i("RRRRRR", "start.................. ");
			
			byte[] buffer = new byte[recBufSize];
//		    Log.d("lengthhhhh", ""+buffer.length);
			int tmp_v = 0;
	        while (isRun) {
	            int r = audioRecord.read(buffer, 0, recBufSize);
	            int v = 0;
	            for (int i = 0; i < buffer.length; i++) {
	                v += buffer[i] * buffer[i];
	            }
	            voice = (int) (Math.abs((int)(v/(double)r)));
	            db = 10*Math.log10(v/(double)r); 
	            runVoice = voice > tmp_v ? voice : tmp_v;
	            tmp_v = runVoice;
	            Log.i("SPLLLLLL", ""+runVoice);
//	            Log.d("DBBBBBB", ""+db);
	        }
			audioRecord.stop();
			Log.i("RRRRRR", "enddd.................. ");
		}
	}

}
