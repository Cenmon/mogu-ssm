package com.mogu.portal.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.mogu.portal.pojo.ItemInfo;
import com.mogu.portal.service.ItemService;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.pojo.TbItemParamItemExample;

import taotao_common.TaotaoItemResult;
import taotao_utils.HttpClientUtil;

@Service
public class ItemServiceImpl implements ItemService {

	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	
	@Value("${REST_ITEM_INFO_URL}")
	private String REST_ITEM_INFO_URL;
	
	@Value("${REST_ITEM_DESC_INFO_URL}")
	private String REST_ITEM_DESC_INFO_URL;
	
	@Value("${REST_ITEM_PARAM_INFO_URL}")
	private String REST_ITEM_PARAM_INFO_URL;
	
	@Override
	public ItemInfo getItemBaseInfoById(long itemId) {
		try {
			String json = HttpClientUtil.doGet(REST_BASE_URL+REST_ITEM_INFO_URL+"/"+itemId);
			if(!StringUtils.isBlank(json)) {
				JSONObject jsonObject = JSONObject.parseObject(json);
				if(jsonObject.getString("status").equals("200")) {
					return JSONObject.parseObject(jsonObject.getString("data"),ItemInfo.class);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public String getItemDescInfoById(long itemId) {
		
		try {
			String json = HttpClientUtil.doGet(REST_BASE_URL + REST_ITEM_DESC_INFO_URL +"/" + itemId);
			if(!StringUtils.isBlank(json)) {
				JSONObject jsonObject = JSONObject.parseObject(json);
				if(jsonObject.getString("status").equals("200")) {
					TbItemDesc itemDesc = JSONObject.parseObject(jsonObject.getString("data"),TbItemDesc.class);
					return itemDesc.getItemDesc();
				}				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public String getItemParamInfoById(long itemId) {
		
		try {
			String json = HttpClientUtil.doGet(REST_BASE_URL+REST_ITEM_PARAM_INFO_URL+"/"+itemId);
			if(!StringUtils.isBlank(json)) {
				JSONObject jsonObject = JSONObject.parseObject(json);
				if(jsonObject.getString("status").equals("200")) {
					JSONObject paramItemJson = JSONObject.parseObject(jsonObject.getString("data"));
					List<Map> paramData = JSONObject.parseObject(paramItemJson.getString("paramData"),new TypeReference<List<Map>>() {});
					
					StringBuffer sb = new StringBuffer();
					
					// 生成规格参数html代码
					sb.append("<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" border=\"0\" class=\"Ptable\">\n");
					sb.append("    <tbody>\n");
					for (Map m1 : paramData) {
						
						// 设置主体group
						sb.append("        <tr>\n");
						sb.append("            <th class=\"tdTitle\" colspan=\"2\">"+m1.get("group")+"</th>\n");
						sb.append("        </tr>\n");
						
						//设置param（内部为List<map>，即多个map组成的list，另map由“k”，“v”键组成）
//						List<Map> params = JSONObject.parseArray(m1.get("params"),new TypeReference<List<Map>>(){});
						List<Map> params = (List<Map>)m1.get("params");
						for (Map m2 : params) {
							sb.append("        <tr>\n");
							sb.append("            <td class=\"tdTitle\">"+m2.get("k")+"</td>\n");
							sb.append("            <td>"+m2.get("v")+"</td>\n");
							sb.append("        </tr>\n");
						}
					}
					sb.append("    </tbody>\n");
					sb.append("</table>");
					//返回html片段
					return sb.toString();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
