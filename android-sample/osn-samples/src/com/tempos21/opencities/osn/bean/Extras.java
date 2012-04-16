package com.tempos21.opencities.osn.bean;

import org.simpleframework.xml.Element;

import com.google.gson.annotations.SerializedName;

/**
 * Extra information contained in the service
 *
 */
public class Extras {

	@Element
	private String geographical_coverage;

	@Element
	private String geographical_granularity;

	@SerializedName("temporal_coverage-from")
	@Element(name="temporal_coverage-from")
	private String temporal_coverage_from;

	@SerializedName("temporal_coverage-to")
	@Element(name="temporal_coverage-to")
	private String temporal_coverage_to;

	@Element
	private String temporal_granularity;

	@Element
	private String date_released;

	@Element
	private String date_updated;

	public String getGeographical_coverage() {
		return geographical_coverage;
	}

	public void setGeographical_coverage(String geographical_coverage) {
		this.geographical_coverage = geographical_coverage;
	}

	public String getGeographical_granularity() {
		return geographical_granularity;
	}

	public void setGeographical_granularity(String geographical_granularity) {
		this.geographical_granularity = geographical_granularity;
	}

	public String getTemporal_coverage_from() {
		return temporal_coverage_from;
	}

	public void setTemporal_coverage_from(String temporal_coverage_from) {
		this.temporal_coverage_from = temporal_coverage_from;
	}

	public String getTemporal_coverage_to() {
		return temporal_coverage_to;
	}

	public void setTemporal_coverage_to(String temporal_coverage_to) {
		this.temporal_coverage_to = temporal_coverage_to;
	}

	public String getTemporal_granularity() {
		return temporal_granularity;
	}

	public void setTemporal_granularity(String temporal_granularity) {
		this.temporal_granularity = temporal_granularity;
	}

	public String getDate_released() {
		return date_released;
	}

	public void setDate_released(String date_released) {
		this.date_released = date_released;
	}

	public String getDate_updated() {
		return date_updated;
	}

	public void setDate_updated(String date_updated) {
		this.date_updated = date_updated;
	}
}
