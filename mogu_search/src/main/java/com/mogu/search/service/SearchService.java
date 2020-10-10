package com.mogu.search.service;

import com.mogu.search.pojo.SearchResult;

public interface SearchService {
	SearchResult search(String queryString,int page,int rows) throws Exception;
}
