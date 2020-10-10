package com.mogu.search.service.impl;

import java.util.List;

import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mogu.search.mapper.SolrItemMapper;
import com.mogu.search.pojo.SolrItem;
import com.mogu.search.service.SolrItemService;

import taotao_common.TaotaoItemResult;

@Service
public class SolrItemServiceImpl implements SolrItemService {

	@Autowired
	private SolrItemMapper solrItemMapper;
	
	@Autowired
	private HttpSolrClient httpSolrClient;
	
	@Override
	public TaotaoItemResult importAllItem() throws Exception {
		try {
			List<SolrItem> itemList = solrItemMapper.getItemList();
			
			for (SolrItem solrItem : itemList) {
				SolrInputDocument solrInputDocument = new SolrInputDocument();
				solrInputDocument.addField("id", solrItem.getId());
				solrInputDocument.addField("item_title", solrItem.getTitle());
				solrInputDocument.addField("item_sell_point", solrItem.getSell_point());
				solrInputDocument.addField("item_price", solrItem.getPrice());
				solrInputDocument.addField("item_image", solrItem.getImage());
				solrInputDocument.addField("item_category_name", solrItem.getCategory_name());
				solrInputDocument.addField("item_desc", solrItem.getItem_desc());
				httpSolrClient.add(solrInputDocument);
			}
			
			httpSolrClient.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoItemResult.error();
		}
		
		return TaotaoItemResult.ok();
	}

	@Override
	public TaotaoItemResult importItem(long id) throws Exception {
		SolrItem item = solrItemMapper.getItemById(id);
		SolrInputDocument solrInputDocument = new SolrInputDocument();
		solrInputDocument.addField("id", item.getId());
		solrInputDocument.addField("item_title", item.getTitle());
		solrInputDocument.addField("item_sell_point", item.getSell_point());
		solrInputDocument.addField("item_price", item.getPrice());
		solrInputDocument.addField("item_image", item.getImage());
		solrInputDocument.addField("item_category_name", item.getCategory_name());
		solrInputDocument.addField("item_desc", item.getItem_desc());
		httpSolrClient.add(solrInputDocument);
		httpSolrClient.commit();
		return TaotaoItemResult.ok();
	}

	@Override
	public TaotaoItemResult deleteItem(long id) throws Exception {
		httpSolrClient.deleteById(id+"");
		httpSolrClient.commit();
		return TaotaoItemResult.ok();
	}

}
