package com.imooc.dao;

import java.util.List;

import com.imooc.bean.Command;

public interface ICommand {

	public List<Command> queryCommandList(Command command);
}
