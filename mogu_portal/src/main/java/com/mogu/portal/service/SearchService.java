package com.mogu.portal.service;

import com.mogu.portal.pojo.SearchResult;

public interface SearchService {
	SearchResult search(String queryString,Integer page);
}
