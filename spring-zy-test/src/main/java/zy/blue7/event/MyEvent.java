package zy.blue7.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author blue7
 * @create 2021/3/5 15:57
 * 事件类
 */
public class MyEvent extends ApplicationEvent {
	private static final long serialVersionUID = 12312312313123L;

	private long id;
	private String name;

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	/**
	 * Create a new {@code ApplicationEvent}.
	 *
	 * @param source the object on which the event initially occurred or with
	 *               which the event is associated (never {@code null})
	 */
	/**
	 *
	 * @param source todo 任务就是一个普通的类，用来保存你要发布事件的内容。这个没有特殊限制，可以根据自己业务随意设置。
	 * @param id
	 * @param name
	 */
	public MyEvent(Object source, long id, String name) {
		super(source);
		this.id = id;
		this.name = name;
	}
}
