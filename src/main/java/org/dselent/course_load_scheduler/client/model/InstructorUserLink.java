package org.dselent.course_load_scheduler.client.model;

import java.util.Date;

public class InstructorUserLink extends Model
{
	// attributes
	
	private Integer id;
	private Integer instructor_id;
	private Integer linked_user_id;
	private Date createdAt;
	private Date updatedAt;
	private Boolean deleted;
	
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		if (createdAt != null)
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		if (updatedAt != null)
		this.updatedAt = updatedAt;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
	
	
}