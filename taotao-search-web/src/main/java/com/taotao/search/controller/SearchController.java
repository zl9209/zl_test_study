package com.taotao.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.search.service.SearchService;
import com.taotao.common.pojo.SearchResult;

@Controller
public class SearchController {

	@Value("${ITEM_ROWS}")
	private Integer ITEM_ROWS;
	@Autowired
	private SearchService searchService;

	/**
	 * 查询得到商品 
	 */
	@RequestMapping("/search")
	public String searchItem(
			@RequestParam("q")String queryString,
			@RequestParam(defaultValue="1")Integer page,Model model) throws Exception{
		
		queryString = new String(queryString.getBytes("iso8859-1"),"utf-8");
		
		SearchResult searchResult = searchService.search(queryString, page, ITEM_ROWS);
		
		model.addAttribute("query",queryString);
		model.addAttribute("totalPages",searchResult.getPageCount());
		model.addAttribute("itemList",searchResult.getItemList());
		model.addAttribute("page",page);
		
		return "search";
	}


}
