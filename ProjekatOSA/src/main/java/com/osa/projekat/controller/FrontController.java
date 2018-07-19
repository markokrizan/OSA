package com.osa.projekat.controller;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontController implements ErrorController {
	
	//---------------------------------------------
	@RequestMapping("/test")
	public String test() {
		return "test";
	}
	//---------------------------------------------
	
	
	
	
	
	@RequestMapping("/")
	public String index() {
        return "index";
	}
	
	
	@RequestMapping("/modals")
	public String modals() {
		return "modals";
	}
	
	
	@RequestMapping("/nav")
	public String nav() {
		return "navigation";
	}
	
	
	

	@RequestMapping("/post/{id}")
	public String post(@PathVariable("id") String id) {
		//proveru radi na frontu jer je ovo namenjeno da bude posebna aplikacija	
        return "post";
	}
	
	//----------------------------------------------------
	@RequestMapping("/error")
	public String error(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if (status != null) {
	        Integer statusCode = Integer.valueOf(status.toString());
	     
	        if(statusCode == HttpStatus.NOT_FOUND.value()) {
	            return "404";
	        }
	        else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
	            return "500";
	        }
	        else if (statusCode == HttpStatus.UNAUTHORIZED.value()) {
	        	return "403";
	        }
	    }
	    return "error";
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}
	//----------------------------------------------------
	
	
	
	
	
	
	
}
	
