package com.tempos21.opencities.osn.bean;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import com.google.gson.annotations.SerializedName;

@Root
public class Service {

	/**
	 * This is the unique identifier of the service, and is assigned by the OSN
	 * platform when the service is about to be created. This identifier cannot
	 * be modified once the service is created, so this identifier will be the
	 * only reference the data consumers will have. Furthermore, there can exist
	 * multiple services with the same attributes, including the name. However,
	 * never two services with the same Service ID.
	 */
	@Element
	private String id;

	@Element
	private String email;

	/**
	 * In the service name is described in a high level what the service is
	 * about. It must be avoided using technical names like: "SNF XGF23". This
	 * name gives no information to the consumers of what the service is about.
	 * An example of a good name for a temperature service would be:
	 * "BCN Temperature station 23".
	 */
	@Element
	private String name;

	@Element
	private String author;

	
	/**
	 * In the description attribute, it can be included as much information as you want about the service. However, you must avoid repeating information that it is already in other attributes of the service, for instance, the update period.

There is no length limit for this field, but think that the information contained in it must be relevant for the consumers of the service. Do not specify technical aspects of the sensor or the organization that provides the service.

An example of something that could interest the data consumers, and can be included in this field, is for how long this data or service is going to be available. If you have a sensor network that measures the state of the beaches, this might only be available during a periods of months. Because during the summer it might not make sense to send information about the state of the beaches.
	 */
	@Element
	private String description;

	/**
	 * Here is where is specified the data periodicity on the service. Remember
	 * to include the units and not only a number. E.g: 15 minutes.
	 * 
	 * If your service is based on events you can also specify this in here
	 * writing "Based on Events". In this case it is recommended to see the
	 * Twitter section.
	 */
	@SerializedName("update_period")
	@Element(name = "update_period")
	private String updatePeriod;

	/**
	 * Here is where is specified to which group a service will belong to. To
	 * ease the search by group it, there is a predefined list of group that
	 * match the most visited areas within the city council.
	 * 
	 * <ul>
	 * <li>Arts and Recreation</li>
	 * <li>Business Enterprise, Economics, and Trade</li>
	 * <li>City Budget: Revenues & Expenditures</li>
	 * <li>City Portal Web Statistics</li>
	 * <li>Construction, Housing, and Public Works</li>
	 * <li>Crime and Community Safety</li>
	 * <li>Demographics</li>
	 * <li>Education</li>
	 * <li>Election</li>
	 * <li>Emergency Services</li>
	 * <li>Energy and Utilities</li>
	 * <li>Environment, Geography and Meteorological</li>
	 * <li>Health and Disability</li>
	 * <li>Labor Force and Employment Market</li>
	 * <li>Law Enforcement, Courts, and Prisons</li>
	 * <li>Political</li>
	 * <li>Tourism</li>
	 * <li>Urban Transport</li>
	 * <li>Others</li>
	 * </ul>
	 */
	@Element
	private String group;

	/**
	 * In the URL you can specify the web page of your organization, where the
	 * consumer might find further information about the service.
	 */
	@Element
	private String url;

	/**
	 * This attributes contains the license for the provided data. A list of the
	 * most common licenses is provided, from which the Creative Commons is the
	 * recommended one according to the spirit of the project.
	 * 
	 * Due to legal reasons, once the service is created, it will not be
	 * possible to change the type of license. In case that you do not want to
	 * provide any license, select "License Not Specified".
	 * <ul>
	 * <li>Apache Software License http://www.apache.org/licenses/</li>
	 * <li>Apache License, 2.0</li>
	 * <li>Computer Associates Trusted Open Source License 1.1</li>
	 * <li>Creative Commons Attribution</li>
	 * <li>Creative Commons Share-Alike</li>
	 * <li>Creative Commons Non-Commercial (Any)</li>
	 * <li>Creative Commons CCZero</li>
	 * <li>Eclipse Public License</li>
	 * <li>GNU Free Documentation License</li>
	 * <li>GNU General Public License (GPL)</li>
	 * <li>GNU General Public License version 3.0 (GPLv3)</li>
	 * <li>MIT license</li>
	 * <li>Mozilla Public License 1.0 (MPL)</li>
	 * <li>Mozilla Public License 1.1 (MPL)</li>
	 * <li>License Not Specified</li>
	 * <li>Open Data Commons Open Database License (ODbL)</li>
	 * <li>Open Data Commons Public Domain Dedication and Licence (PDDL)</li>
	 * <li>W3C License</li>
	 * </ul>
	 */
	@Element
	private String license;

	/**
	 * The geo-localization indicates the point where the sensor is located.
	 * There is also the possibility that this value indicates the value, for
	 * example, of a road.
	 * 
	 * A single point is identified by one latitude and one longitude.
	 */
	@Element
	private String latitude;

	/**
	 * The geo-localization indicates the point where the sensor is located.
	 * There is also the possibility that this value indicates the value, for
	 * example, of a road.
	 * 
	 * A single point is identified by one latitude and one longitude.
	 */
	@Element
	private String longitude;

	/**
	 * The OSN Platform offers you the possibility of registering services
	 * adding Twitter notifications. You just need to create a new Twitter
	 * account for your service and enter into the Twitter configuration. Then
	 * create a new application and when you finish please enter into the
	 * Developers section.
	 */
	@SerializedName("twitter_account")
	@Element(name = "twitter_account")
	private String twitterAccount;

	@ElementList(inline = true)
	private List<Resource> resource;

	/**
	 * Services do not follow a hierarchical structure. Services cannot contain
	 * other services, and the way to organize the services is with tags.
	 * 
	 * Each service can contain as many tags as you want, and all of them are
	 * treated equally. However, when writing the tags you should think about
	 * the purpose of each one. We recommend to use three types of tags when
	 * registering a service:
	 * <ul>
	 * <li>Type tag: indicate the type of data the service is measuring.</li>
	 * <li>Location tag: the area where the service belongs to. You can include
	 * different tags specifying the location. For example: Spain, Catalonia,
	 * Barcelona, Poble Nou.</li>
	 * <li>Owner tag: These are suitable if you are interested that the consumer
	 * can obtain a list of the different services that you provide. If you
	 * include a tag with "Barcelona City Council", the consumers might be able
	 * to list all your services.</li>
	 */
	@ElementList(inline = true, entry = "tag")
	private List<String> tag;

	/**
	 * Extra information
	 */
	@Element
	private Extras extras;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUpdatePeriod() {
		return updatePeriod;
	}

	public void setUpdatePeriod(String updatePeriod) {
		this.updatePeriod = updatePeriod;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getTwitterAccount() {
		return twitterAccount;
	}

	public void setTwitterAccount(String twitterAccount) {
		this.twitterAccount = twitterAccount;
	}

	public List<Resource> getResource() {
		return resource;
	}

	public void setResource(List<Resource> resource) {
		this.resource = resource;
	}

	public List<String> getTag() {
		return tag;
	}

	public void setTag(List<String> tag) {
		this.tag = tag;
	}

	public Extras getExtras() {
		return extras;
	}

	public void setExtras(Extras extras) {
		this.extras = extras;
	}

}
