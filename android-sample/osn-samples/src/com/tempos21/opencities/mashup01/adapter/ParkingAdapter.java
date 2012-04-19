package com.tempos21.opencities.mashup01.adapter;

import java.util.ArrayList;

import com.tempos21.opencities.mashup01.R;
import com.tempos21.opencities.mashup01.entity.Parking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class ParkingAdapter extends ArrayAdapter<Parking> {

    private ArrayList<Parking> items;
    private Context context;

    
    public ParkingAdapter(Context context, ArrayList<Parking> items) {
        super(context, R.layout.item, items);
        this.context = context;
        this.items = items;
    }

    
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder holder;
        
        if(view == null){
        	LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item, null);
            
            holder = new ViewHolder();

            holder.id = (TextView) view.findViewById(R.id.id);
            holder.lon = (TextView) view.findViewById(R.id.lon);
            holder.lat = (TextView) view.findViewById(R.id.lat);
            holder.adr = (TextView) view.findViewById(R.id.adr);
            holder.price = (TextView) view.findViewById(R.id.price);
            
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        holder.id.setText(items.get(position).getId());
        holder.lon.setText(""+items.get(position).getLon());
        holder.lat.setText(""+items.get(position).getLat());
        holder.adr.setText(items.get(position).getAdr());
        holder.price.setText(items.get(position).getPrice());
        
        return view;
    }
    
    
    public class ViewHolder{
    	public TextView id;
    	public TextView lon;
    	public TextView lat;
    	public TextView adr;
    	public TextView price;
    }
}
