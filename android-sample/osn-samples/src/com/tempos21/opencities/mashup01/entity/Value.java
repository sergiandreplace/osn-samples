package com.tempos21.opencities.mashup01.entity;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;


@Root
public class Value {
	
	@ElementList
	private ArrayList<Parking> parkings;

   
	public List<Parking> getParkings() {
		return parkings;
	}
	
	public void setParkings(ArrayList<Parking> parkings) {
		this.parkings = parkings;
	}

}
