package com.imooc.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.imooc.bean.Command;
import com.imooc.bean.Command_Content;
import com.imooc.db.DBAccess;

/**
 * Command表对应的数据库操作类
 */
public class CommandContentDao {

	/**
	 * 查询记录的条数
	 * @param command
	 * @return
	 */
	public int count(Command command){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		int result = 0;
		try {
			sqlSession = dbAccess.getSqlSession();
			ICommandContent iCommandContent = sqlSession.getMapper(ICommandContent.class);
			result = iCommandContent.count(command);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Command_Content> queryContentList(Map<String, Object> params) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		List<Command_Content> contentList = new ArrayList<Command_Content>();
		try {
			sqlSession = dbAccess.getSqlSession();
			ICommandContent iCommandContent = sqlSession.getMapper(ICommandContent.class);
			contentList = iCommandContent.queryContentList(params);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return contentList;
	}
	
	public List<Command_Content> queryContentListByPage(Map<String, Object> params) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		List<Command_Content> contentList = new ArrayList<Command_Content>();
		try {
			sqlSession = dbAccess.getSqlSession();
			ICommandContent iCommandContent = sqlSession.getMapper(ICommandContent.class);
			contentList = iCommandContent.queryContentListByPage(params);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return contentList;
	}
}
