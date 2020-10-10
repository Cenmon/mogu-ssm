package com.mogu.portal.pojo;

import com.taotao.pojo.TbItem;

/**
 * 用于展示商品基本信息pojo
 * 注：增加了getImages方法
 * @author lenovo
 *
 */
public class ItemInfo extends TbItem {
	public String[] getImages() {
		String image = getImage();
		if(image != null) {
			return image.split(",");
		}
		return null;
	}
}
