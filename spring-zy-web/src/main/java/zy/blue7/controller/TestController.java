package zy.blue7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author blue7
 * @create 2021/3/8 14:13
 */
@Controller
public class TestController {

	@ResponseBody
	@RequestMapping("index")
	public String index() {
		System.out.println("you are dog!");
		return "you are dog!";
	}
}
