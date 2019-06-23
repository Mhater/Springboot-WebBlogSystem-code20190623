package com.code.spring.boot.blog.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * 
 * */
@SpringBootApplication
@RestController
public class HelloController {

	@RequestMapping("/hello")
	public  String hello() {
		return "hello";
	}
}
