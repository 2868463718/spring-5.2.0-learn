package zy.blue7.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author blue7
 * @create 2021/3/8 17:47
 */

/**
 * 根 容器的配置类（spring的配置文件）父容器
 */
@Configuration
@ComponentScan("zy.blue7")
public class RootConfig {
}
