package mum.edu.javkhaanj7.studentapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.SeekBar;

public class Settings extends Activity implements
		SeekBar.OnSeekBarChangeListener {

	private SharedPreferences sp;
	private RadioButton r1, r2;
	private CheckBox cb;
	private TextView txtProgress;
	private SeekBar mSeekBar;

	private int max_mSeekBar;
	private int min_mSeekBar;
	private int start_mSeekBar;
	private int mValue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.settings);

		r1 = (RadioButton) findViewById(R.id.radio0);
		r2 = (RadioButton) findViewById(R.id.radio1);
		cb = (CheckBox) findViewById(R.id.checkBox1);
		txtProgress = (TextView) findViewById(R.id.progress);
		mSeekBar = (SeekBar) findViewById(R.id.seekBar1);

		getActionBar().setDisplayHomeAsUpEnabled(true);

		SharedPreferences sp = this.getSharedPreferences("sortPreferences",
				MODE_PRIVATE);
		String sortByName = sp.getString("sortByName", "yes");
		String showImageOnList = sp.getString("showImageOnList", "no");
		String secondsTimeLeft = sp.getString("secondsTimeLeft", "10");

		if (!sortByName.equals("yes")) {
			r2.setChecked(true);
		}

		if (showImageOnList.equals("yes")) {
			cb.setChecked(true);
		} else {
			cb.setChecked(false);
		}

		try {

			// http://www.anddev.org/how_to_set_minimum_value_for_seekbar-t6631.html
			min_mSeekBar = 1;
			max_mSeekBar = 60;
			start_mSeekBar = Integer.parseInt(secondsTimeLeft);
			mValue = start_mSeekBar;
			mSeekBar.setMax(60);

			mSeekBar.setProgress(mValue);

			mSeekBar.setOnSeekBarChangeListener(this);

			txtProgress
					.setText(String
							.format(getString(R.string.learn_name_s_time_left_second_configure),
									mValue));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	// @Override
	// public boolean onKeyDown(int keyCode, KeyEvent event) {
	// if (keyCode == KeyEvent.KEYCODE_BACK) {
	// saveSortType();
	// finish();
	// return true;
	// }
	// return super.onKeyDown(keyCode, event);
	// }

	@SuppressLint("NewApi")
	private void saveSortType() {
		sp = this.getSharedPreferences("sortPreferences", MODE_PRIVATE);
		Editor ed = sp.edit();

		if (r1.isChecked())
			ed.putString("sortByName", "yes");
		else
			ed.putString("sortByName", "no");

		if (cb.isChecked())
			ed.putString("showImageOnList", "yes");
		else
			ed.putString("showImageOnList", "no");
		
		ed.putString("secondsTimeLeft", "" + mValue);

		if (android.os.Build.VERSION.SDK_INT >= 9) {
			ed.apply();
		} else {
			ed.commit();
		}
	}

	@Override
	protected void onPause() {
		saveSortType();
		super.onPause();
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		// TODO Auto-generated method stub
		mValue = ((max_mSeekBar - min_mSeekBar) * progress / 60) + min_mSeekBar;

		txtProgress.setText(String.format(
				getString(R.string.learn_name_s_time_left_second_configure),
				mValue));
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}

	// @Override
	// protected void onStop () {
	// saveSortType();
	// super.onStop();
	// }

}
