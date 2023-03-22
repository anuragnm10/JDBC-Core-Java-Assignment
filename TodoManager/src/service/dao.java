package service;

import db.TodoDB;
import model.Task;

import java.util.*;

public class dao {
	
	private TodoDB todo;
	
	public dao (TodoDB todo) {
		this.todo = todo;
	}
	
	public List<Task> getAllTask(String email) throws Exception{
		if(todo.getAllTasks(email).size() == 0) {
			throw new Exception("No Task present for this email Id.");
		}
		
		return todo.getAllTasks(email); 
	}
	
	public boolean insertTasks(Task task) throws Exception {
		try {
			todo.addTask(task);
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		return true;
	}
	
	
	public boolean updateTask(Task task) throws Exception {
		try {
			todo.updateTask(task);
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
		
		return true;
	}
	
	public boolean deleteTask(int taskid, String username) throws Exception {
		try {
			todo.deleteTask(taskid, username);
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return true; 
	}
	
	
	public Task search(String tasktitle) throws Exception {
		if(tasktitle == null || tasktitle.isEmpty()) {
			throw new Exception("tasktitle cannot be empty");
		}
		
		Task task = todo.searchTask(tasktitle);
		if(task == null) {
			throw new Exception("task with title "+tasktitle+" is not present");
		}
		
		return task;
	}
	
	public List<Task> searchByStatus(boolean status, String email) throws Exception{
		if((email == null || email.isEmpty())) {
			throw new Exception("Email cannot be empty");
		}
		List<Task> task = new ArrayList<>();
		task = todo.searchBasedOnTaskStatus(status, email);
		if(task.size()==0) {
			throw new Exception("No tasks present with "+status+" status");
		}
		
		return task;
	}
	
	public boolean login(String username, String password) throws Exception {
		try {
			todo.validatecreds(username, password);
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return true;
	}

}
