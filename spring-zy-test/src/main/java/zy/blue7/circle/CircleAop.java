package zy.blue7.circle;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author blue7
 * @create 2021/3/4 16:52
 */

/**
 * 判断三级缓存循环依赖的
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CircleAop {
}
