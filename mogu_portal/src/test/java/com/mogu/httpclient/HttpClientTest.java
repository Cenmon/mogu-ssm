package com.mogu.httpclient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sound.midi.Soundbank;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taotao.pojo.TbContent;

import taotao_utils.HttpClientUtil;

public class HttpClientTest {
	
//	@Test
	public void doGet() throws Exception{
		// 创建一个httpclient对象，closeableHttpable是一个抽象类，类似于创建一个浏览器对象，模拟浏览器
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 创建一个get对象
		HttpGet get = new HttpGet("http://localhost:8081/rest/itemcat/list?callback=func");
		//执行请求
		CloseableHttpResponse response = httpClient.execute(get);
		//取相应结果
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		HttpEntity entity = response.getEntity();
		String string = EntityUtils.toString(entity,"utf-8");
		System.out.println(string);
		//关闭httpclient
		response.close();
		httpClient.close();
	}
	
//	@Test
	public void doGetWithParams() throws Exception{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		//添加参数,等价于?key=value形式
		//创建一个uri对象
		URIBuilder uriBuilder = new URIBuilder("http://localhost:8081/rest/itemcat/list");
		uriBuilder.addParameter("callback", "myfunc");
		HttpGet get = new HttpGet(uriBuilder.build());
	
		CloseableHttpResponse response = httpClient.execute(get);
		int status = response.getStatusLine().getStatusCode();
		System.out.println(status);
		HttpEntity entity = response.getEntity();
		String string = EntityUtils.toString(entity);
		System.out.println(string);
		response.close();
		httpClient.close();
	}
	
//	@Test
	public void doPost() throws Exception{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost post = new HttpPost("http://localhost:8081/rest/itemcat/list?callback=func3");
//		HttpPost post = new HttpPost("http://localhost:8083/commons.html");
		
		CloseableHttpResponse response = httpClient.execute(post);
		
		int status = response.getStatusLine().getStatusCode();
		System.out.println(status);
		HttpEntity entity = response.getEntity();
		String string = EntityUtils.toString(entity,"utf-8");
		System.out.println(string);
		response.close();
		httpClient.close();
	}
	
//	@Test
	public void doPostWithParams() throws Exception {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost post = new HttpPost("http://login.cuit.edu.cn/Login/xLogin/Login.asp");
		
		List<NameValuePair> kvList = new ArrayList<>();
		kvList.add(new BasicNameValuePair("txtId", "12"));
		kvList.add(new BasicNameValuePair("txtMM", "12"));
//		kvList.add(new BasicNameValuePair("codeKey", value))
		
		StringEntity entity = new UrlEncodedFormEntity(kvList);
		post.setEntity(entity);
		
		CloseableHttpResponse response = httpClient.execute(post);
		
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println(statusCode);
//		HttpEntity entity = response.getEntity();
		String string = EntityUtils.toString(response.getEntity(),"gb2312");
		System.out.println(string);
		response.close();
		httpClient.close();
	}
	
	@Test
	public void TestUtils() {
		String string = HttpClientUtil.doGet("http://localhost:8081/rest//content/list/89");
		// json转List
		List<TbContent> parseArray = JSONObject.parseArray(string, TbContent.class);
		// List转json
		String jsonString = JSON.toJSONString(parseArray);
		System.out.println(jsonString);
		// json转map
		Map<String,Object> jsonObject = JSONObject.parseObject(jsonString);
		System.out.println(jsonObject.keySet().toString());
	}
}
