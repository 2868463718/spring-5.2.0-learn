package zy.blue7.circle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author blue7
 * @create 2021/3/2 17:55
 */
@Component
public class B {
	@Autowired
	private C c;

	@CircleAop
	public void sayAop() {
		System.out.println("circle aop");
	}
}
