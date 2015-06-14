package com.xjj.json;

import java.util.Map;
 
/**
 * 对分页请求的参数进行简单的封装
 * @author XuJijun
 *
 * @param <T>
 */
public class PageParams<T> {
    private int pageNo = 1;		//页码，默认是第一页
    private int pageSize = 10;	//每页显示的记录数，默认是10
    private Map<String, Object> params;//其他的参数封装成一个Map对象
    
    /**
     * 起始位置，从1开始
     * @return 起始位置
     */
	public int getStartPos(){
		return (pageNo-1)*pageSize + 1;
	}
	
	/**
	 * 结束位置，例如：最后的位置相当于length()或size()
	 * @return 结束位置
	 */
	public int getEndPos() {
		return getStartPos() + pageSize; 
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

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

 
}