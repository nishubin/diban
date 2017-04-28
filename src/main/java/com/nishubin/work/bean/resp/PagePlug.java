package com.nishubin.work.bean.resp;

import java.util.List;

public class PagePlug<T> {
	/**
	 * 总条数
	 */
	private Integer total;
	/**
	 * 数据
	 */
	private List<T> data;
	/**
	 * 总页数
	 */
	private Integer pageSize;
	/**
	 * 当前页
	 */
	private Integer page;
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	
}