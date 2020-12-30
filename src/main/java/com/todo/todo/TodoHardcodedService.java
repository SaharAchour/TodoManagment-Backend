package com.todo.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TodoHardcodedService {
	
	private static int idCounter=0;
	private static List<Todo> todos=new ArrayList();

	static {
		todos.add(new Todo(++idCounter , "sahar" , "learn to Dance" , new Date(), false));
		todos.add(new Todo(++idCounter , "sahar" , "learn Nodejs" , new Date(), false));
		todos.add(new Todo(++idCounter , "sahar" , "Do homework" , new Date(), false));
		
	}
	public List<Todo> findAll(){
		return todos;
	}
	
	// check if -1 then it's a new to do 
	public Todo save(Todo todo) {
		if(todo.getId()==-1 || todo.getId()==0) {
			todo.setId(++idCounter);
			todos.add(todo);
		}else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}
	
	public Todo deleteById(long id) {
		Todo todo =findById(id);
		
		
		if(todo==null) return null;
		if(todos.remove(todo)) {
			return todo;
		}
		return null;
	}

	public Todo findById(long id) {
		for(Todo todo:todos) {
			if(todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}

}
