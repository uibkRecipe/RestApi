package RestApi;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.map.ObjectMapper;



public class RestApi {
	
	private static RestApi instance;
	
	private RestApi(){}
	
	public static RestApi getInstance(){
		if(instance == null){
			instance = new RestApi();
		}
		return instance;
	}
	public Boolean login(String username, String password){
		String test = doGet("http://138.232.65.234:8080/RestServer/rest/user/login/"
				+ username + "/" + password);
		ObjectMapper mapper = new ObjectMapper();
		Boolean o = null;
		try {
			o = mapper.readValue(test, Boolean.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}
	
	public String convertStreamToString(InputStream is) throws IOException {
		if (is != null) {
			StringBuilder sb = new StringBuilder();
			String line;
			try {
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(is, "UTF-8"));
				while ((line = reader.readLine()) != null) {
					sb.append(line).append("\n");
				}
			} finally {
				is.close();
			}
			return sb.toString();
		} else {
			return "";
		}
	}
	
	
	public String doGet(String url) {
		String result = null;
		HttpClient httpclient = new DefaultHttpClient();
		// Prepare a request object
		HttpGet httpget = new HttpGet(url);
		// Accept JSON
		httpget.addHeader("accept", "application/json");
		// Execute the request
		HttpResponse response;
		try {
			response = httpclient.execute(httpget);
			// Get the response entity
			HttpEntity entity = response.getEntity();
			// If response entity is not null
			if (entity != null) {
				// get entity contents and convert it to string
				InputStream instream = entity.getContent();
				result = convertStreamToString(instream);
				// Closing the input stream will trigger connection release
				instream.close();
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Return the json
		return result;
	}
}
