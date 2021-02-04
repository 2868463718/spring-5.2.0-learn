package zy.blue7.demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Component;

/**
 * @author blue7
 * @create 2021/1/28 18:04
 */

/**
 * 自定义SmartInitializingSingleton，所有的bean实例化后会调用该类的afterSingletonsInstantiated方法
 */
//@Component
public class SmartInitializingSingletonDemo implements SmartInitializingSingleton {
	@Override
	public void afterSingletonsInstantiated() {
		System.out.println("++++++++++++++++++SmartInitializingSingleton=============");
	}
}
