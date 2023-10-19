package com.kh.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class practice2 {
	
	public static final String serviceKey = "6eKt47nwk1LQ1ZnZa3PvX39sHM1UuX5SYAmOyaIMYeZoK1%2F%2FMd1nulFnEcOGOVmCEZKwcm203fM0l%2BhfIXBJSA%3D%3D"; 
	
	public static void main(String[] args) throws IOException {

		String url = "http://apis.data.go.kr/1741000/TsunamiShelter3/getTsunamiShelter1List​";
		url += "?serviceKey=" +  serviceKey;
		url += "&numOfRows=2";
		
		URL requestUrl = new URL(url);
		HttpURLConnection urlConnection = (HttpURLConnection) requestUrl.openConnection();
		urlConnection.setRequestMethod("GET");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		String line = null;
		StringBuffer responseBuffer = new StringBuffer();
		
		while((line = br.readLine()) != null) {
			System.out.println(line);
//			responseBuffer.append(line);
		}
		br.close();
		urlConnection.disconnect();
	}

}
