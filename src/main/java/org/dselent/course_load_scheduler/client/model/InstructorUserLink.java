package org.dselent.course_load_scheduler.client.model;

import java.sql.Timestamp;
import java.time.Instant;


public class InstructorUserLink extends Model
{
	// attributes
	
	private Integer id;
	private Integer instructor_id;
	private Integer linked_user_id;
	private Instant createdAt;
	private Instant updatedAt;
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

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		if (createdAt != null)
		this.createdAt = createdAt.toInstant();
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		if (updatedAt != null)
		this.updatedAt = updatedAt.toInstant();
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
	
	
}