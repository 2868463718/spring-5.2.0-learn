package zy.blue7.circle;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author blue7
 * @create 2021/3/4 16:53
 */
@Aspect
@Component
public class CircleAopRun {
	@Pointcut("@annotation(zy.blue7.circle.CircleAop)")
	public void pointCut() {
	}

	@Before("pointCut()")
	public void beforeBuyBook(JoinPoint joinPoint) {

		System.out.println("这是  b 类的aop方法的 before 方法");
	}
}
