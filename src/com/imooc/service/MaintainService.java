package com.imooc.service;

import java.util.ArrayList;
import java.util.List;

import com.imooc.dao.MessageDao;

/**
 * @author Mr_PR 维护相关的业务
 */
public class MaintainService {

	/**
	 * 删除一条记录
	 * 
	 * @param id
	 */
	public void deleteOne(String id) {
		if (id != null && !"".equals(id.trim())) {
			MessageDao messageDao = new MessageDao();
			messageDao.deleteOne(Integer.valueOf(id));
		}
	}

	/**
	 * 批量删除记录
	 * 
	 * @param idListStr
	 */
	public void deleteBatch(String[] ids) {
		List<Integer> idList = new ArrayList<Integer>();
		for (String id : ids) {
			idList.add(Integer.valueOf(id));
		}
		MessageDao messageDao = new MessageDao();
		messageDao.deleteBatch(idList);
	}

}
