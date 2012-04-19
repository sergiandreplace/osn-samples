package com.tempos21.opencities.mashup01.ui.activities;

import java.io.IOException;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.tempos21.opencities.mashup01.R;
import com.tempos21.opencities.osn.bean.ServiceContainer;
import com.tempos21.opencities.osn.util.HttpUtil;

public class MetadataActivity extends Activity {
	private final static String TAG = MainActivity.class.getPackage().getName();

	private final static int CONTENT_VIEW = R.layout.metadata;

	private static final int PROGRESS_DIALOG = 1;
	private static final int ERROR_DIALOG = 2;
	private ProgressDialog progressDialog;

	private final static String URL = "http://193.145.50.132:8080/OSN/rest/service/getService/1324402390199000.json";

	private TextView tvName;
	private TextView tvAuthor;
	private TextView tvDescription;
	private TextView tvUpdatePeriod;
	private TextView tvGroup;
	private TextView tvTags;
	private TextView tvId;
	private TextView tvUrl;
	private TextView tvLicense;
	private TextView tvLongitude;
	private TextView tvLatitude;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.i(TAG, this.getLocalClassName() + ": onCreate");
		super.onCreate(savedInstanceState);
		setContentView(CONTENT_VIEW);

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
		tvName = (TextView) findViewById(R.id.name);
		tvAuthor = (TextView) findViewById(R.id.author);
		tvDescription = (TextView) findViewById(R.id.description);
		tvUpdatePeriod = (TextView) findViewById(R.id.update_period);
		tvGroup = (TextView) findViewById(R.id.group);
		tvTags = (TextView) findViewById(R.id.tags);
		tvId = (TextView) findViewById(R.id.idService);
		tvUrl = (TextView) findViewById(R.id.url);
		tvLicense = (TextView) findViewById(R.id.license);
		tvLongitude = (TextView) findViewById(R.id.longitude);
		tvLatitude = (TextView) findViewById(R.id.latitude);
	}

	/***
	 * Here we establish all the listeners used in the dialog based on views
	 * (not based in async classes). It should be a list of "setOn...listener"
	 * instructions.
	 */
	private void setListeners() {
		Log.i(TAG, this.getLocalClassName() + ": setListeners");
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

	private class DownloadDataTask extends
			AsyncTask<Void, Void, ServiceContainer> {

		@Override
		protected void onPreExecute() {
			showDialog(PROGRESS_DIALOG);
		}

		@Override
		protected void onCancelled() {
			super.onCancelled();
			if (progressDialog != null && progressDialog.isShowing()) {
				progressDialog.dismiss();
			}
		}

		@Override
		protected ServiceContainer doInBackground(Void... paramArrayOfParams) {
			ServiceContainer sc = null;
			try {
				sc = HttpUtil.downloadJSON(ServiceContainer.class, URL);
			} catch (IllegalStateException e) {
				Log.e(TAG, e.getMessage());
				e.printStackTrace();
			} catch (IOException e) {
				Log.e(TAG, e.getMessage());
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return sc;
		}

		@Override
		protected void onPostExecute(ServiceContainer result) {
			setData(result);
			if (progressDialog != null && progressDialog.isShowing()) {
				progressDialog.dismiss();
			}
		}

	}

	/**
	 * @param id
	 * 
	 * @return Dialog que mostramos
	 */
	@Override
	protected Dialog onCreateDialog(int id) {
		Dialog dialog = null;
		switch (id) {
		case PROGRESS_DIALOG:
			progressDialog = ProgressDialog.show(this,
					getString(R.string.loading_title),
					getString(R.string.loading_metadata));
			dialog = progressDialog;
			break;
		case ERROR_DIALOG:
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle(android.R.string.dialog_alert_title);
			builder.setMessage(R.string.loading_metadata_error);
			builder.setIcon(android.R.drawable.ic_dialog_alert);
			builder.setPositiveButton(android.R.string.ok,
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int whichButton) {
							dialog.cancel();
						}
					});
			dialog = builder.create();
			dialog.show();
			break;
		}
		return dialog;
	}

	/***
	 * This method is called to setData in screen once the data is retrieved. If
	 * data retrieval is sync, it should be called from onCreate. If data
	 * retrieval is async, it should be called on asynctask finished.
	 */
	private void setData(ServiceContainer sc) {
		Log.i(TAG, this.getLocalClassName() + ": setData");
		if (sc != null && sc.getService() != null) {
			tvName.setText(sc.getService().getName());
			tvAuthor.setText(sc.getService().getAuthor());
			tvDescription.setText(sc.getService().getDescription());
			tvUpdatePeriod.setText(sc.getService().getUpdatePeriod());
			tvGroup.setText(sc.getService().getGroup());
			tvId.setText(sc.getService().getId());
			tvUrl.setText(sc.getService().getUrl());
			tvLicense.setText(sc.getService().getLicense());
			tvLongitude.setText(sc.getService().getLongitude());
			tvLatitude.setText(sc.getService().getLatitude());
			List<String> tags = sc.getService().getTag();
			StringBuffer tagsLabel = new StringBuffer();
			for (String tag : tags) {
				tagsLabel.append(tag);
				tagsLabel.append(", ");
			}
			if (tagsLabel.length() > 0) {
				String result = tagsLabel.toString();
				tvTags.setText(result.substring(0, result.length() - 2));
			}

		} else {
			showDialog(ERROR_DIALOG);
		}
	}
}
