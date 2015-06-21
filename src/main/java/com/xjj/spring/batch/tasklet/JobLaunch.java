package com.xjj.spring.batch.tasklet;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JobLaunch {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/xjj/spring/batch/taskLet/batch.xml");
		JobLauncher launcher = (JobLauncher) context.getBean("jobLauncher");
		Job job = (Job) context.getBean("helloWorldJob");

		try {
			/* 由jobLauncher来运行Job */
			JobExecution result = launcher.run(job, new JobParameters());
			/* 处理结束，控制台打印处理结果 */
			System.out.println(result.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			((ClassPathXmlApplicationContext) context).close();
		}
	}
}
