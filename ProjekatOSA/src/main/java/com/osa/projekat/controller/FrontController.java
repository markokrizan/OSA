package com.osa.projekat.controller;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Controller
public class FrontController {
	
	
	
	
	@RequestMapping("/")
	public String index() {
        return "index";
	}
	
	/*
	@RequestMapping("/test")
	public String test() {
        return "testPage.html";
	}
	*/
	
	
	
	@RequestMapping("/test/{id}")
	public String test(@PathVariable("id") String id) {
		//ovde je provera ustvari da li ga ima pa ako ga nema onda error 
        return "testPage";
	}
	
	
}
	
