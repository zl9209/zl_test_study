package com.search.service.impl;

import java.util.List;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.search.service.SearchItemService;
import com.taotao.common.pojo.SearchItem;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.search.mapper.ItemMapper;
@Service
public class SearchItemServiceImpl implements SearchItemService {

	@Autowired
	private ItemMapper itemMapper;
	
	@Autowired
	private SolrServer solrServer;
	
	@Override
	public TaotaoResult importAllItems() throws Exception{
		
		List<SearchItem> list = itemMapper.getitemList();
		
		for (SearchItem item : list) {
			SolrInputDocument document = new SolrInputDocument();
			document.addField("id", item.getId());
			document.addField("item_title", item.getTitle());
			document.addField("item_sell_point", item.getSell_point());
			document.addField("item_price", item.getPrice());
			document.addField("item_image", item.getImage());
			document.addField("item_category_name", item.getCategory_name());
			document.addField("item_desc", item.getItem_desc());
			solrServer.add(document);
		}
		solrServer.commit();
		return TaotaoResult.ok();
	}
	
/*	
	@Override
	public TaotaoResult addDocument(Long itemid) throws Exception{
		//1.得到更改的商品信息
		SearchItem item = itemMapper.getItemById(itemid);
		
		SolrInputDocument document = new SolrInputDocument();
		document.addField("id", item.getId());
		document.addField("item_title", item.getTitle());
		document.addField("item_sell_point", item.getSell_point());
		document.addField("item_price", item.getPrice());
		document.addField("item_image", item.getImage());
		document.addField("item_category_name", item.getCategory_name());
		document.addField("item_desc", item.getItem_desc());
		solrServer.add(document);
			
		solrServer.commit();
		return TaotaoResult.ok();
	}*/

}










