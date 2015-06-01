package com.xjj.springBatch.xml;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XMLLauch {
	public static void main(String[] args1) {

        ApplicationContext context = new ClassPathXmlApplicationContext("com/xjj/springBatch/xml/batch.xml");
        JobLauncher launcher = (JobLauncher) context.getBean("jobLauncher");
        Job job = (Job) context.getBean("xmlFileReadAndWriterJob");

        try {
            // JOB实行
            JobExecution result = launcher.run(job, new JobParametersBuilder()
                    .addString("inputFilePath", "src/com/xjj/springBatch/xml/input.xml")
                    .addString("outputFilePath", "src/com/xjj/springBatch/xml/output.xml")
                    .toJobParameters());
            // 运行结果输出
            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
			((ClassPathXmlApplicationContext) context).close();
		}
    }
}
