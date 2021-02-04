package zy.blue7.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author blue7
 * @create 2021/1/28 18:00
 */

/**
 * 自定义的BeanPostProcessor
 */
//@Component
public class UserBeanPostprocessorDemo implements BeanPostProcessor {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("UserBeanPostprocessorDemo-----postProcess    +Before+   Initialization"+" -- "+beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("UserBeanPostprocessorDemo-----postProcess  +After+   Initialization"+" -- "+beanName);
		return bean;
	}
}
