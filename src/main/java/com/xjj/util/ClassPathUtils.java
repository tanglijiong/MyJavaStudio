package com.xjj.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * 获取类路径和流的工具类
 * @author 许继俊
 * @Date   2014-12-10
 *
 */
public class ClassPathUtils {

	/**
	 * 获取项目所有类的根路径
	 * @return 根路径（classes目录）
	 */
	public static String getClassPath()	{
		final URL url = ClassPathUtils.class.getResource("/");
		return url.getPath();
	}
	
	/**
	 * 获取某个指定类所在的路径
	 * @param clazz
	 * @return clazz所在的路径
	 */
	public static String getClassPath(final Class<?> clazz)	{
		final URL url = clazz.getResource("");
		return url.getPath();
	}
	
	/**
	 * 获取一个包的路径
	 * @param path 包名，格式：com/xjj/util
	 * @return 指定的包所在的路径
	 */
	public static String getClassPath(String path)	{
		final URL url = ClassPathUtils.class.getResource("/" + path);
		return url.getPath();
	}
	
	/**
	 * 获取一个指定路径文件的输入流
	 * @param filePath 指定一个路径和文件名，如：conf/config.properties
	 * @return
	 */
	public static InputStream getInputStream(final String filePath)	{
		final InputStream input = ClassPathUtils.class.getResourceAsStream("/" + filePath);
		return input;
	}
	
	//测试
	public static void main(String[] args) throws IOException {
		System.out.println("根路径：" + getClassPath());
		System.out.println("类ClassPathUtils所在的路径：" + getClassPath(ClassPathUtils.class));
		System.out.println("包com.xjj.ftp所在的路径：" + getClassPath("com/xjj/utils"));
		System.out.println("包com.xjj.ftp所在的路径：" + getClassPath("com/xjj/utils"));
		
		System.out.println("配置目录springmvc所在的路径：" + getClassPath("springmvc"));
		
		InputStream in = getInputStream("springmvc/servlet.xml");
		//InputStream in = getInputStream("resources/css/common.css");
		int buffSize = 1024;
		byte[] b = new byte[buffSize];
		in.read(b, 0, buffSize);
		System.out.write(b);
	}
}
