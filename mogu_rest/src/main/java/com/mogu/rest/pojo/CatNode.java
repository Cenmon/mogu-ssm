package com.mogu.rest.pojo;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class CatNode {
	@JSONField(name="n")
	private String name;
	@JSONField(name="u")
	private String url;
	@JSONField(name="i")
	private List<?> item;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<?> getItem() {
		return item;
	}
	public void setItem(List<?> item) {
		this.item = item;
	}
}
