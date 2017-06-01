package com.search.service;

import com.taotao.common.pojo.TaotaoResult;

public interface SearchItemService {
	
	/**
	 * 商品一键导入索引库
	 */
	public TaotaoResult importAllItems() throws Exception;

}
