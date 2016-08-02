package com.imooc.dao;

import java.util.List;
import java.util.Map;

import com.imooc.bean.Command;
import com.imooc.bean.Command_Content;

public interface ICommandContent {

	public int count(Command command);
	public List<Command_Content> queryContentList(Map<String, Object> params);
	public List<Command_Content> queryContentListByPage(Map<String, Object> params);
}
