package zy.blue7.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import zy.blue7.aop.Book;
import zy.blue7.config.AppConfig;
import zy.blue7.demo.User;
import zy.blue7.event.MyApplicationEventPublisher;
import zy.blue7.event.MyEvent;

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
//		User user = applicationContext.getBean(User.class);
//		System.out.println(user.toString());
//		Book book = applicationContext.getBean(Book.class);
//		book.buyBook("小说");

		MyApplicationEventPublisher myApplicationEventPublisher = applicationContext.getBean(MyApplicationEventPublisher.class);

		myApplicationEventPublisher.publishEvent(new MyEvent(myApplicationEventPublisher,123456,"blue7"));
//		System.out.println("---------------->");
		/**
		 * 主要测试addBeanFactoryPostProcessor方法
		 */
//		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
//		applicationContext.register(AppConfig.class);
//		applicationContext.addBeanFactoryPostProcessor(new BeanFactoryPostProcessorDemo());
//		applicationContext.refresh();
//
//		User user = applicationContext.getBean(User.class);
//		System.out.println(user);
	}
}
