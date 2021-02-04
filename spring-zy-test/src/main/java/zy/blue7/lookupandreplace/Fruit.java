package zy.blue7.lookupandreplace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author blue7
 * @create 2021/1/29 9:59
 */

/**
 * 在Spring容器中，单例模式的bean只会被创建一次，
 * 然后容器会缓存该单例bean的实例，等到第二次获取时，可以直接返回该bean的实例，
 * 而无需重新创建；原型模式的bean则是每次都会创建一个全新的bean，
 * Spring容器并不会缓存该bean的实例以供下次使用。
 * 那么如果现在有一个单例模式的bean引用了一个原型模式的bean呢？
 * 我们不希望被引用的原型模式bean被缓存，那么这个时候就需要用到lookup-method注入。
 */

/**
 * 假设一个单例模式的bean A需要引用另外一个非单例模式的bean B，
 * 为了在我们每次引用的时候都能拿到最新的bean B，
 * 我们可以让bean A通过实现ApplicationContextWare来感知applicationContext（即可以获得容器上下文），
 * 从而能在运行时通过ApplicationContext.getBean(String beanName)的方法来获取最新的bean B。
 * 但是如果用ApplicationContextAware接口，就让我们与Spring代码耦合了，
 * 违背了反转控制原则（IoC，即bean完全由Spring容器管理，我们自己的代码只需要用bean就可以了）。
 * 所以Spring为我们提供了方法注入的方式来实现以上的场景。方法注入方式主要是通过标签。
 */
//@Component
//@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)//单例
public class Fruit {
	public Fruit() {
		System.out.println("fruit ----");
	}


//	private Apple apple;
//
//	@Lookup
//	public Apple getApple(){
//		return null;
//	}

}
