package com.tempos21.opencities.mashup01.ui.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.tempos21.opencities.mashup01.R;
import com.tempos21.opencities.osn.bean.Entry;
import com.tempos21.opencities.osn.util.HttpUtil;

public class OpendataActivity extends Activity implements OnClickListener {
	private final static String TAG = OpendataActivity.class.getPackage()
			.getName();
	private final static int CONTENT_VIEW = R.layout.open_data;
	private final static String URL = "http://193.145.50.132:8080/OSN/rest/service/getLastEntry/1324402390199000.xml";

	private ProgressDialog progressDialog;
	private Context context;
	private String contentValue;

	private TextView id;
	private TextView source_id;
	private TextView date;
	private TextView value;
	private TextView unit;
	private TextView extra_info;
	private TextView latitude;
	private TextView longitude;
	private Button show;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.i(TAG, this.getLocalClassName() + ": onCreate");

		super.onCreate(savedInstanceState);
		setContentView(CONTENT_VIEW);

		context = this;

		findViews();
		setListeners();

		getData();
	}

	/***
	 * This method is used to search all the views and widgets in the current
	 * layout. It should be a list of "findViewById" instructions.
	 */
	private void findViews() {
		Log.i(TAG, this.getLocalClassName() + ": findViews");

		id = (TextView) findViewById(R.id.id);
		source_id = (TextView) findViewById(R.id.source_id);
		date = (TextView) findViewById(R.id.date);
		value = (TextView) findViewById(R.id.value);
		show = (Button) findViewById(R.id.show);
		unit = (TextView) findViewById(R.id.unit);
		extra_info = (TextView) findViewById(R.id.extra_info);
		latitude = (TextView) findViewById(R.id.latitude);
		longitude = (TextView) findViewById(R.id.longitude);
	}

	/**
	 * This method is used to set Listeners for all components are needed
	 */
	private void setListeners() {
		Log.i(TAG, this.getLocalClassName() + ": setListeners");

		show.setOnClickListener(this);
	}

	/***
	 * Used to retrieve the data to be shown in the layout. It could call sync
	 * or async methods;
	 */
	public void getData() {
		Log.i(TAG, this.getLocalClassName() + ": getData");
		DownloadDataTask task = new DownloadDataTask();
		task.execute();
	}

	/**
	 * This class create an asynchronous task to download, parse and show info
	 * 
	 * @author A519130
	 * 
	 */
	private class DownloadDataTask extends AsyncTask<Void, Void, Entry> {

		@Override
		protected void onPreExecute() {
			Log.i(TAG, "onPreExecute");

			progressDialog = ProgressDialog.show(context,
					getString(R.string.loading_title),
					getString(R.string.loading_opendata));
		}

		/**
		 * This method download XML given an URL and parse this XML to get and
		 * specific object. In this case the object used is an Entry In case of
		 * throw an Exception, it`s captured and showing in a pop-up
		 */
		@Override
		protected Entry doInBackground(Void... paramArrayOfParams) {
			Log.i(TAG, "doInBackground");

			Entry entry = null;
			try {
				entry = HttpUtil.downloadXML(Entry.class, URL);
			} catch (Exception e) {
				showAlertDialog(R.string.error_title, e.toString());
			}
			return entry;
		}

		@Override
		protected void onPostExecute(Entry result) {
			Log.i(TAG, "onPostExecute");

			setData(result);
			contentValue = result.getValue();

			if (progressDialog != null && progressDialog.isShowing()) {
				progressDialog.dismiss();
			}
		}
	}

	/***
	 * This method is called to setData in screen once the data is retrieved. If
	 * data retrieval is sync, it should be called from onCreate. If data
	 * retrieval is async, it should be called on asynctask finished.
	 */
	private void setData(Entry entry) {
		Log.i(TAG, this.getLocalClassName() + ": setViews");

		id.setText(entry.getId());
		source_id.setText(entry.getSource_id());
		date.setText(entry.getDate());
		value.setText(getResources().getString(R.string.values));
		unit.setText(entry.getUnit());
		extra_info.setText(entry.getExtra_info());
		latitude.setText(String.valueOf(entry.getLatitude()));
		longitude.setText(String.valueOf(entry.getLongitude()));
	}

	/**
	 * This method show an Alert Dialog with an specific error ocurred
	 * 
	 * @param title
	 *            Title of error
	 * @param message
	 *            Body with an error content
	 * 
	 */
	private void showAlertDialog(int title, String message) {
		Log.i(TAG, this.getLocalClassName() + ": showAlert");

		final AlertDialog.Builder dialog = new Builder(this);
		dialog.setTitle(title);
		dialog.setMessage(message);
		dialog.setPositiveButton(R.string.btt_ok,
				new android.content.DialogInterface.OnClickListener() {

					public void onClick(DialogInterface arg0, int arg1) {
						((DialogInterface) dialog).dismiss();
					}
				});

		dialog.show();
	}

	public void onClick(View v) {
		Log.i(TAG, this.getLocalClassName() + ": onClick");

		Intent intent = new Intent(this, DataActivity.class);
		intent.putExtra("content", contentValue);
		startActivity(intent);
	}
}
