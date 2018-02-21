package org.dselent.course_load_scheduler.client.model;


public class InstructorUserLink extends Model
{
	// attributes
	
	private Integer id;
	private Integer instructor_id;
	private Integer linked_user_id;
	
	// methods
		
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getInstructorId() {
		return instructor_id;
	}

	public void setInstructorId(Integer instructor_id) {
		this.instructor_id = instructor_id;
	}

	public Integer getLinkedUserId() {
		return linked_user_id;
	}

	public void setLinkedUserId(Integer linked_user_id) {
		this.linked_user_id = linked_user_id;
	}
	
}