package com.tempos21.opencities.mashup01.ui.activities;

import java.util.ArrayList;

import com.tempos21.opencities.mashup01.R;
import com.tempos21.opencities.mashup01.adapter.ParkingAdapter;
import com.tempos21.opencities.mashup01.entity.Parking;
import com.tempos21.opencities.mashup01.entity.Value;
import com.tempos21.opencities.osn.util.HttpUtil;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;


public class DataActivity extends Activity{
	
	private final static String TAG = DataActivity.class.getPackage().getName();
	private final static int CONTENT_VIEW = R.layout.data;
	private final static String OPEN_TAG = "<value><parkings>";
	private final static String CLOSE_TAG = "</parkings></value>";
	
	
	private ListView list;
	private String tags;
	private Value elements;
	private ParkingAdapter adapter;
	
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.i(TAG, this.getLocalClassName() + ": onCreate");
		
		super.onCreate(savedInstanceState);
		setContentView(CONTENT_VIEW);

		findViews();
		setData();		
	}

	/***
	 * This method is used to search all the views and widgets in the current
	 * layout. It should be a list of "findViewById" instructions.
	 */
	private void findViews() {
		Log.i(TAG, this.getLocalClassName() + ": findViews");

		list = (ListView) findViewById(R.id.listView1);
	}

	/**
	 * This method get content value, parse XML and set adapter 
	 */
	private void setData(){
		Log.i(TAG, this.getLocalClassName() + ": setData");
		
		tags = OPEN_TAG;
//		tags = tags.concat(getIntent().getExtras().get("content").toString());
		tags = tags.concat("<parking><id>3012</id><lon>2.196106911</lon><lat>41.40316118</lat><adr>Almogàvers - Llacuna, Barcelona</adr><price>COTXE: Tarifa minut: 0,036895 €, Tarifa horària: 2,22 € / H , Tarifa nit 21-9 H: 13,25 €, Tarifa tiquet 24 H: 28,75 €</price></parking><parking><id>3013</id><lon>2.1743588</lon><lat>41.411149</lat><adr>Carrer de Cartagena, 319, Barcelona</adr><price>COTXE: Tarifa minut: 0,046024 / min , Tarifa horària: 2,77 / H , Tarifa nit 21-9 H: 16,55, Tarifa tiquet 24 H: 35,90</price></parking><parking><id>3014</id><lon>2.189058065</lon><lat>41.37986776</lat><adr>Carrer del Baluard, 27, Barcelona</adr><price>COTXE: Tarifa minut: 0,046024 / min , Tarifa horària: 2,77 / H , Tarifa nit 21-9 H: 16,55, Tarifa tiquet 24 H: 35,90</price></parking><parking><id>3015</id><lon>2.204671</lon><lat>41.4020498</lat><adr>Carrer Bilbao ,24s, Barcelona</adr><price>COTXE: Tarifa minut: 0,046024 / min , Tarifa horària: 2,77 / H , Tarifa nit 21-9 H: 16,55, Tarifa tiquet 24 H: 35,90</price></parking><parking><id>3016</id><lon>2.1254493</lon><lat>41.3978877</lat><adr>Cardenal Sentmenat 8, Barcelona</adr><price>COTXE: Tarifa minut: 0,046024 / min , Tarifa horària: 2,77 / H , Tarifa nit 21-9 H: 16,55, Tarifa tiquet 24 H: 35,90</price></parking>");
		tags = tags.concat(CLOSE_TAG);
		
		try {
			elements = HttpUtil.parseXML(Value.class, tags);
			setAdapter();
		} catch (Exception e) {
			showAlertDialog(R.string.error_title, e.toString());
		}
	}
	
	/**
	 * This method configure Adapter for setting parsed values
	 */
	private void setAdapter(){
		Log.i(TAG, this.getLocalClassName() + ": setAdapter");
		
		adapter = new ParkingAdapter(this, (ArrayList<Parking>) elements.getParkings());
		list.setAdapter(adapter);
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
}

