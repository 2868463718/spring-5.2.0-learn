package zy.blue7.initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import zy.blue7.config.AppConfig;
import zy.blue7.config.RootConfig;

/**
 * @author blue7
 * @create 2021/3/8 17:44
 */

/**
 * todo web容器启动的时候就会创建对象，调用方法来初始化容器以及前端控制器
 */
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	/**
	 * 获取跟容器的配置类（spring的配置文件）父容器
	 *
	 * @return
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{RootConfig.class};
	}

	/**
	 * 获取web容器的配置类（springmvc配置文件）子容器
	 *
	 * @return
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{AppConfig.class};
	}

	//获取DispatcherServlet的映射信息
	//  /:拦截所有请求（包括静态信息（xx.js  XX.png））,但不包含*.jsp
	//  /*:拦截所有请求 包括jsp也给拦截，jsp是tomcat引擎解析的
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[]{"/"};
	}
}
