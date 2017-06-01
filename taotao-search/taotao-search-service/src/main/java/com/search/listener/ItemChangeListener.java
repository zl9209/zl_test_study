package com.search.listener;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;

import com.taotao.common.pojo.SearchItem;
import com.taotao.search.mapper.ItemMapper;

public class ItemChangeListener implements MessageListener{


	@Autowired
	private ItemMapper itemMapper;
	
	@Autowired
	private SolrServer solrServer;
	
	@Override
	public void onMessage(Message message) {
		try {
			if (message instanceof TextMessage) {
				System.out.println("消费一次ActiveMQ消息!!!");
				TextMessage textMessage = (TextMessage) message;
				long itemId = Long.parseLong(textMessage.getText());
				SearchItem searchItem = itemMapper.getItemById(itemId);
				////把商品添加到索引库
				SolrInputDocument document = new SolrInputDocument();
				document.addField("id", searchItem.getId());
				document.addField("item_title", searchItem.getTitle());
				document.addField("item_sell_point", searchItem.getSell_point());
				document.addField("item_price", searchItem.getPrice());
				document.addField("item_image", searchItem.getImage());
				document.addField("item_category_name", searchItem.getCategory_name());
				document.addField("item_desc", searchItem.getItem_desc());
				solrServer.add(document);
				
				solrServer.commit();
				System.out.println("消费一次ActiveMQ消息并且把商品添加到索引库!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
