package com.xjj.ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTPClient;

public class MyFTPClient {
	private static FTPClient client;

	static String hostname = "192.168.1.163";
	//String port = "21";
	static String username = "xujijun";
	static String password = "bhu89IJN";

	public static void main(String[] args) {
		client = new FTPClient();
		
		String fileName = "hp_M1530_MFP_Basic_usb_n_w.exe";
		File file = new File("F://" + fileName);
		
		long fileSize = file.length();
		long transferredSize = 0;
		
		int bufferSize = 1024*2;
		byte[] buffer = new byte[bufferSize];
		
		FileInputStream fileInputStream = null;
		
		try {
			client.connect(hostname);
			System.out.println(client.getReplyString());
			
			client.login(username, password);
			System.out.println(client.getReplyString());
			
			client.setFileType(FTPClient.BINARY_FILE_TYPE);
			
			fileInputStream = new FileInputStream(file);
			OutputStream outputstream = client.storeFileStream(fileName);
			
			int n = -1;
			
			System.out.println("File Size: " + fileSize);
			
			while((n = fileInputStream.read(buffer)) != -1){
				outputstream.write(buffer);
				transferredSize += n;
				System.out.println("进度：" + (transferredSize*100/fileSize) + "%");
			}
			
			
			//System.out.println(client.getBufferSize());
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				System.out.println("Close Input Stream");
				fileInputStream.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			if(client.isConnected()){
				try {
					System.out.println("Close FTP Client");
					client.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		

	}
}
