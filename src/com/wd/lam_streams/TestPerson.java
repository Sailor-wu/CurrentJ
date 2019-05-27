package com.wd.lam_streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class TestPerson {
	static List<Person> persons = null;
	static List<Person> javaProgrammers = null;
	static {
		 persons = new ArrayList<Person>() {
			{
				add(new Person("张三", "java", "man", 22, 25000));
				add(new Person("张三1", "php", "man", 22, 5000));
				add(new Person("张三2", "python", "man", 22, 9000));
				add(new Person("张三3", "javascript", "man", 22, 8000));
				add(new Person("张4三", "c++", "man", 22, 5000));
				add(new Person("张5三", "c", "man", 22, 11000));
				add(new Person("张6三", "go", "man", 22, 7000));
				add(new Person("张7三", "c#", "man", 22, 9000));
				add(new Person("张8三", "ada", "man", 22, 10000));
				add(new Person("张9三", "vb.net", "man", 22, 13000));
			}
		};
		javaProgrammers = new ArrayList<Person>() {  
			  {  
			    add(new Person("Elsdon",  "Java programmer", "male", 43, 2000));  
			    add(new Person("Tamsen",   "Java programmer", "female", 23, 1500));  
			    add(new Person("Floyd",  "Java programmer", "male", 33, 1800));  
			    add(new Person("Sindy",  "Java programmer", "female", 32, 1600));  
			    add(new Person("Vere",   "Java programmer", "male", 22, 1200));  
			    add(new Person("Maude", "Java programmer", "female", 27, 1900));  
			    add(new Person("Shawn",  "Java programmer", "male", 30, 2300));  
			    add(new Person("Jayden",   "Java programmer", "female", 35, 1700));  
			    add(new Person("Palmer",   "Java programmer", "male", 33, 2000));  
			    add(new Person("Addison",  "Java programmer", "female", 34, 1300));  
			  }  
			};
	}
	
	public static void main(String[] args) {
		// 现在我们使用forEach方法来迭代输出上述列表:
		System.out.println("所有程序员的姓名:");  
		TestPerson.javaProgrammers.forEach((p) -> System.out.printf("%s \n ", p.getName() ));  
		System.out.println("==============");
		TestPerson.persons.forEach((p) -> System.out.printf("%s \n ", p.getName()));  
		
		// 给集合里面的员工加工资  5%
		TestPerson.persons.forEach((p) -> System.out.printf("%s \n ", p.getSalary()));
		
		// 遍历集合 一个个set
//		for (Person p : persons) {
//			p.setSalary(p.getSalary() / 100 *5 + p.getSalary());
//		}
		
		// lambda写法		
		Consumer<Person> givePerson = e -> e.setSalary(e.getSalary() / 100 *5 + e.getSalary());
		persons.forEach(givePerson);
		
		
		System.out.println("添加之后=============");
		TestPerson.persons.forEach((p) -> System.out.printf("%s \n ", p.getSalary()));
		
		
		
		System.out.println("------------过滤方法-----------------");
		persons.stream().filter((p) -> (p.getSalary() > 10000)).forEach((p) -> System.out.printf("%s %s \n ", p.getName(), p.getSalary()));
		
	}
	

}
