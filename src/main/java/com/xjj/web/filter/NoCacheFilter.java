package com.xjj.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * 防止浏览器缓存页面或请求结果
 * 
 * @author XuJijun
 *
 */
public class NoCacheFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) resp;

		response.setDateHeader("Expires", -1); // 告诉浏览器数据可以缓存多长时间，-1或0表示不缓存
		response.setHeader("Cache_Control", "no-cache"); // 支持HTTP 1.1，告诉浏览器要不要缓存数据，如“no-cache”
		response.setHeader("Pragma", "no-cache"); // 支持HTTP 1.0，告诉浏览器要不要缓存数据，如“no-cache”

		response.setHeader("Access-Control-Allow-Origin", "*"); // 允许跨域请求（CORS）
		response.setHeader("Access-Control-Allow-Headers", "*"); // 允许跨域请求的Headers（CORS）

		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
}
