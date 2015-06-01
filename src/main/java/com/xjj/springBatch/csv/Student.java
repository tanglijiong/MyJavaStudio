package com.xjj.springBatch.csv;

public class Student {
    /** ID */
    private String ID = "";
    /** 名字 */
    private String name = "";
    /** 年龄 */
    private int age = 0;
    /** 分数 */
    private float score = 0;
    
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		//System.out.println(name);
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
}
