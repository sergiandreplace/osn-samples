package com.tempos21.opencities.mashup01.ui.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.tempos21.opencities.mashup01.R;

public class MainActivity extends Activity {

	private final static String TAG = MainActivity.class.getPackage().getName();

	private final static int CONTENT_VIEW = R.layout.main;

	private Button btnMetadata;
	private Button btnOpendata;

	private Context context;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.i(TAG, this.getLocalClassName() + ": onCreate");
		super.onCreate(savedInstanceState);
		setContentView(CONTENT_VIEW);

		context = this;

		findViews();
		setListeners();
	}

	/***
	 * This method is used to search all the views and widgets in the current
	 * layout. It should be a list of "findViewById" instructions.
	 */
	private void findViews() {
		Log.i(TAG, this.getLocalClassName() + ": findViews");

		btnMetadata = (Button) findViewById(R.id.btnMetadata);
		btnOpendata = (Button) findViewById(R.id.btnOpendata);
	}

	/***
	 * Here we establish all the listeners used in the dialog based on views
	 * (not based in async classes). It should be a list of "setOn...listener"
	 * instructions.
	 */
	private void setListeners() {
		Log.i(TAG, this.getLocalClassName() + ": setListeners");

		btnMetadata.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent i = new Intent(context, MetadataActivity.class);
				startActivity(i);
			}
		});

		btnOpendata.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent intent = new Intent(context, OpendataActivity.class);
				startActivity(intent);
			}
		});
	}
}