package com.tempos21.opencities.osn.bean;

import org.simpleframework.xml.Element;

/**
 * Each one of the urls pointed by a service
 *
 */
public class Resource {

	@Element
	private String url;
	
	@Element
	private String format;
	
	@Element
	private String description;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
