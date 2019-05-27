package com.wd.lam_streams;
/**
 * desc pojo 类
 * @author wu
 * @date Create in 2019/05/27 17:31:31
 *
 */
public class Person {

	/** 名字 岗位 性别*/
	private String name ,job,gender;
	/** 薪水 年龄*/
	private int age,salary;
	
	
	
	/**
	 * desc 构造
	 * @param name 	名字
	 * @param job 	岗位
	 * @param gender性别	
	 * @param age	年龄
	 * @param salary薪水
	 */
	public Person(String name, String job, String gender, int age, int salary) {
		this.name = name;
		this.job = job;
		this.gender = gender;
		this.age = age;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
}
