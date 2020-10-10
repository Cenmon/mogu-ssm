package com.mogu.JSON.toJsonSting;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mogu.rest.pojo.CatNode;
import com.mogu.rest.pojo.CatResult;

import taotao_common.TaotaoItemResult;

public class TestToJsonString {

	@Test
	public void TestToJson() {
		CatResult catResult = new CatResult();
		List<CatNode> list = new ArrayList<CatNode>();
		CatNode catNode = new CatNode();
		TaotaoItemResult taotaoItemResult = new TaotaoItemResult();
		
		
		catNode.setName("cenmo");
		catNode.setUrl("https://www.baidu.com");
		
		list.add(catNode);
		catResult.setData(list);
		
		taotaoItemResult.setData(list);
		taotaoItemResult.setStatus(200);
		
		String reString = JSON.toJSONString(taotaoItemResult,SerializerFeature.WriteMapNullValue);
		System.out.println(reString);
		// 修改序列化后的名称：JSONFiled(name="")
		// fastjson转化字符串时，自动忽略null值
//		System.out.println(JSON.toJSONString(catResult,SerializerFeature.WriteMapNullValue));
		
		// 不指定转化的class文件，则将json转化为fastjson的就送object文件
		JSONObject jsonObject = JSONObject.parseObject(reString);
		// fastjson深层转化时，将list转化为JsonList对象，无法遍历，无法获取
		// 转化深层pojo时，可通过jsonobject先获取需转化的pojo，逐一转化
		System.out.println(jsonObject.getString("status").getClass());
		System.out.println(JSONObject.parseObject(jsonObject.getString("data"), List.class).getClass());
		System.out.println();
	}
}
