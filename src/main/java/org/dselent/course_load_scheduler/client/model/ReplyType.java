package org.dselent.course_load_scheduler.client.model;

public class ReplyType extends Model
{
	// attributes
	
	private Integer id;
	private String reply_type;
	private Boolean deleted;

	// methods
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReplyType() {
		return reply_type;
	}

	public void setReplyType(String reply_type) {
		this.reply_type = reply_type;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
	// Hashcode and Equals

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deleted == null) ? 0 : deleted.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((reply_type == null) ? 0 : reply_type.hashCode());
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
		ReplyType other = (ReplyType) obj;
		if (deleted == null) {
			if (other.deleted != null)
				return false;
		} else if (!deleted.equals(other.deleted))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (reply_type == null) {
			if (other.reply_type != null)
				return false;
		} else if (!reply_type.equals(other.reply_type))
			return false;
		return true;
	}

	// toString
	
	@Override
	public String toString() {
		return "ReplyType [id=" + id + ", reply_type=" + reply_type + ", deleted=" + deleted + "]";
	}
	
	
}

