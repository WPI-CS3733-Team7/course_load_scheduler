package org.dselent.course_load_scheduler.client.model;

import java.util.Date;


public class InstructorUserLinkHistory extends Model
{
	// attributes
	
	private Integer id;
	private Integer former_id;
	private Integer instructor_id;
	private Integer linked_user_id;
	private Date createdAt;
	
	// methods
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getFormerId() {
		return former_id;
	}

	public void setFormerId(Integer former_id) {
		this.former_id = former_id;
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

	//
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((former_id == null) ? 0 : former_id.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((instructor_id == null) ? 0 : instructor_id.hashCode());
		result = prime * result + ((linked_user_id == null) ? 0 : linked_user_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InstructorUserLinkHistory other = (InstructorUserLinkHistory) obj;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (former_id == null) {
			if (other.former_id != null)
				return false;
		} else if (!former_id.equals(other.former_id))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (instructor_id == null) {
			if (other.instructor_id != null)
				return false;
		} else if (!instructor_id.equals(other.instructor_id))
			return false;
		if (linked_user_id == null) {
			if (other.linked_user_id != null)
				return false;
		} else if (!linked_user_id.equals(other.linked_user_id))
			return false;
		return true;
	}

	//
	
	@Override
	public String toString() {
		return "InstructorUserLinkHistory [id=" + id + ", former_id=" + former_id + ", instructor_id=" + instructor_id
				+ ", linked_user_id=" + linked_user_id + ", createdAt=" + createdAt + "]";
	}
	
}