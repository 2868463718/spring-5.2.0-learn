package zy.blue7.aop;

import org.springframework.stereotype.Component;

/**
 * @author blue7
 * @create 2021/2/4 14:20
 */
//@Component
public class Book {

	@MyAop
	public void buyBook(String name){
		System.out.println("这是我买的书..."+name);
//		throw new RuntimeException("这里抛出异常了");
	}
}
