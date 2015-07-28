package com.xjj.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 读取文件
 * @author XuJijun
 *
 */
public class FileAccessUtils {

	/**
	 * 创建一个文件
	 * @param fileName
	 */
	public static void createFile(String fileName){
		File file = new File(fileName);
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 以行为单位读取文件
	 * @param fileName
	 * @return
	 */
	public static ArrayList<String> readByLines(String fileName) {
		ArrayList<String> result = new ArrayList<>();
		
		File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            // 一次读入一行（非空），直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
            	tempString = tempString.trim();
            	if(!tempString.equals("")){
            		result.add(tempString);
            	}
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
		
		return result;
	}
	
	/**
	 * 列出所有文件（包括子目录）
	 * @param path
	 */
	public static void listAllFiles(String path) {
		File f = new File(path);
		if (path != null) {
			if (f.isDirectory()) {
				File[] fileArray = f.listFiles();
				if (fileArray != null) {
					for (File file : fileArray) {
						listAllFiles(file.getPath()); //递归调用
					}
				}
			} else {
				System.out.println(f);
			}
		}
	}

	/**
	 * 搜索文件名
	 * @param path
	 * @param target ： 文件名
	 */
	public static void searchDir(String path, String target) {
		File f = new File(path);
		if (path != null) {
			if (f.isDirectory()) {
				File[] fileArray = f.listFiles();
				if (fileArray != null) {
					for (File file : fileArray) {
						searchDir(file.getPath(), target); //递归调用
					}
				}
			} else {
				if(f.getName().contains(target)){
					System.out.println(f);
				}
			}
		}
	}

	
	public static void main(String[] args) {
		ArrayList<String> readByLines = readByLines("D:" + File.separator + "httphosts.txt");

		System.out.println(readByLines);

		System.out.println("File Separator: " + File.separator);
		System.out.println("Path Seperator: " + File.pathSeparator);

		//listAllFiles("D:" + File.separator);
		searchDir("D:" + File.separator, "tomcat");
	}
}
