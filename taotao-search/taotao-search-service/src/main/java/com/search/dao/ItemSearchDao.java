package com.search.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import com.taotao.common.pojo.SearchItem;
import com.taotao.common.pojo.SearchResult;

@Repository
public class ItemSearchDao {
	public ItemSearchDao(){
		System.out.println("ItemSearchDao");
	}
	@Autowired
	private SolrServer solrServer;
	
	public SearchResult search(SolrQuery query) throws Exception{
		
		QueryResponse response = solrServer.query(query);
		SolrDocumentList results = response.getResults();
		
		SearchResult result = new SearchResult();
		result.setRecordCount(results.getNumFound());
		
		//取结果集
		List<SearchItem> itemList = new ArrayList<>();
		for (SolrDocument solrDocument : results) {
			
			SearchItem searchItem = new SearchItem();
			searchItem.setCategory_name((String) solrDocument.get("item_category_name"));
			searchItem.setId(Long.parseLong(solrDocument.get("id").toString()));
			searchItem.setImage((String)solrDocument.get("item_image"));
			searchItem.setPrice(Long.parseLong(solrDocument.get("item_price").toString()));
			
			//取高亮显示
			String itemTitle = null;
			Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
			
			List<String> list = highlighting.get(solrDocument.get("id")).get("item_title");
			if (list != null && list.size()>0) {
				itemTitle =  list.get(0);
			}else{
				itemTitle = (String)solrDocument.get("item_title");
				
			}
			searchItem.setTitle(itemTitle);
		
			//添加到商品列表
			itemList.add(searchItem);
		}
		result.setItemList(itemList);
		return result;
	}

}
















