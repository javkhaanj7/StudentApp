package mum.edu.javkhaanj7.studentapp;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.os.CountDownTimer;

public class LearnNames extends Activity {

	private TextView textLearnName;
	private Button speechAndShowName;
	private Button randomize;
	private ImageView studentImage;
	private ImageView flagImage;
	private TextView name;
	private TextView country;
	private TextView txtNumber;
	private RelativeLayout infoRelativeLayout;
	private ImageButton next;
	private ImageButton previous;

	private List<StudentInfo> studentList;
	private int counter;

	private Music music;
	private Countries countries;
	private MyCounter timer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.learn_names);

		getActionBar().setDisplayHomeAsUpEnabled(true);

		textLearnName = (TextView) findViewById(R.id.textLearnName);
		speechAndShowName = (Button) findViewById(R.id.speechButton);
		randomize = (Button) findViewById(R.id.randomize);
		studentImage = (ImageView) findViewById(R.id.studentImage);
		flagImage = (ImageView) findViewById(R.id.flag);
		name = (TextView) findViewById(R.id.name);
		country = (TextView) findViewById(R.id.country);
		txtNumber = (TextView) findViewById(R.id.numberList);
		infoRelativeLayout = (RelativeLayout) findViewById(R.id.infoRelativeLayout);
		next = (ImageButton) findViewById(R.id.imageNext);
		previous = (ImageButton) findViewById(R.id.imagePrevious);

		String text = "<h3><u>Learn names</u></h3>";
		textLearnName.setText(Html.fromHtml(text));

		countries = new Countries();

		SharedPreferences sp = this.getSharedPreferences("sortPreferences",
				MODE_PRIVATE);
		String secondsTimeLeft = sp.getString("secondsTimeLeft", "10");

		int timeSetting = 10000;
		try {
			timeSetting = Integer.parseInt(secondsTimeLeft) * 1000;
		} catch (Exception e) {
			e.printStackTrace();
		}

		timer = new MyCounter(timeSetting, 1000);

		studentList = new ArrayList<StudentInfo>();

		for (int i = 0; i < MainActivity.items.length; i++) {
			studentList.add(MainActivity.items[i]);
		}

		speechAndShowName.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				doSpeechAndShowName();
				if (timer != null) {
					timer.cancel();
				}
			}
		});

		randomize.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				doRandomize();
				showToast("Done!");
			}
		});

		next.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				counter++;
				if (counter >= studentList.size()) {
					counter = 0;
				}
				quizStart();
			}
		});

		previous.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				counter--;
				if (counter < 0) {
					counter = studentList.size() - 1;
				}
				quizStart();
			}
		});

		doRandomize();
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

	private void doRandomize() {
		Collections.shuffle(studentList);
		counter = 0;
		quizStart();
	}

	private void quizStart() {
		setupStudentInfo();

		if (timer != null) {
			timer.cancel();
			timer.start();
		}
	}

	private void doSpeechAndShowName() {
		infoRelativeLayout.setVisibility(View.VISIBLE);
		playSound(studentList.get(counter).getSoundPath());
		txtNumber.setText(" ");
	}

	private void setupStudentInfo() {

		name.setText(studentList.get(counter).getName());
		country.setText(studentList.get(counter).getCountry());

		initStudentImage();
		initFlagImage();

		infoRelativeLayout.setVisibility(View.GONE);
	}

	private void initFlagImage() {
		Country country = countries.getCountryByKeyName(studentList
				.get(counter).getCountry());

		if (country != null) {
			InputStream bitmap = null;

			try {
				bitmap = getAssets().open(
						"flags_32px/" + country.getFlagImagePath());
				Bitmap bit = BitmapFactory.decodeStream(bitmap);
				flagImage.setImageBitmap(bit);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (bitmap != null)
					try {
						bitmap.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}

		}
	}

	private void initStudentImage() {
		InputStream bitmap = null;

		try {
			bitmap = getAssets().open(
					"studentImages/" + studentList.get(counter).getImageName());
			Bitmap bit = BitmapFactory.decodeStream(bitmap);
			studentImage.setImageBitmap(bit);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bitmap != null)
				try {
					bitmap.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	}

	private void showToast(String text) {
		Toast toast = Toast.makeText(getApplicationContext(), text,
				Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
		toast.show();
	}

	private void playSound(String soundName) {
		try {
			music = new Music(getAssets().openFd("pronounces/" + soundName));
			music.play();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	private class MyCounter extends CountDownTimer {

		public MyCounter(long millisInFuture, long countDownInterval) {
			super(millisInFuture, countDownInterval);
		}

		@Override
		public void onFinish() {
			doSpeechAndShowName();
		}

		@Override
		public void onTick(long millisUntilFinished) {
			txtNumber.setText("Time Left: " + (millisUntilFinished / 1000));
		}
	}

}
