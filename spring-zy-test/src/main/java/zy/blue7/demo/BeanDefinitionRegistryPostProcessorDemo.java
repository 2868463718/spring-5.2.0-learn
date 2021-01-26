package zy.blue7.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author blue7
 * @create 2021/1/25 14:08
 */
@Component
public class BeanDefinitionRegistryPostProcessorDemo implements BeanDefinitionRegistryPostProcessor {
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.out.println("BeanDefinitionRegistryPostProcessorDemo--postProcessBeanDefinitionRegistry()");
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("BeanDefinitionRegistryPostProcessorDemo--postProcessBeanFactory");
	}
}
