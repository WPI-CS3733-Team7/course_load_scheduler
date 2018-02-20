package org.dselent.course_load_scheduler.client.model;

import java.util.Date;

public class UserState extends Model
{	
	// attributes
	
	private Integer id;
	private String state;
	private Date createdAt;
	private Date updatedAt;
	private Boolean deleted;

	// methods
	
	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public Date getCreatedAt()
	{
		return createdAt;
	}

	public void setCreatedAt(Date createdAt)
	{
		if(createdAt != null)
		{
			this.createdAt = createdAt;
		}
	}

	public Date getUpdatedAt()
	{
		return updatedAt;
	}
	
	public void setUpdatedAt(Date updatedAt)
	{
		if(updatedAt != null)
		{
			this.updatedAt = updatedAt;
		}
	}
	
	public Boolean isDeleted()
	{
		return deleted;
	}
	
	public void setDeleted(Boolean deleted)
	{
		this.deleted = deleted;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((deleted == null) ? 0 : deleted.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (!(obj instanceof UserState))
		{
			return false;
		}
		UserState other = (UserState) obj;
		if (createdAt == null)
		{
			if (other.createdAt != null)
			{
				return false;
			}
		}
		else if (!createdAt.equals(other.createdAt))
		{
			return false;
		}
		if (deleted == null)
		{
			if (other.deleted != null)
			{
				return false;
			}
		}
		else if (!deleted.equals(other.deleted))
		{
			return false;
		}
		if (id == null)
		{
			if (other.id != null)
			{
				return false;
			}
		}
		else if (!id.equals(other.id))
		{
			return false;
		}
		if (state == null)
		{
			if (other.state != null)
			{
				return false;
			}
		}
		else if (!state.equals(other.state))
		{
			return false;
		}
		if (updatedAt == null)
		{
			if (other.updatedAt != null)
			{
				return false;
			}
		}
		else if (!updatedAt.equals(other.updatedAt))
		{
			return false;
		}
		return true;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("UserStates [id=");
		builder.append(id);
		builder.append(", state=");
		builder.append(state);
		builder.append(", createdAt=");
		builder.append(createdAt);
		builder.append(", updatedAt=");
		builder.append(updatedAt);
		builder.append(", deleted=");
		builder.append(deleted);
		builder.append("]");
		return builder.toString();
	}
}
