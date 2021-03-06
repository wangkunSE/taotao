package com.soul.search.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soul.common.pojo.TaotaoResult;
import com.soul.search.service.IItemService;

@Controller
@RequestMapping("/manager")
public class ItemController {

	@Resource
	private IItemService itemService;
	
	@RequestMapping("/importall")
	@ResponseBody
	public TaotaoResult importAllItems() {
		
		TaotaoResult allItems = itemService.importAllItems();
		
		return allItems;
	}
	
	@RequestMapping(value="/index",method=RequestMethod.POST)
	@ResponseBody
	public TaotaoResult addIndex(@RequestBody String itemInfo) {
		TaotaoResult taotaoResult = itemService.addDocument(itemInfo);
		return taotaoResult;
	}
}
