package zy.blue7.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import zy.blue7.demo.Student;

/**
 * @author blue7
 * @create 2021/1/12 17:26
 */
@Configuration
@ComponentScan({"zy.blue7"})
public class AppConfig {

	@Bean
	public Student student() {
		return new Student();
	}
}
