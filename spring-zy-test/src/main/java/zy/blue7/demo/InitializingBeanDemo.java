package zy.blue7.demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author blue7
 * @create 2021/1/28 18:13
 */

/**
 * 自定义InitializingBean，在InitializingBeanDemo初始化的时候会执行afterPropertiesSet方法
 */
//@Component
public class InitializingBeanDemo implements InitializingBean {
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("+++&&&&&&&&&");
	}
}
