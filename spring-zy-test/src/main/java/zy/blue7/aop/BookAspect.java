package zy.blue7.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author blue7
 * @create 2021/2/4 14:18
 */
//@Aspect
//@Component
public class BookAspect {

	/**
	 *
	 * 这整个就是一个环绕通知
	 *
	 * try {
	 *     @Before   --->>>前置通知：可以获取到函数的入参，函数名等信息，获取不到返回值
	 *     buyBook();
	 *     @AfterReturning   --->>>后置通知 ：正常返回，没有出现异常，可以拿到返回值
	 * 	} catch (Exception e) {
	 *     @AfterThrowing    --->>>异常通知 ： 有异常会走到这里，可以获取到异常信息
	 * 	} finally {
	 *     @After            --->>>返回通知 ： 无论是否有异常都会走到这里
	 * 	}
	 *
	 *	正常情况下：------》》》
	 * 这是 buyBook方法的 before 方法
	 * 这是我买的书...小说
	 * 这是 buyBook方法的 after 方法
	 * 这是 buyBook方法的 AfterReturning 方法
	 *
	 *
	 * 异常情况下：--------------》》》》
	 * 这是 buyBook方法的 before 方法
	 * 这是我买的书...小说
	 * 这是 buyBook方法的 after 方法
	 * 这是 buyBook方法的 AfterThrowing 方法
	 * Exception in thread "main" java.lang.RuntimeException: 这里抛出异常了
	 */




	//	@Pointcut("execution(* * zy.blue7.*.*.BuyBook(..))")
	@Pointcut("@annotation(zy.blue7.aop.MyAop)")
	public void pointCut() {}

	/**
	 * 前置通知
	 *
	 * @param joinPoint
	 */
	@Before("pointCut()")
	public void beforeBuyBook(JoinPoint joinPoint) {

		System.out.println("这是 buyBook方法的 before 方法");
	}

	/**
	 * 后置通知
	 *
	 * @param joinPoint
	 */
	@After("pointCut()")
	public void afterBuyBook(JoinPoint joinPoint) {

		System.out.println("这是 buyBook方法的 after 方法");
	}

	/**
	 * 正常返回通知
	 * JoinPoint一定要出现在参数表的第一位
	 *
	 * @param joinPoint
	 * @param result
	 */
	@AfterReturning(value = "pointCut()", returning = "result")
	public void afterReturningBuyBook(JoinPoint joinPoint, Object result) {

		System.out.println("这是 buyBook方法的 AfterReturning 方法");
	}

	@AfterThrowing(value = "pointCut()", throwing = "exception")
	public void afterThrowingBuyBook(JoinPoint joinPoint, Exception exception) {

		System.out.println("这是 buyBook方法的 AfterThrowing 方法");
	}

	/**
	 * 环绕通知
	 *
	 * @param joinPoint
	 */
//	@Around(value = "pointCut()", argNames = "pjp,joinPoint")
//	public Object aroundBuyBook(ProceedingJoinPoint pjp, JoinPoint joinPoint) {
//
//		System.out.println("这是 buyBook方法的 Around 方法");
//		return null;
//	}

}
