package model;

public class Task {
	
	private int TaskId;
	private String TaskTitle;
	private String TaskText;
	private String assignedTo;
	private boolean taskCompleted;
	
	public Task() {
	}
	
	public Task(String taskTitle, String taskText, String assignedTo, boolean taskCompleted) {
		super();
		TaskTitle = taskTitle;
		TaskText = taskText;
		this.assignedTo = assignedTo;
		this.taskCompleted = taskCompleted;
	}

	public int getTaskId() {
		return TaskId;
	}

	public void setTaskId(int taskId) {
		TaskId = taskId;
	}

	public String getTaskTitle() {
		return TaskTitle;
	}

	public void setTaskTitle(String taskTitle) {
		TaskTitle = taskTitle;
	}

	public String getTaskText() {
		return TaskText;
	}

	public void setTaskText(String taskText) {
		TaskText = taskText;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public boolean isTaskCompleted() {
		return taskCompleted;
	}

	public void setTaskCompleted(boolean taskCompleted) {
		this.taskCompleted = taskCompleted;
	}

	@Override
	public String toString() {
		return "task [TaskId=" + TaskId + ", TaskTitle=" + TaskTitle + ", TaskText=" + TaskText + ", assignedTo=" + assignedTo
				+ ", taskCompleted=" + taskCompleted + "]";
	}
	

}
