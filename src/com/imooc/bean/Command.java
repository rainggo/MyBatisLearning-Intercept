package com.imooc.bean;

import java.util.List;

/**
 * 指令实体类
 */
public class Command {

	/**
	 * 主键id
	 */
	private int id;
	/**
	 * 指令名称
	 */
	private String name;
	/**
	 * 指令的描述
	 */
	private String description;
	
	private List<Command_Content> contentList;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Command_Content> getContentList() {
		return contentList;
	}
	public void setContentList(List<Command_Content> contentList) {
		this.contentList = contentList;
	}
}
