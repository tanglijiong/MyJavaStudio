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
	
	public static void main(String[] args) {
		ArrayList<String> readByLines = readByLines("D:/httphosts.txt");
		
		System.out.println(readByLines);
	}
}
