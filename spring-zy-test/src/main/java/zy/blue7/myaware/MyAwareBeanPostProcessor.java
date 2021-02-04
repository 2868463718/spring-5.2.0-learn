package zy.blue7.myaware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author blue7
 * @create 2021/2/3 16:50
 */
@Component
public class MyAwareBeanPostProcessor implements BeanPostProcessor {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if(bean instanceof MyAware){
			((MyAware) bean).setRole("我是你大爷，这里调用了自定义的aware  ---》myaware接口， 将这个spring底层的字符串传给了自定义的bean，供他使用");
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		/**
		 * 注意不能返回为空，否则其他的beanpostprocessor后置处理器不能继续处理该bean（初始化后）
		 */
		return bean;
	}
}
