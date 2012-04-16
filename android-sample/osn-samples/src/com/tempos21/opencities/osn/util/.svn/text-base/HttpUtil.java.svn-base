package com.tempos21.opencities.osn.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import com.google.gson.Gson;

public class HttpUtil {

	/**
	 * Instantiates an httpClient and configures it
	 * @return a new Http Client
	 */
	public static DefaultHttpClient getNewHttpClient() {

		HttpParams httpParameters = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(httpParameters, 30000);
		HttpConnectionParams.setSoTimeout(httpParameters, 10000);
		HttpConnectionParams.setStaleCheckingEnabled(httpParameters, false);
		return new DefaultHttpClient(httpParameters);
	}

	/**
	 * Downloads the response from an url as plain text
	 * 
	 * @param url
	 *            String containing a url to download
	 * @return the response from the url in a String
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public static String downloadString(String url)
			throws IllegalStateException, IOException {
		DefaultHttpClient httpclient = getNewHttpClient();

		// Prepare a request object
		HttpGet httpmethod = new HttpGet(url);

		// Execute the request
		HttpResponse response;

		response = httpclient.execute(httpmethod);
		HttpEntity entity = response.getEntity();

		BufferedReader br = new BufferedReader(new InputStreamReader(
				entity.getContent()));
		StringBuilder result = new StringBuilder();
		String readLine;
		while (((readLine = br.readLine()) != null)) {
			result.append(readLine);
		}
		br.close();
		return result.toString();
	}

	/**
	 * Downloads the content from an url that returns a json and deserializes
	 * into an object
	 * 
	 * @param c
	 *            Class to deserealize the json into
	 * @param url
	 *            Url that returns the json content
	 * @return an object with json deserialized
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public static <T> T downloadJSON(Class<T> c, String url)
			throws IllegalStateException, IOException {
		// get service info parkings JSON
		String json = downloadString(url);
		return parseJSON(c, json);
	}

	/**
	 * Parses a string containing an json file
	 * 
	 * @param c The class to be used to deserialize the json
	 * @return an instance object of Class T with the json data deserialized
	 */
	public static <T> T parseJSON(Class<T> c, String json) {
		Gson gson = new Gson();
		T result = gson.fromJson(json, c);
		return result;
	}
	
	/**
	 * Downloads the content from an url that returns a xml and deserializes
	 * into an object
	 * 
	 * @param c
	 *            Class to deserealize the xml into
	 * @param url
	 *            Url that returns the xml content
	 * @return an object with xml deserialized
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public static <T> T downloadXML(Class<T> c, String url) throws Exception{
		String xml = downloadString(url);
		T result = parseXML(c, xml);
		
		return result;
	}
	
	/**
	 * Parses a string containing an xml file
	 * 
	 * @param c
	 *            The class to be used to deserialize the xml
	 * @param xml
	 *            String containing an xml
	 * @return an instance object of Class T with the xml data deserialized
	 */
	public static <T> T parseXML(Class<T> c, String xml) throws Exception{
		Serializer serializer = new Persister();
		T entry = serializer.read(c, xml);
		
		return entry;
	}
}
