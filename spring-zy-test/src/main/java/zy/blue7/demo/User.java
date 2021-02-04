package zy.blue7.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.weaving.LoadTimeWeaverAware;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.stereotype.Component;
import zy.blue7.myaware.MyAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * @author blue7
 * @create 2021/1/12 17:15
 */
public class User implements MessageSourceAware , LoadTimeWeaverAware, MyAware {
	public User() {
	}

	/**
	 * 通过spring自动注入，不需要写getXXX，setXX 方法
	 */

	@Value("你大爷")
	private String name;

	@Value("${age}")
	private Integer age;

	@Value("${height}")
	private Integer height;

	@Autowired
	private Student student;

	@Resource
	private Teacher teacher;

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", age=" + age +
				", height=" + height +
				", student=" + student +
				", teacher=" + teacher +
				'}';
	}

	/**
	 * 自定义初始化方法 {@Bean注解中的指定初始化和销毁方法}
	 */
	public void initMethod(){
		System.out.println("this is 自定义的 init method");
	}

	@PostConstruct
	public void postCon() {
		System.out.println("this is @PostConstruct annotation  method ");
	}

	@PreDestroy
	public void proDest() {
		System.out.println("this is @PreDestroy annotation  method ");
	}

	@Override
	public void setMessageSource(MessageSource messageSource) {
		System.out.println(messageSource);
		System.out.println("<<<<--------messageSource-------------->>>");
	}

	@Override
	public void setLoadTimeWeaver(LoadTimeWeaver loadTimeWeaver) {
		System.out.println(loadTimeWeaver);
		System.out.println("<<<<--------loadTimeWeaver-------------->>>");
	}

	@Override
	public void setRole(String role) {
		System.out.println(role);
		System.out.println("__________role______________");
	}
}
