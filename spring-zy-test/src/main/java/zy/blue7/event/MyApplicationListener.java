package zy.blue7.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author blue7
 * @create 2021/3/5 16:04
 * 这里实现监听注意这里填写自己的事件类 如果不填写默认是监听applicationEvent类
 *
 * todo 事件监听类一共有两种，
 * 第一种：实现ApplicationListener监听事件类复写onApplicationEvent()方法
 */
@Component
public class MyApplicationListener implements ApplicationListener<MyEvent> {
	@Override
	public void onApplicationEvent(MyEvent event) {
		System.out.println(event.toString() + "监听到的事件");
	}
}
