package com.hihuaning.javahttp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.Header;
import org.apache.http.HttpConnection;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultHttpClient;

public class HttpClientTest {
	public static void main(String[] args) throws ClientProtocolException, IOException{
		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet("http://www.baidu.com");
		HttpResponse response = client.execute(get);
		HttpEntity entity = response.getEntity();
		if(entity != null){
			//InputStream is = entity.getContent();
			//showHtml(is);
		}
		/*Header[] headers = response.getAllHeaders(); ��ȡhttp��Ӧͷ����Ϣ
		for(Header h : headers){
			System.out.println(h.getName()+" : "+h.getValue());
		}*/
		
		System.out.println();
		get.abort();
	}
	
	public static void showHtml(InputStream is) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line = null;
		while((line = br.readLine()) != null){
			System.out.println(line);
		}
	}
}
