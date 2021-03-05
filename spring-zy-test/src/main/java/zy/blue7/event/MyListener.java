package zy.blue7.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author blue7
 * @create 2021/3/5 16:06
 * todo
 * 第二种 实现事件监听类的方式
 * 2.2:使用注解@EventListener
 */
//@Component
public class MyListener {

	@EventListener
	public void listenerMyEvent(MyEvent event) {
		System.out.println("后台正在生成名字用户ID为：" + event.getId());
		System.out.println("后台正在生成名字：" + event.getName());
	}
}
