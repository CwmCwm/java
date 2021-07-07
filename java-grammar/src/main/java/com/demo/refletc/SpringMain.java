package com.demo.refletc;

import java.sql.Date;


/**
 模仿spring的IOC实例化（只是实例化，没有注入）
 就是注解加反射实现的，理解这个原理，spring的IOC源码的基础就知道了，具体就是spring的IOC源码的具体流程      
 * */
public class SpringMain {

	public static void main(String[] args) {
		//
		DiySpring.reflectToNewInstance("com.demo.refletc.Component1");
		DiySpring.reflectToNewInstance("com.demo.refletc.Component2");

		Component1 component1 = (Component1) DiySpring.getBean("1111");
		Component2 component2 = (Component2) DiySpring.getBean("2222");
		System.out.println(component1.getMyName());
		System.out.println(component2.getMyName());
	}

}
