package com.xjj.json;

import java.util.List;

/**
 * 分页查询的结果
 * @author XuJijun
 *
 * @param <T>
 */
public class PageResult<T> {
	
	private int totalRecord;	//总记录数
    private int totalPage;		//总页数
    private int pageNo = 1;		//页码，默认是第一页
    private int pageSize = 10;	//每页显示的记录数，默认是10
    private List<T> results;	//当前页的记录 
    
    public PageResult(){
    	
    }
    
    public PageResult(PageParams<T> page){
    	this.pageNo = page.getPageNo();
    	this.pageSize = page.getPageSize();
    }
    
    public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}
}
