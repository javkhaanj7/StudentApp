package mum.edu.javkhaanj7.studentapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.SearchView;

public class MainActivity extends Activity implements OnItemClickListener,
		SearchView.OnQueryTextListener {

	private ListView listView;
	private List<StudentInfo> rowItems;
	private boolean isSortByCountry = false;
	private boolean isShowStudentImage = false;
	private Countries countries;
	private SearchView mSearchView;
	private MenuItem searchItem;

	public static final StudentInfo[] items = {
			new StudentInfo("Abdel Hamed", "Egypt", "abdelhamed.jpg",
					"abdelhamed.html", "abdelhamed.wma"),
			new StudentInfo("Abiy", "Eritrea", "abiy.jpg", "abiy.html",
					"abiy.wma"),
			new StudentInfo("Andrei", "Republic of Moldova", "andrei.jpg",
					"andrei.html", "andrei.wma"),
			new StudentInfo("Arsenii", "Russian Federation", "arsenii.jpg",
					"arsenii.html", "arsenii.wma"),
			new StudentInfo("Batbaatar", "Mongolia", "batbaatar.jpg",
					"batbaatar.html", "batbaatar.wma"),
			new StudentInfo("Bussarakam", "Thailand", "bussarakam.jpg",
					"bussarakam.html", "bussarakam.wma"),
			new StudentInfo("Debay", "Eritrea", "debay.jpg", "debay.html",
					"debay.wma"),
			new StudentInfo("Dedi", "Indonezia", "dedi.jpg", "dedi.html",
					"dedi.wma"),
			new StudentInfo("Dina", "Palestine, West Bank", "dina.jpg",
					"dina.html", "dina.wma"),
			new StudentInfo("Everardo", "Mexico", "everardo.jpg",
					"everardo.html", "everardo.wma"),
			new StudentInfo("Gerges", "Egypt", "gerges.jpg", "gerges.html",
					"gerges.wma"),
			new StudentInfo("Izzeddin", "Jordan", "izeddin.jpg",
					"izeddin.html", "izeddin.wma"),
			new StudentInfo("Javkhlantugs", "Mongolia", "javkhlantugs.jpg",
					"javkhlantugs.html", "javkhlantugs.wma"),
			new StudentInfo("Jianfeng", "China", "jianfeng.jpg",
					"jianfeng.html", "jianfeng.wma"),
			new StudentInfo("Kinfu", "Ethiopia", "kinfu.jpg", "kinfu.html",
					"kinfu.wma"),
			new StudentInfo("Marco", "Italy", "marco.jpg", "marco.html",
					"marco.wma"),
			new StudentInfo("Marites", "Philippines", "marites.jpg",
					"marites.html", "marites.wma"),
			new StudentInfo("Ralph", "United States of America (USA)",
					"ralph.jpg", "ralph.html", "ralph.wma"),
			new StudentInfo("Samuel", "Eritrea", "samuel.jpg", "samuel.html",
					"samuel.wma"),
			new StudentInfo("Sereyroath", "Cambodia", "sereyroath.jpg",
					"sereyroath.html", "sereyroath.wma"),
			new StudentInfo("Shadi", "Egypt", "shadi.jpg", "shadi.html",
					"shadi.wma"),
			new StudentInfo("Wimonrat", "Thailand", "wimonrat.jpg",
					"wimonrat.html", "wimonrat.wma"),
			new StudentInfo("Yared", "Ethiopia", "yared.jpg", "yared.html",
					"yared.wma"),
			new StudentInfo("Zahra", "Iran", "zahra.jpg", "zahra.html",
					"zahra.wma"),
			new StudentInfo("Zhaoliang", "China", "zhaoliang.jpg",
					"zhaoliang.html", "zhaoliang.wma"),
			new StudentInfo("Zheng", "China", "zheng.jpg", "zheng.html",
					"zheng.wma") };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		listView = (ListView) findViewById(R.id.studentList);

		countries = new Countries();

		listView.setOnItemClickListener(this);
	}

	@Override
	protected void onResume() {

		SharedPreferences sp = this.getSharedPreferences("sortPreferences",
				MODE_PRIVATE);
		String sortByName = sp.getString("sortByName", "yes");
		String showImageOnList = sp.getString("showImageOnList", "no");

		if (sortByName.equals("yes")) {
			isSortByCountry = false;
		} else {
			isSortByCountry = true;
		}

		if (showImageOnList.equals("yes")) {
			isShowStudentImage = true;
		} else {
			isShowStudentImage = false;
		}

		if (searchItem != null)
			searchItem.collapseActionView();
		
		doRefreshList();

		setupList(rowItems);

		super.onResume();
	}

	private void doRefreshList(){
		rowItems = new ArrayList<StudentInfo>();

		for (int i = 0; i < items.length; i++) {
			rowItems.add(items[i]);
		}		
	}
	
	private void doSearchList(String searchValue){
		
		rowItems = new ArrayList<StudentInfo>();

		for (int i = 0; i < items.length; i++) {
			StudentInfo si = items[i];
			if(si.getName().toLowerCase(Locale.US).contains(searchValue.toLowerCase(Locale.US))
					|| si.getCountry().toLowerCase(Locale.US).contains(searchValue.toLowerCase(Locale.US))){
				rowItems.add(items[i]);
			}
		}
		
		setupList(rowItems);
	}
	
	private void setupList(List<StudentInfo> listI) {
		CustomBaseAdapter adapter = new CustomBaseAdapter(this, listI,
				isSortByCountry, isShowStudentImage);
		listView.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		getMenuInflater().inflate(R.menu.learn_name, menu);

		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.searchview_in_menu, menu);
		searchItem = menu.findItem(R.id.action_search);
		mSearchView = (SearchView) searchItem.getActionView();
		setupSearchView(searchItem);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_settings:
			startActivity(new Intent(this, Settings.class));
			return true;
		case R.id.action_learn_name:
			if(items != null && items.length > 0){
				startActivity(new Intent(this, LearnNames.class));
			}				
			else{
				showToast("List empty!");
			}
				
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		CustomBaseAdapter ic = (CustomBaseAdapter) parent.getAdapter();

		if (!((StudentInfo) ic.getItem(position)).getName().startsWith(
				"#country")) {
			Intent other = new Intent(this, Biography.class);

			other.putExtra(Biography.NAME_MESSAGE,
					((StudentInfo) ic.getItem(position)).getName());
			other.putExtra(Biography.COUNTRY_MESSAGE,
					((StudentInfo) ic.getItem(position)).getCountry());
			other.putExtra(Biography.IMAGE_MESSAGE,
					((StudentInfo) ic.getItem(position)).getImageName());

			Country country = countries.getCountryByKeyName(((StudentInfo) ic
					.getItem(position)).getCountry());

			other.putExtra(Biography.FLAG_MESSAGE, country.getFlagImagePath());
			other.putExtra(Biography.BIO_MESSAGE,
					((StudentInfo) ic.getItem(position)).getBioPath());
			other.putExtra(Biography.SOUND_MESSAGE,
					((StudentInfo) ic.getItem(position)).getSoundPath());

			startActivity(other);
		} else {
			showToast(((StudentInfo) ic.getItem(position)).getCountry());
		}

	}

	protected boolean isAlwaysExpanded() {
		return false;
	}

	private void setupSearchView(MenuItem searchItem) {

		if (isAlwaysExpanded()) {
			mSearchView.setIconifiedByDefault(false);
		} else {
			searchItem.setShowAsActionFlags(MenuItem.SHOW_AS_ACTION_IF_ROOM
					| MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW);
		}

		mSearchView.setQueryHint(getString(R.string.search_hint));

		// SearchManager searchManager = (SearchManager)
		// getSystemService(Context.SEARCH_SERVICE);
		// if (searchManager != null) {
		// List<SearchableInfo> searchables = searchManager
		// .getSearchablesInGlobalSearch();
		//
		// SearchableInfo info = searchManager
		// .getSearchableInfo(getComponentName());
		// for (SearchableInfo inf : searchables) {
		// if (inf.getSuggestAuthority() != null
		// && inf.getSuggestAuthority().startsWith("applications")) {
		// info = inf;
		// }
		// }
		// mSearchView.setSearchableInfo(info);
		// }

		mSearchView.setOnQueryTextListener(this);
	}

	private void showToast(String text) {
		Toast toast = Toast.makeText(getApplicationContext(), text,
				Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
		toast.show();
	}

	@Override
	public boolean onQueryTextChange(String arg0) {
		// TODO Auto-generated method stub
		//showToast("Query = " + arg0);
		doSearchList(arg0);
		return false;
	}

	@Override
	public boolean onQueryTextSubmit(String arg0) {
		// TODO Auto-generated method stub
		//showToast("Query = " + arg0 + " : submitted");
		return false;
	}
}
