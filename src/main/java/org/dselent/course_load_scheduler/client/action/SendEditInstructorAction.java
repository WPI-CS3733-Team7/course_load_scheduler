package org.dselent.course_load_scheduler.client.action;

public class SendEditInstructorAction extends Action
{
	Integer userId;
	String id;
	String rank;
	String firstName;
	String lastName;
	String email;
	String courseLoadType;
	String courseLoadDescription;
	String deleted;
	
	public SendEditInstructorAction(Integer userId, String id, String rank, String firstName, String lastName, String email,
			String courseLoadType, String courseLoadDescription, String deleted)
	{
		this.userId = userId;
		this.id = id;
		this.rank = rank;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.courseLoadType = courseLoadType;
		this.courseLoadDescription = courseLoadDescription;
		this.deleted = deleted;
	}

	public Integer getUserId() {
		return userId;
	}
	
	public String getId() {
		return id;
	}

	public String getRank() {
		return rank;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}
	
	public String getCourseLoadType() {
		return courseLoadType;
	}

	public String getCourseLoadDescription() {
		return courseLoadDescription;
	}

	public String getDeleted() {
		return deleted;
	}

	@Override
	public String toString() {
		return "SendEditInstructorAction [userId=" + userId + ", id=" + id + ", rank=" + rank + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", courseLoadType=" + courseLoadType
				+ ", courseLoadDescription=" + courseLoadDescription + ", deleted=" + deleted + "]";
	}
}
