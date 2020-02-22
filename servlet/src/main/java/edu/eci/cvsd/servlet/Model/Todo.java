package edu.eci.cvsd.servlet.Model;

public class Todo {
	
	private int Id;
	private int UserId;
	private String Title;
	private Boolean Completed;
	
	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public Boolean getCompleted() {
		return Completed;
	}

	public void setCompleted(Boolean completed) {
		Completed = completed;
	}

	public Todo() {}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
}
