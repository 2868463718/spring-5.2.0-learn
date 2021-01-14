package zy.blue7.demo;

import org.springframework.stereotype.Component;

/**
 * @author blue7
 * @create 2021/1/12 17:15
 */
@Component
public class User {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User() {
	}

	public User(String name) {
		this.name = name;
	}
}
