package com.xjj.concurrent.thread;

/**
 * 启动子线程的方式（使用内部类定义另外一个线程）
 * @author XuJijun
 *
 */
public class MyThread {
	public static void main(String[] args) {
		(new MyThread()).new AnotherThread("张三").start();
	}
	
	/**
	 * 内部类，实现子线程 
	 *
	 */
	private class AnotherThread extends Thread{
		private String msg;
		
		/*
		 * 加一个参数，用于接收主线程的信息
		 */
		public AnotherThread(String msg) {
			super();
			this.msg = msg;
		}

		@Override
		public void run() {
			System.out.println("Hello " + msg);
		}
	}
}
