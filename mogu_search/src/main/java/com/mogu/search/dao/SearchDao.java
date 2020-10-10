package com.mogu.search.dao;

import org.apache.solr.client.solrj.SolrQuery;

import com.mogu.search.pojo.SearchResult;

public interface SearchDao {
	SearchResult search(SolrQuery query) throws Exception;
}
