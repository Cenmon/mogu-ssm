package com.mogu.search.mapper;

import java.util.List;

import com.mogu.search.pojo.SolrItem;

public interface SolrItemMapper {
	List<SolrItem> getItemList();
	
	SolrItem getItemById(long id);
}
