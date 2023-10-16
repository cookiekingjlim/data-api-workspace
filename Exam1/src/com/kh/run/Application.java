package com.kh.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class Application {
	
	// serviceKey 값
	public static final String serviceKey = "6eKt47nwk1LQ1ZnZa3PvX39sHM1UuX5SYAmOyaIMYeZoK1%2F%2FMd1nulFnEcOGOVmCEZKwcm203fM0l%2BhfIXBJSA%3D%3D";
	
	public static void main(String[] args) throws IOException {
		//URL
		String url = "https://apis.data.go.kr/1543061/animalShelterSrvc/shelterInfo";
	
		
		url += "?serviceKey=" + serviceKey;	// 파라미터값 받아올 때 무조건 ?부터니까
		url += "&numOfRows=5";	// 한 페이지 결과 수
		url += "&_type=json";	// 기본값: xml -> json방식으로 지정
		
		URL requestUrl = new URL(url);
		HttpURLConnection urlConnection = (HttpURLConnection) requestUrl.openConnection();
		urlConnection.setRequestMethod("GET");	// 지금 GET방식으로 가지고 오고 있으므로
		
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		String line = null;
		
		StringBuffer responseBuffer = new StringBuffer();
		
		while((line = br.readLine()) != null) {	// br에 있는 거 한 줄씩 읽어와서 null이 아닐 때까지
//			System.out.println(line);
			responseBuffer.append(line);
		}
		br.close();
		urlConnection.disconnect();
		
		// JSON  파싱 시작!
		String responseData = responseBuffer.toString();
		JSONObject jsonResponse = new JSONObject(responseData);
		
		// JSON 구조 파악
		JSONObject response = jsonResponse.getJSONObject("response");
		JSONObject body = response.getJSONObject("body");	// body에 접근하겠다.
		JSONObject items = body.getJSONObject("items");
		JSONArray item = items.getJSONArray("item");
		
		System.out.println(item);
		
		for(int i = 0; i<item.length(); i++) {
			JSONObject result = item.getJSONObject(i);
//			System.out.println(result);
			
			String careNm = result.getString("careNm");
			String careAddr = result.getString("careAddr");
			System.out.println("동물보호센터명 : "  +  careNm);
			System.out.println("주소 : "  +  careAddr);
			
		}
		
		}





}


















