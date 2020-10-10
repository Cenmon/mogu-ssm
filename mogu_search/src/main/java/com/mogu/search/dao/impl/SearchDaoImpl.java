package com.mogu.search.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mogu.search.dao.SearchDao;
import com.mogu.search.pojo.SearchResult;
import com.mogu.search.pojo.SolrItem;

@Repository
public class SearchDaoImpl implements SearchDao{

	@Autowired
	private HttpSolrClient httpSolrClient;
	
	@Override
	public SearchResult search(SolrQuery query) throws Exception {
		SearchResult searchResult = new SearchResult();
		//根据查询条件查询索引库
		QueryResponse response = httpSolrClient.query(query);
		//取商品查询结果
		SolrDocumentList solrDocumentList = response.getResults();
		//取高光查询结果
		Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
		
		searchResult.setRecordCount(solrDocumentList.getNumFound());
		
		List<SolrItem> itemList = new ArrayList<>();
		for (SolrDocument solrDocument : solrDocumentList) {
			SolrItem item = new SolrItem();
			item.setId((String)solrDocument.get("id"));
			
			//获取高光显示
			List<String> list = highlighting.get(solrDocument.get("id")).get("item_title");
			String title = "";
			if(list!=null && list.size()>0) {
				title = list.get(0);
			}else {
				title=(String)solrDocument.get("item_title");
			}
			item.setTitle(title);
			item.setImage((String)solrDocument.get("item_image"));
			item.setPrice((long)solrDocument.get("item_price"));
			item.setSell_point((String)solrDocument.get("item_sell_point"));
			item.setCategory_name((String)solrDocument.get("item_category_name"));
			itemList.add(item);
		}
		searchResult.setItemList(itemList);
		return searchResult;
	}

}
