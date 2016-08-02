package com.imooc.dao;

import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.imooc.bean.Message;
import com.imooc.db.DBAccess;

/**
 * @author Mr_PR 和Message表相关的数据库操作
 */
public class MessageDao {

	/**
	 * 通过条件查询消息列表
	 * 
	 * @param command
	 * @param description
	 * @return
	 */
	public List<Message> queryMessageList(String command, String description) {
		DBAccess dbAccess = new DBAccess();
		List<Message> messageList = new ArrayList<Message>();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			Message message = new Message();
			message.setCommand(command);
			message.setDescription(description);
			// 通过sqlSession执行sql语句
			//messageList = sqlSession.selectList("Message.queryMessageList", message);
			// 使用面向接口的方式进行操作
			IMessage imessage = sqlSession.getMapper(IMessage.class);
			messageList = imessage.queryMessageList(message);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return messageList;
	}

	/**
	 * 删除一条记录
	 * @param id
	 */
	public void deleteOne(int id){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			sqlSession.delete("Message.deleteOne", id);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null){
				sqlSession.close();
			}
		}
	}
	
	/**
	 * 通过id列表删除记录
	 * @param idList
	 */
	public void deleteBatch(List<Integer> idList){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try{
			sqlSession = dbAccess.getSqlSession();
			sqlSession.delete("Message.deleteBatch", idList);
			sqlSession.commit();
		} catch(IOException e){
			e.printStackTrace();
		} finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
	}
	/**
	 * 通过条件查询消息列表
	 * 
	 * @param command
	 * @param description
	 * @return
	 */
//	public List<Message> queryMessageList(String command, String description) {
//		List<Message> messageList = new ArrayList<Message>();
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection conn = DriverManager
//					.getConnection(
//							"jdbc:mysql://localhost:3306/MyBatisLearning?useUnicode=true&characterEncoding=utf-8",
//							"root", "root");
//
//			StringBuilder sql = new StringBuilder(
//					"select ID,COMMAND,DESCRIPTION,CONTENT from MESSAGE where 1=1");
//			// 为了解决“先准备sql语句”与“事先填写sql参数”矛盾而编写的缓冲列表
//			List<String> paramList = new ArrayList<String>();
//			if (command != null && !"".equals(command.trim())) {
//				sql.append(" and COMMAND=?");
//				paramList.add(command);
//			}
//			if (description != null && !"".equals(description.trim())) {
//				sql.append(" and DESCRIPTION like '%' ? '%'");
//				paramList.add(description);
//			}
//
//			PreparedStatement stmt = conn.prepareStatement(sql.toString());
//			for (int i = 0; i < paramList.size(); i++) {
//				stmt.setString(i + 1, paramList.get(i));
//			}
//
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				Message message = new Message();
//				message.setId(rs.getString("ID"));
//				message.setCommand(rs.getString("COMMAND"));
//				message.setDescription(rs.getString("DESCRIPTION"));
//				message.setContent(rs.getString("CONTENT"));
//				messageList.add(message);
//			}
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return messageList;
//	}
}
