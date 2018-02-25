package org.dselent.course_load_scheduler.client.action;

public class SendEditInstructorAction extends Action
{
	Integer userId;
	String id;
	String rank;
	String firstName;
	String lastName;
	String email;
	String courseLoadId;
	String courseLoadType;
	String courseLoadDescription;
	String deleted;
	
	public SendEditInstructorAction(Integer userId, String id, String rank, String firstName, String lastName, String email,
			String courseLoadId, String courseLoadType, String courseLoadDescription, String deleted)
	{
		this.userId = userId;
		this.id = id;
		this.rank = rank;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.courseLoadId = courseLoadId;
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
	
	public String getCourseLoadId() {
		return courseLoadId;
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
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", courseLoadId=" + courseLoadId
				+ ", courseLoadType=" + courseLoadType + ", courseLoadDescription=" + courseLoadDescription
				+ ", deleted=" + deleted + "]";
	}
}
