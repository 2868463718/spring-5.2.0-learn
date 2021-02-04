package zy.blue7.InstantiationAwareBeanPostProcessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author blue7
 * @create 2021/1/29 10:49
 */

/**
 * 自定义处理器
 *
 */
//todo https://blog.csdn.net/qq_38526573/article/details/88091702
@Component
public class InstantiationAwareBeanPostProcessorDemo implements InstantiationAwareBeanPostProcessor {
	/**
	 * InstantiationAwareBeanPostProcessor中自定义的方法
	 * 在方法实例化之前执行  Bean对象还没有
	 */
	/**
	 * 自身方法，是最先执行的方法，它在目标对象实例化之前调用，
	 * 该方法的返回值类型是Object，我们可以返回任何类型的值。
	 * 由于这个时候目标对象还未实例化，所以这个返回值可以用来代替原本该生成的目标对象的实例(比如代理对象)。
	 * 如果该方法的返回值代替原本该生成的目标对象，后续只有postProcessAfterInitialization方法会调用，
	 * 其它方法不再调用；否则按照正常的流程走
	 */
	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		System.out.println("InstantiationAwareBeanPostProcessorDemo  >> postProcessBeforeInstantiation  >>  "+beanName);

		/**
		 * 返回的是代理对象，如果为空就继续进行下面正常的操作，就不是代理对象了
		 */
		return null;
	}

	/**
	 * 在目标对象实例化之后调用，这个时候对象已经被实例化，
	 * 但是该实例的属性还未被设置，都是null。
	 * 因为它的返回值是决定要不要调用postProcessPropertyValues方法的其中一个因素（因为还有一个因素是mbd.getDependencyCheck()）；
	 * 如果该方法返回false,并且不需要check，那么postProcessPropertyValues就会被忽略不执行；如果返回true，postProcessPropertyValues就会被执行
	 */
	/**
	 * InstantiationAwareBeanPostProcessor中自定义的方法
	 * 在方法实例化之后执行  Bean对象已经创建出来了
	 */
	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		System.out.println("InstantiationAwareBeanPostProcessorDemo  >> postProcessAfterInstantiation  >>  "+beanName);
		return true;
	}

	/**
	 * 对属性值进行修改，如果postProcessAfterInstantiation方法返回false，
	 * 该方法可能不会被调用。可以在该方法内对属性值进行修改
	 */
	/**
	 * InstantiationAwareBeanPostProcessor中自定义的方法
	 * 可以用来修改Bean中属性的内容
	 */
	@Override
	public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
		System.out.println("InstantiationAwareBeanPostProcessorDemo  >>  postProcessProperties  >> "+ beanName);
		System.out.println("------------------------------");
		System.out.println(pvs.getPropertyValues());
		System.out.println("------------------------------");
		return pvs;
	}


	/**
	 * BeanPostProcessor接口中的方法
	 * 在Bean的自定义初始化方法之前执行
	 * Bean对象已经存在了
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("InstantiationAwareBeanPostProcessorDemo >> postProcessBeforeInitialization >> "+beanName);
		return bean;
	}

	/**
	 * BeanPostProcessor接口中的方法
	 * 在Bean的自定义初始化方法执行完成之后执行
	 * Bean对象已经存在了
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("InstantiationAwareBeanPostProcessorDemo >> postProcessAfterInitialization >> "+beanName);
		return bean;
	}
}
