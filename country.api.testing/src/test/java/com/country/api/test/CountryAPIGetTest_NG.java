package com.country.api.test;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CountryAPIGetTest_NG extends BaseTest implements CountryAPIConstant {

	@Test
	public void testWithCorrectInput() throws ClientProtocolException, IOException, JSONException {

		
		String url = BASE_URL + HttpUtil.inputFromUser();
		HttpResponse response = HttpUtil.sendAndReceiveGET(url);
		Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);
		String responseMsg = HttpUtil.getResponseContent(response);
		System.out.println(responseMsg);
		JSONObject myResponse = new JSONObject(responseMsg.toString());
		System.out.println("Capital City for the code you entered: " + myResponse.getString("capital"));
	}

	@Test
	public void testWithInCorrectInput() throws ClientProtocolException, IOException, JSONException {

		
		String url = BASE_URL + HttpUtil.inputFromUser();
		HttpResponse response = HttpUtil.sendAndReceiveGET(url);
		Assert.assertEquals(response.getStatusLine().getStatusCode(), 400);
		String responseMsg = HttpUtil.getResponseContent(response);
		System.out.println(responseMsg);
	}

	@Test
	public void testWithInvalidInput() throws ClientProtocolException, IOException, JSONException {

		String url = BASE_URL + HttpUtil.inputFromUser();
		HttpResponse response = HttpUtil.sendAndReceiveGET(url);
		Assert.assertEquals(response.getStatusLine().getStatusCode(), 400);
		String responseMsg = HttpUtil.getResponseContent(response);
		System.out.println(responseMsg);
	}

	@Test
	public void testWithSpecialChars() throws ClientProtocolException, IOException, JSONException {

		String url = BASE_URL + HttpUtil.inputFromUser();
		HttpResponse response = HttpUtil.sendAndReceiveGET(url);
		String responseMsg = HttpUtil.getResponseContent(response);
		System.out.println(responseMsg);
	}

	@Test
	public void testWithBlankInput() throws ClientProtocolException, IOException, JSONException {

		String url = BASE_URL + HttpUtil.inputFromUser();
		HttpResponse response = HttpUtil.sendAndReceiveGET(url);
		Assert.assertEquals(response.getStatusLine().getStatusCode(), 400);
		String responseMsg = HttpUtil.getResponseContent(response);
		System.out.println(responseMsg);
	}

}
