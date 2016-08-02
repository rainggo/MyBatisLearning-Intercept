package com.imooc.bean;

/**
 * 指令内容的实体类
 */
public class Command_Content {

	/**
	 * 主键id
	 */
	private int id;
	/**
	 * 指令对应的内容
	 */
	private String content;
	/**
	 * 指令id
	 */
	private int command_id;
	/**
	 * 指令对象
	 */
	private Command command;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCommand_id() {
		return command_id;
	}
	public void setCommand_id(int command_id) {
		this.command_id = command_id;
	}
	public Command getCommand() {
		return command;
	}
	public void setCommand(Command command) {
		this.command = command;
	}
	
	
}
