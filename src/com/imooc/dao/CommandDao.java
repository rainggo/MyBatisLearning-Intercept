package com.imooc.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.imooc.bean.Command;
import com.imooc.db.DBAccess;

public class CommandDao {

	public List<Command> queryCommandList(Command command) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		List<Command> commandList = new ArrayList<Command>();
		try {
			sqlSession = dbAccess.getSqlSession();
			ICommand iCommand = sqlSession.getMapper(ICommand.class);
			commandList = iCommand.queryCommandList(command);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return commandList;
	}
}
