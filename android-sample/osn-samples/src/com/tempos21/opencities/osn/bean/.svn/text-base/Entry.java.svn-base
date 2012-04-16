package com.tempos21.opencities.osn.bean;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * This class represents the output of an OSN service
 * 
 * 
 * 
 * @author Tempos 21
 * 
 */
@Root
public class Entry {

	/**
	 * Id of the service
	 */
	@Element
	private String id;

	/**
	 * Specify from where the data comes from
	 */
	@Element
	private String source_id;

	/**
	 * When the data was collected
	 */
	@Element
	private String date;

	/**
	 * content of the entry. A simple value can only consist of a string without
	 * structure. For instance, a temperature service with just one value.
	 * Complex values contain structured data of multiple information sources.
	 * For example, a service that gives information about the motorway cameras.
	 * In the value field is indicated all the information of the cameras of the
	 * motorway in a xml structure.
	 */
	@Element
	private String value;

	/**
	 * Units of the value
	 */
	@Element
	private String unit;

	/**
	 * Additional information that might be useful and that it's not in the
	 * value field
	 */
	@Element
	private String extra_info;

	@Element
	private double latitude;

	@Element
	private double longitude;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSource_id() {
		return source_id;
	}

	public void setSource_id(String source_id) {
		this.source_id = source_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getExtra_info() {
		return extra_info;
	}

	public void setExtra_info(String extra_info) {
		this.extra_info = extra_info;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

}
