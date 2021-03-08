package zy.blue7.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * @author blue7
 * @create 2021/3/8 11:09
 */
public class MyApplicationEventPublisher1 implements ApplicationEventPublisher {
	@Override
	public void publishEvent(Object event) {

		/**
		 * todo {@link AbstractApplicationContext} 类实现了ApplicationEventPublisher 接口的publishEvent方法，用于发布事件，我们也可以自己写，但是没必要，太麻烦了
		 * 只需要使用spring自带的就可以了，
		 * todo 事件发布器只负责发布事件，事件监听器只负责 监听事件，监听到自己监听的事件就执行对应的操作，
		 * todo 至于 两者怎么联系在一起的还是带靠 {@link ApplicationEventMulticaster} 来联系
		 * 比如说，ApplicationEventMulticaster 将一个事件分配给对应的监听器来处理，
		 * todo ApplicationEventMulticaster起一个协调的作用，协调事件和监听器，解耦
		 * ApplicationEventMulticaster 也有默认的实现，你也可以自己实现，不过没必要，默认的更香一点
		 */
	}
}
