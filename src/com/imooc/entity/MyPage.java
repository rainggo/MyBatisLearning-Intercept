package com.imooc.entity;

/**
 * 分页类
 */
public class MyPage {

	/**
	 * 当前页码
	 */
	private int currentPage;
	/**
	 * 总页码
	 */
	private int totalPage;
	/**
	 * 记录的总数目
	 */
	private int totalNumber;
	/**
	 * 每页要显示的条数
	 */
	private int pageNumber = 5;

	/**
	 * 数据库中对应的当前索引
	 */
	private int dbIndex;
	/**
	 * 数据库中的取出数量
	 */
	private int dbNumber;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getTotalNumber() {
		return totalNumber;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}

	public int getDbIndex() {
		return dbIndex;
	}

	public void setDbIndex(int dbIndex) {
		this.dbIndex = dbIndex;
	}

	public int getDbNumber() {
		return dbNumber;
	}

	public void setDbNumber(int dbNumber) {
		this.dbNumber = dbNumber;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	/**
	 * 计算属性值
	 */
	public void count() {
		// 先计算总页数
		int totalPageTemp = this.totalNumber / this.pageNumber;
		// 补页，防止出现不能整除的情况
		int plus = this.totalNumber % this.pageNumber == 0 ? 0 : 1;
		totalPageTemp = totalPageTemp + plus;
		if (totalPageTemp <= 0) {
			totalPageTemp = 1;
		}
		this.totalPage = totalPageTemp;

		// 设置当前页数
		// 当前页数大于总页数，设置当前页数为最大页数
		if (this.currentPage > this.totalPage) {
			this.currentPage = this.totalPage;
		}
		// 当前页数小于等于0
		if (this.currentPage <= 0) {
			this.currentPage = 1;
		}

		// 设置数据库的limit值
		this.dbIndex = ( this.currentPage - 1 ) * this.pageNumber;
		this.dbNumber = this.pageNumber;
	}
}
