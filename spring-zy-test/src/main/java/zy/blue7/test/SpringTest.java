package zy.blue7.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import zy.blue7.config.AppConfig;
import zy.blue7.demo.User;

/**
 * @author blue7
 * @create 2021/1/12 17:13
 */
public class SpringTest {

	public static void main(String[] args) {
		new SpringTest().testSpringContainer();
	}
	public void testSpringContainer(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		User user = applicationContext.getBean(User.class);
	}
}
