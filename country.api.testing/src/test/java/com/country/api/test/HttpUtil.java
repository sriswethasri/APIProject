package com.country.api.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpUtil {
	
	private static Scanner sc;

	public static String inputFromUser() {
		sc = new Scanner(System.in);
		System.out.println("Enter 2 or 3 letter code of country for capital city :");
		String code = sc.nextLine();
		return code;	
	}
	
	public static String getResponseContent(HttpResponse response) throws IOException {
		BufferedReader br = new BufferedReader(
		          new InputStreamReader((response.getEntity().getContent())));
			
		
		  StringBuffer result = new StringBuffer();
		  String line = " ";	
		  while ((line = br.readLine()) != null) {
			  result.append(line);
		  }
		  return result.toString();
	}

	public static HttpResponse sendAndReceiveGET(String url) throws IOException, ClientProtocolException {
		// create client
		HttpClient client = HttpClientBuilder.create().build();
		//define request message
		HttpGet request = new HttpGet(url);
		//send and receive the response 
		HttpResponse response = client.execute(request);
		// validate the response			
		return response;
	}


}
