package com.todo.todo.helloword;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class HelloWorldController {
	@GetMapping(path ="/hello-world")
	public String  HelloWorld() {

	         return "Hello World";
	}
	
	@GetMapping(path ="/hello-world-bean")
	public HelloWorldBean HelloWorldBean() {

	         return new HelloWorldBean("Hello World");
	}
	//passe un paramatre en url
	@GetMapping(path ="/hello-world/path-variable/{name}")
	public HelloWorldBean HelloWorldPathVariable(@PathVariable String name ) {
		//methode string.format transforme variable en string
		//throw new RuntimeException("Something went wrong");
		return new HelloWorldBean(String.format("hello World, %s", name) );

	        
	}
	
	
}
