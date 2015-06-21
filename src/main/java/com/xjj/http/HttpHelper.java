package com.xjj.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 * 封装http请求的相关方法
 * 
 * @author XuJijun
 * 
 */
public class HttpHelper {

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

	public static HttpResult doGet(String url) {
		HttpResult result = new HttpResult();
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
		request.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
		request.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.124 Safari/537.36");
		try {
			HttpResponse response = client.execute(request);
			HttpEntity entity = response.getEntity();
			result.setCode(response.getStatusLine().getStatusCode());
			if (entity != null) {
				InputStream instreams = entity.getContent();
				result.setMsg(convertStreamToString(instreams));
				if(result.getCode()!=200){
					request.abort();
				}
			}
		} catch (IOException e ) {
			e.printStackTrace();
		} finally {

		}

		return result;
	}

	public static void main(String[] args) {
		HttpResult result = doGet("http://blog.csdn.net/clementad/article/details/46491701");
		System.out.println(result.getMsg());
	}
}
