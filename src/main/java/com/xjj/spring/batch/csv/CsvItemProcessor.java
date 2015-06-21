package com.xjj.spring.batch.csv;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component("csvItemProcessor")
public class CsvItemProcessor implements ItemProcessor<Student, Student> {

	@Override
	public Student process(Student student) throws Exception {
		/* 合并ID和名字 */
        student.setName(student.getID() + "--" + student.getName());
        /* 年龄加2 */
        student.setAge(student.getAge() + 2);
        /* 分数加10 */
        student.setScore(student.getScore() + 10);
        /* 将处理后的结果传递给writer */
        return student;
	}

}
