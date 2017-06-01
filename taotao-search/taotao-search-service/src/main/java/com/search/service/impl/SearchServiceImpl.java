package com.search.service.impl;

import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.search.dao.ItemSearchDao;
import com.search.service.SearchService;
import com.taotao.common.pojo.SearchResult;
@Service
public class SearchServiceImpl implements SearchService {

	public SearchServiceImpl(){
		System.out.println("SearchServiceImpl");
	}
	@Autowired
	private ItemSearchDao itemSearchDao;
	
	@Override
	public SearchResult search(String queryString, int page, int rows) throws Exception {
		SolrQuery query = new SolrQuery();
		query.setQuery(queryString);
		
		if(page<1) page=1;
		
		query.setStart((page-1)*rows);
		query.setRows(rows);
		query.set("df", "item_title");
		
		//设置高亮
		query.setHighlight(true);
		query.addHighlightField("item_title");
		query.setHighlightSimplePre("<em style='color:red'>");
		query.setHighlightSimplePost("</em>");
		
		SearchResult search = itemSearchDao.search(query);
		long recordCount = search.getRecordCount();
		long pageCount = recordCount / rows;
		if (recordCount % rows >0) {
			pageCount++;
		}
		search.setPageCount(pageCount);
		
		return search;
	}

}
