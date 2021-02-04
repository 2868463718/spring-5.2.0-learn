package zy.blue7.myaware;

import org.springframework.beans.factory.Aware;

/**
 * @author blue7
 * @create 2021/2/3 16:48
 */

/**
 * 自定义Aware子接口，可以把spring底层的组件赋值给自定义bean供他使用
 */
public interface MyAware extends Aware {

	void setRole(String role);
}
