package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import model.Task;
import model.User;
public class TodoDB {
	
	Connection conn = TodoDatabaseConnection.getConnection();
	
	public List<Task> getAllTasks(String email) throws Exception{
		String sql = "select * from tasks where assignedto = ?;";
		
		List<Task> tasks = new ArrayList<>();
		
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, email);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Task task = new Task();
				task.setTaskId(rs.getInt(1));
				task.setTaskTitle(rs.getString(2));
				task.setTaskText(rs.getString(3));
				task.setAssignedTo(rs.getString(4));
				task.setTaskCompleted(rs.getBoolean(5));
				tasks.add(task);
			}
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return tasks;
		
	}
	
	
	public boolean addTask(Task task) throws Exception {
		String sql = "insert into tasks (tasktitle, tasktext, assignedto, taskcompleted) values(?,?,?,?);";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, task.getTaskTitle());
			statement.setString(2, task.getTaskText());
			statement.setString(3, task.getAssignedTo());
			statement.setBoolean(4, task.isTaskCompleted());
			statement.execute();
		}catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
		
//		String email1 = task.getAssignedTo();
//		String sql1 = "select email from users where email = "
		return true;
	}
	
	public boolean updateTask(Task task) throws Exception {
		String sql = "update tasks set tasktitle = ?, tasktext = ?, taskcompleted = ? where taskId = ?;";
		
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, task.getTaskTitle());
			statement.setString(2, task.getTaskText());
			statement.setBoolean(3, task.isTaskCompleted());
			statement.setInt(4, task.getTaskId());
			statement.execute();
		}catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
		return true;
		
	}
	
	
	public boolean deleteTask(int taskId, String username) throws Exception {
		String sql = "delete from tasks where taskId = ? and assignedto = (select email from users where username = ?);";
		
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, taskId);
			statement.setString(2, username);
			statement.execute();
		}catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
		return true;
		
	}
	
	public Task searchTask(String taskTitle) throws Exception {
		String sql = "select taskId, tasktitle, tasktext, assignedto, taskcompleted from tasks where tasktitle = ?;";
		Task task = new Task();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, taskTitle);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				task.setTaskId(rs.getInt(1));
				task.setTaskTitle(rs.getString(2));
				task.setTaskText(rs.getString(3));
				task.setAssignedTo(rs.getString(4));
				task.setTaskCompleted(rs.getBoolean(5));
			}
		}catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
		return task;
		
	}
	
	public List<Task> searchBasedOnTaskStatus(boolean status, String email) throws Exception{
		String sql = "select * from tasks where taskcompleted = ? and assignedto = ?;";
		
		List<Task> tasklist = new ArrayList<>();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setBoolean(1, status);
			statement.setString(2, email);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				Task task = new Task();
				task.setTaskId(rs.getInt(1));
				task.setTaskTitle(rs.getString(2));
				task.setTaskText(rs.getString(3));
				task.setAssignedTo(rs.getString(4));
				task.setTaskCompleted(rs.getBoolean(5));
				tasklist.add(task);
			}
		}catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
		return tasklist;
		
	}
	
	public boolean validatecreds(String username, String password) throws Exception {
		User user = null;
		
		String sql = "select pass from users where username = ?;";
		PreparedStatement statement;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				if(password.equals(rs.getString(1)))
					return true;
			}
			throw new Exception("Invalid credentials!");
		}catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
		
	}
	

}
