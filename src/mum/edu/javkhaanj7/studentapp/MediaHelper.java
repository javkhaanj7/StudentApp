package mum.edu.javkhaanj7.studentapp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.media.MediaRecorder.OnErrorListener;
import android.media.MediaRecorder.OnInfoListener;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

public class MediaHelper implements OnErrorListener, OnInfoListener,
		OnCompletionListener, OnPreparedListener, OnVideoSizeChangedListener {
	private MediaRecorder recorder;

	public MediaHelper(Context context) {
		recorder = new MediaRecorder();
		if (context instanceof OnErrorListener) {
			recorder.setOnErrorListener((OnErrorListener) context);
		} else {
			recorder.setOnErrorListener(this);
		}
		if (context instanceof OnInfoListener) {
			recorder.setOnInfoListener((OnInfoListener) context);
		} else {
			recorder.setOnInfoListener(this);
		}
	}

	public void release() {
		recorder.release();
		recorder = null;
	}

	public void startRecording(Context context, File output) {
		recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
		recorder.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);
		recorder.setOutputFile(output.getAbsolutePath());

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD_MR1) {
			recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
			recorder.setAudioEncodingBitRate(160 * 1024);
		} else {
			recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
		}

		recorder.setAudioChannels(2);

		try {
			recorder.prepare();
			recorder.start();
		} catch (Exception e) {
			Log.e(getClass().getSimpleName(),
					"Exception in preparing recorder", e);
			Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
		}
	}

	public void stopRecording() {
		try {
			recorder.stop();
		} catch (Exception ex) {
			Log.w(getClass().getSimpleName(), "Exception in stopping recorder",
					ex);
		}
	}

	public void play(Context context, int audioID) {
		try {
			MediaPlayer mp = new MediaPlayer();
			String tempFile = copyToExternalFile(context, audioID);

			mp.setDataSource(tempFile);
			if (context instanceof OnCompletionListener) {
				mp.setOnCompletionListener((OnCompletionListener) context);
			} else {
				mp.setOnCompletionListener(this);
			}

			if (context instanceof OnPreparedListener) {
				mp.setOnPreparedListener((OnPreparedListener) context);
			} else {
				mp.setOnPreparedListener(this);
			}

			if (context instanceof OnVideoSizeChangedListener) {
				mp.setOnVideoSizeChangedListener((OnVideoSizeChangedListener) context);
			} else {
				mp.setOnVideoSizeChangedListener(this);
			}

			mp.prepare();
			mp.seekTo(0);
			mp.start();
		} catch (Exception ex) {
			Log.w(getClass().getSimpleName(), "Error in playback", ex);
		}
	}

	// Hack. Copy raw audio file with id audioID to external file temp.wma
	private String copyToExternalFile (Context context, int audioID) {
		try {
			InputStream is = context.getResources().openRawResource(audioID);
			
			byte[] b = new byte[is.available()];
			is.read(b);
			is.close();

	        File root= context.getExternalFilesDir(null);
	        File out = new File(root, "temp.wma");
	        FileOutputStream fos=new FileOutputStream(out);
	        fos.write(b);
	        fos.flush();
	        fos.getFD().sync();
	        fos.close();
	        return String.format("%s/temp.wma", root.getAbsolutePath());
		} catch (Exception ex) {
			Log.e("Lab08", ex.toString());
			return null;
		}
	}
	
	@Override
	public void onCompletion(MediaPlayer mp) {
	}

	@Override
	public void onInfo(MediaRecorder mr, int what, int extra) {
	}

	@Override
	public void onError(MediaRecorder mr, int what, int extra) {
	}

	@Override
	public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
	}

	@Override
	public void onPrepared(MediaPlayer mp) {
	}
}
