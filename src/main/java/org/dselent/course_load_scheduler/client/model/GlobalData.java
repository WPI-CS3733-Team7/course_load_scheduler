package org.dselent.course_load_scheduler.client.model;

public class GlobalData extends Model
{
	private Integer userId;
	private String role;
	private Integer linkedInstructorId;
	
	public Integer getUserId()
	{
		return userId;
	}

	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}
	
	public String getRole()
	{
		return role;
	}
	
	public void setRole(String role)
	{
		this.role = role;
	}
	
	public Integer getLinkedInstructorId()
	{
		return linkedInstructorId;
	}
	
	public void setLinkedInstructorId(Integer linkedInstructorId)
	{
		this.linkedInstructorId = linkedInstructorId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((linkedInstructorId == null) ? 0 : linkedInstructorId.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
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
		GlobalData other = (GlobalData) obj;
		if (linkedInstructorId == null) {
			if (other.linkedInstructorId != null)
				return false;
		} else if (!linkedInstructorId.equals(other.linkedInstructorId))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "GlobalData [role=" + role + ", linkedInstructorId=" + linkedInstructorId
				+ "]";
	}	
}
