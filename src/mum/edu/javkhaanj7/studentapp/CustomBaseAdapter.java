package mum.edu.javkhaanj7.studentapp;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomBaseAdapter extends BaseAdapter {

	private Context context;
	private List<StudentInfo> rowItems;
	private Countries countries;
	private TreeMap<String, List<StudentInfo>> listsStudentbyCountry;
	private boolean isSortByCountry = false;
	private boolean isShowStudentImage = false;

	public CustomBaseAdapter(Context context, List<StudentInfo> items,
			boolean isSortByCountry, boolean isShowStudentImage) {
		this.context = context;
		this.isSortByCountry = isSortByCountry;
		this.isShowStudentImage = isShowStudentImage;
		countries = new Countries();
		try {
			if (isSortByCountry) {

				listsStudentbyCountry = new TreeMap<String, List<StudentInfo>>();

				for (int i = 0; i < items.size(); i++) {
					List<StudentInfo> listNames = new ArrayList<StudentInfo>();
					if (listsStudentbyCountry.get(((StudentInfo) items.get(i))
							.getCountry()) != null) {
						listNames = listsStudentbyCountry
								.get(((StudentInfo) items.get(i)).getCountry());
					}
					listNames.add(items.get(i));
					listsStudentbyCountry.put(
							((StudentInfo) items.get(i)).getCountry(),
							listNames);
				}

				rowItems = new ArrayList<StudentInfo>();

				for (Map.Entry<String, List<StudentInfo>> entry : listsStudentbyCountry
						.entrySet()) {
					List<StudentInfo> ls = entry.getValue();
					if (ls != null && ls.size() > 0) {
						rowItems.add(new StudentInfo("#country:" + ls.size(),
								ls.get(0).getCountry(), "null.jpg", "null.html", "null.wma"));
						for (int j = 0; j < ls.size(); j++) {
							rowItems.add(ls.get(j));
						}
					}
				}

			} else {
				rowItems = items;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* private view holder class */
	private class ViewHolder {
		ImageView imageView;
		ImageView imageStudentView;
		TextView txtNumber;
		TextView txtName;
		TextView txtCountry;
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		LayoutInflater mInflater = (LayoutInflater) context
				.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

		StudentInfo rowItem = (StudentInfo) getItem(position);

		View row = convertView;

		if (isSortByCountry) {
			if (rowItem.getName().startsWith("#country")) {
				return (getHeaderView(position, convertView, parent));
			} else {

				row = mInflater.inflate(R.layout.row_by_country, null);
				// if (row == null) {
				// row = mInflater.inflate(R.layout.row_by_country, null);
				// }

				ViewHolder holder = (ViewHolder) row.getTag();

				if (holder == null) {
					holder = new ViewHolder();

					holder.txtName = (TextView) row.findViewById(R.id.name);
					holder.imageStudentView = (ImageView) row.findViewById(R.id.studentImage);

					row.setTag(holder);
				}

				holder.txtName.setText(rowItem.getName());
				
				if(isShowStudentImage){
					InputStream bitmap = null;

					try {
						bitmap = context.getAssets().open(
								"studentImages/" + rowItem.getImageName());
						Bitmap bit = BitmapFactory.decodeStream(bitmap);
						holder.imageStudentView.setImageBitmap(bit);
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
			}
		} else {

			if (row == null) {
				row = mInflater.inflate(R.layout.row_by_name, null);
			}

			ViewHolder holder = (ViewHolder) row.getTag();

			if (holder == null) {
				holder = new ViewHolder();

				holder.txtNumber = (TextView) row.findViewById(R.id.numberList);
				holder.txtName = (TextView) row.findViewById(R.id.name);
				holder.txtCountry = (TextView) row.findViewById(R.id.country);
				holder.imageView = (ImageView) row.findViewById(R.id.flag);
				holder.imageStudentView = (ImageView) row.findViewById(R.id.studentImage);

				row.setTag(holder);
			}

			holder.txtNumber.setText((position + 1) + ".");
			holder.txtName.setText(rowItem.getName());
			holder.txtCountry.setText(rowItem.getCountry());
			
			if(isShowStudentImage){
				InputStream bitmap = null;

				try {
					bitmap = context.getAssets().open(
							"studentImages/" + rowItem.getImageName());
					Bitmap bit = BitmapFactory.decodeStream(bitmap);
					holder.imageStudentView.setImageBitmap(bit);
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

			Country country = countries.getCountryByKeyName(rowItem
					.getCountry());

			if (country != null) {
				InputStream bitmap = null;

				try {
					bitmap = context.getAssets()
							.open("flags_32px/" + country.getFlagImagePath());
					Bitmap bit = BitmapFactory.decodeStream(bitmap);
					holder.imageView.setImageBitmap(bit);
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

		return row;
	}

	private View getHeaderView(int position, View convertView, ViewGroup parent) {
		LayoutInflater mInflater = (LayoutInflater) context
				.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

		View row = convertView;

		row = mInflater.inflate(R.layout.row_by_header, null);

		// if (row == null) {
		// row = mInflater.inflate(R.layout.row_by_header, null);
		// }

		TextView txtCountry = (TextView) row.findViewById(R.id.country);
		ImageView imageView = (ImageView) row.findViewById(R.id.flag);

		StudentInfo rowItem = (StudentInfo) getItem(position);

		txtCountry.setText(rowItem.getCountry() + " -> " + rowItem.getName().split(":")[1]);

		Country country = countries.getCountryByKeyName(rowItem.getCountry());

		if (country != null) {
			InputStream bitmap = null;

			try {
				bitmap = context.getAssets().open(
						"flags_32px/" + country.getFlagImagePath());
				Bitmap bit = BitmapFactory.decodeStream(bitmap);
				imageView.setImageBitmap(bit);
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

		return (row);
	}

	@Override
	public int getCount() {
		return rowItems.size();
	}

	@Override
	public Object getItem(int position) {
		return rowItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		return rowItems.indexOf(getItem(position));
	}
}
