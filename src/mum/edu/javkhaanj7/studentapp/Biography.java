package mum.edu.javkhaanj7.studentapp;

import java.io.InputStream;
import java.util.Locale;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Html;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.MenuItem;
import android.view.View;

public class Biography extends Activity {

	public static final String NAME_MESSAGE = "name_msg";
	public static final String COUNTRY_MESSAGE = "country_msg";
	public static final String IMAGE_MESSAGE = "image_msg";
	public static final String FLAG_MESSAGE = "flag_msg";
	public static final String BIO_MESSAGE = "bio_msg";
	public static final String SOUND_MESSAGE = "sound_msg";

	private ImageView studentImage;
	private ImageView flagImage;
	private TextView name;
	private TextView country;
	private TextView textBiography;
	private WebView webView;
	private ImageButton playButton;
	private Music music;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.biography);

		studentImage = (ImageView) findViewById(R.id.studentImage);
		flagImage = (ImageView) findViewById(R.id.flag);
		name = (TextView) findViewById(R.id.name);
		country = (TextView) findViewById(R.id.country);
		textBiography = (TextView) findViewById(R.id.textBiography);
		webView = (WebView) findViewById(R.id.webView1);
		playButton = (ImageButton) findViewById(R.id.playButton);

		//textBiography.setMovementMethod(new ScrollingMovementMethod());

		name.setText(getIntent().getStringExtra(NAME_MESSAGE));
		country.setText(getIntent().getStringExtra(COUNTRY_MESSAGE));
		
		//http://developer.android.com/training/implementing-navigation/ancestral.html
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
//		mediaHelper = new MediaHelper(this);
		
		InputStream bitmap = null;

		try {
			bitmap = getAssets().open(
					"studentImages/"
							+ getIntent().getStringExtra(IMAGE_MESSAGE));
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

		try {
			bitmap = getAssets().open(
					"flags_32px/" + getIntent().getStringExtra(FLAG_MESSAGE));
			Bitmap bit = BitmapFactory.decodeStream(bitmap);
			flagImage.setImageBitmap(bit);
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
		
		String text = "<h3><u>Brief biography</u></h3>";
		textBiography.setText(Html.fromHtml(text));
		
		webView.loadUrl(String.format(Locale.US, "file:///android_asset/www/%s.html", getIntent().getStringExtra(BIO_MESSAGE).replaceAll(".html", "")));

//		try {
//			int i = getResources().getIdentifier(
//					getIntent().getStringExtra(BIO_MESSAGE).replaceAll(".txt", ""), "raw", getPackageName());
//			InputStream is = getResources().openRawResource(i);
//
//			byte[] b = new byte[is.available()];
//			is.read(b);
//			String text = new String(b, "UTF-8");
//			
//			text = "<h3><u>Brief biography</u></h3>" + text.replaceAll("\\\n", "<br/>");
//			
//			textBiography.setText(Html.fromHtml(text));
//			
//			is.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		playButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	playSound(getIntent().getStringExtra(SOUND_MESSAGE));
            }
        });
		
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
	
	private void playSound(String soundName){
		try{
			music = new Music(getAssets().openFd("pronounces/" + soundName));
			music.play();
        } catch(Exception e){
            e.printStackTrace();
        }
	}

}
