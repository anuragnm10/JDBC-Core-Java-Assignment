package ui;

import java.util.*;
import db.TodoDB;
import model.Task;
import service.dao;

public class Main {

	public static void main(String[] args) {

		TodoDB db = new TodoDB();
		dao serv = new dao(db);

		Scanner input = new Scanner(System.in);
		int choice;
		System.out.println("Login \n");
		System.out.println("Please enter Username :");
		String username = input.next();
		System.out.println("Please enter password :");
		String password = input.next();

		try {
			if (serv.login(username, password)) {
				System.out.println("Welcome " + username + " !");
				boolean flag = false;
				do {
					System.out.println("Please select options from below: \n" + "1. Add task \n" + "2. Update task \n"
							+ "3. Delete task \n" + "4. Search task \n" + "5. See all my tasks \n"
							+ "6. Search tasks based on status \n" + "7. Exit");

					choice = input.nextInt();
					input.nextLine();

					switch (choice) {
					case 1:
						System.out.println("Add Task ");
						System.out.println("Task Title : ");
						String taskTitle = input.nextLine();
						System.out.println("Task Text : ");
						String taskText = input.nextLine();
						System.out.println("Please enter email : ");
						String email = input.next();
						System.out.println("Is the task complete ?");
						System.out.println("Press Y if complete");
						String response = input.next();

						Boolean isComplete = false;
						if (response.equalsIgnoreCase("y"))
							isComplete = true;

						Task task = new Task(taskTitle, taskText, email, isComplete);
						try {
							if (serv.insertTasks(task)) {
								System.out.println("Task added successfully :");
								System.out.println(serv.search(taskTitle));
							}
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						break;
					case 2:
						System.out.println("Update Task ");
						System.out.println("Please enter the task Id which you want to edit: ");
						Task updatedTask = new Task();
						int id = input.nextInt();
						updatedTask.setTaskId(id);
						input.nextLine();
						System.out.println("Task title :");
						String title = input.nextLine();
						System.out.println("Task text :");
						String text = input.nextLine();
						System.out.println("Press Y if complete");
						String resp = input.next();

						Boolean Complete = false;
						if (resp.equalsIgnoreCase("y"))
							Complete = true;

						System.out.println("Email :");
						String emailId = input.next();
						updatedTask.setAssignedTo(emailId);
						updatedTask.setTaskTitle(title);
						updatedTask.setTaskText(text);
						updatedTask.setTaskCompleted(Complete);
						
						try {
							if(serv.updateTask(updatedTask)) {
								System.out.println("Task with "+id+" updated successfully");
							}
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}
						
						break;
					case 3:
						System.out.println("Delete Task \n");
						System.out.println("Please enter the task ID which you want to delete :");
						choice = input.nextInt();
						System.out.println("Are you sure you want delete this task ?");
						System.out.println("Please enter Y to continue");
						String ans = input.next();
						try {
							if (ans.equalsIgnoreCase("y")) {
								if (serv.deleteTask(choice, username))
									System.out.println("Task deleted successfully");
							}
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						break;
					case 4:
						System.out.println("Search Task \n");
						System.out.println("Please enter the task name :");
						String tasktitle = input.nextLine();
						try {
							Task t = serv.search(tasktitle);
							System.out.println("Task found ");
							System.out.println(t);
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						break;
					case 5:
						System.out.println("Get all Tasks");
						System.out.println("Please enter email Id");
						String emailid = input.next();
						try {
							for (Task tasks : serv.getAllTask(emailid)) {
								System.out.println(tasks);
							}
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						break;
					case 6:
						System.out.println("Search Tasks based on status");
						System.out.println("Please select the status (true/false)");
						boolean status = input.nextBoolean();
						System.out.println("Enter emailid");
						String eid = input.next();
						try {
							for (Task tasks : serv.searchByStatus(status, eid)) {
								System.out.println(tasks);
							}
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						break;
					case 7:
						flag = true;
						System.out.println("Thank you!");
						break;
					default:
						System.out.println("Please select correct option");
						break;
					}
				} while (!flag);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

	}

}
