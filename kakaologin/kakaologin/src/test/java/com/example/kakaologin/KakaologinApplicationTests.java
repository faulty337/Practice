package com.example.kakaologin;

import java.io.BufferedReader;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.json.JSONException;
import org.json.JSONObject;

@SpringBootTest
class KakaologinApplicationTests {
	BufferedReader in = null;
	@Test
	void contextLoads() {
		try{
			Map<String, Object> data = new HashMap<>();
			data.put("grant_type", "authorization_code");
			data.put("client_id", "ii");
			data.put("redirect_uri", "rr");
			data.put("code", "cc");
			// StringBuilder postData = new StringBuilder();
			// for(Map.Entry<String, Object> params: data.entrySet()) {
			// 	if(postData.length() != 0) postData.append("&");
			// 	postData.append(URLEncoder.encode(params.getKey(), "UTF-8"));
			// 	postData.append("=");
			// 	postData.append(URLEncoder.encode(String.valueOf(params.getValue()), "UTF-8"));
					
			// }
			// System.out.println(postData.toString());
			String postData = getJsonStringFromMap(data);
			System.out.println(postData);
		}catch (Exception e){
			System.out.print(e);
		}
	}

	public static String getJsonStringFromMap(Map<String, Object> map) {
    
		JSONObject json = new JSONObject();
		
		for(Map.Entry<String, Object> entry : map.entrySet()) {
			
			String key = entry.getKey();
            Object value = entry.getValue();
            try{
				json.put(key, value);
			}catch(JSONException e){
				System.out.println(e);
			}
            
        }
        
        return json.toString();
	}

}
