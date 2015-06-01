package com.xjj.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

public class CibaApi {
	private String url = "http://open.iciba.com/dsapi";

	@Test
	public void HttpRequest() {
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
		try {
			HttpResponse response = client.execute(request);
			HttpEntity entity = response.getEntity();  
			 if (entity != null) {    
		            InputStream instreams = entity.getContent();    
		            String str = convertStreamToString(instreams);  
		            System.out.println("Do something");   
		            System.out.println(str);  
		            // Do not need the rest    
		            request.abort();    
		        }  
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void UrlRequest() {
		try {
			URL requestUrl = new URL(url);
			URLConnection con = requestUrl.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			StringBuilder sb = new StringBuilder();
			int cp;

			while ((cp = in.read()) != -1) {
				sb.append((char) cp);
			}
			String json = sb.toString();
			//System.out.println(json);
			
			ObjectMapper objectMapper = new ObjectMapper();
			CibaPojo ciba = objectMapper.readValue(json, CibaPojo.class);
			System.out.println(ciba.getNote() + ciba.getContent());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static String convertStreamToString(InputStream is) {      
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));      
        StringBuilder sb = new StringBuilder();      
       
        String line = null;      
        try {      
            while ((line = reader.readLine()) != null) {  
                sb.append(line + "\n");      
            }      
        } catch (IOException e) {      
            e.printStackTrace();      
        } finally {      
            try {      
                is.close();      
            } catch (IOException e) {      
               e.printStackTrace();      
            }      
        }      
        return sb.toString();      
    }  
}
