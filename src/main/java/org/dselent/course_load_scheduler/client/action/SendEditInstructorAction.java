package org.dselent.course_load_scheduler.client.action;

public class SendEditInstructorAction extends Action
{
	String id;
	String rank;
	String firstName;
	String lastName;
	String email;
	String deleted;
	
	public SendEditInstructorAction(String id, String rank, String firstName, String lastName, String email,
			String deleted)
	{
		this.id = id;
		this.rank = rank;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.deleted = deleted;
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

	public String getDeleted() {
		return deleted;
	}

	@Override
	public String toString() {
		return "SendEditInstructorAction [id=" + id + ", rank=" + rank + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", deleted=" + deleted + "]";
	}
}
