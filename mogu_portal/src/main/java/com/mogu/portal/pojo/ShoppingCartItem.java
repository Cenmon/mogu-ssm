package com.mogu.portal.pojo;

public class ShoppingCartItem {
	private String id;
	private String title;
	private int count;//购物车中该商品的数量
	private long price;
	private String image;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
//	public String[] getImages() {
//		if(image!=null) {
//			return image.split(",");
//		}
//		return null;
//	}
}
