package com.search.service;

import com.taotao.common.pojo.SearchResult;

public interface SearchService {

	/**
	 * 分页展示商品
	 */
	public SearchResult search(String queryString, int page,int rows) throws Exception;
}
