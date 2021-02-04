package zy.blue7.config;

import org.springframework.context.annotation.*;
import zy.blue7.demo.Student;
import zy.blue7.demo.User;
import zy.blue7.myimport.MyDeferredImportSelector;
import zy.blue7.myimport.MyImportBeanDefinitionRegistrar;

/**
 * @author blue7
 * @create 2021/1/12 17:26
 */
@Configuration
@ComponentScan({"zy.blue7"})
/**
 * ymal，properties文件都支持
 */
@PropertySource("classpath:application.properties")
@PropertySource("classpath:application.yml")
/**
 * MyImportSelector是实现importselector接口的实现类，该类中默认方法返回的字符串数组中的类的全限定名就是要导入的类
 */
//@Import({Child.class)
//@Import({MyImportSelector.class})
//@Import({MyDeferredImportSelector.class})
@Import({MyImportBeanDefinitionRegistrar.class})
public class AppConfig {

	//	@Bean
	public Student student() {
		return new Student();
	}

	@Bean(initMethod = "initMethod",name = "user")
	public User getUser(){
		return new User();
	}

	/**
	 * 这个内部类上标注@Component，@ComponentScan，@Import，@ImportResource，四个注解
	 * 或者该内部类中有 @Bean 注解的方法 ，都会被当作配置类解析
	 */
//	class AppConfigChild {
//		private Integer age;
//
//		public Integer getAge() {
//			return age;
//		}
//
//		public void setAge(Integer age) {
//			this.age = age;
//		}
//
//		@Bean
//		public Student student() {
//			return new Student();
//		}
//	}
}
