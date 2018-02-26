package org.dselent.course_load_scheduler.client.model;

import java.util.Date;

public class CalendarInfo extends Model
{
	// attributes
	
	private Integer id;
	private Integer calYear;
	private String calTerm;
	private String days;
	private Integer startTime;
	private Integer endTime;
	private Date createdAt;
	private Date updatedAt;
	private Boolean deleted;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCalYear() {
		return calYear;
	}

	public void setCalYear(Integer cal_year) {
		this.calYear = cal_year;
	}

	public String getCalTerm() {
		return calTerm;
	}

	public void setCalTerm(String cal_term) {
		this.calTerm = cal_term;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public Integer getStartTime() {
		return startTime;
	}

	public void setStartTime(Integer start_time) {
		this.startTime = start_time;
	}

	public Integer getEndTime() {
		return endTime;
	}

	public void setEndTime(Integer end_time) {
		this.endTime = end_time;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		if (updatedAt != null)
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

	//
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((calTerm == null) ? 0 : calTerm.hashCode());
		result = prime * result + ((calYear == null) ? 0 : calYear.hashCode());
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((days == null) ? 0 : days.hashCode());
		result = prime * result + ((deleted == null) ? 0 : deleted.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
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
		CalendarInfo other = (CalendarInfo) obj;
		if (calTerm == null) {
			if (other.calTerm != null)
				return false;
		} else if (!calTerm.equals(other.calTerm))
			return false;
		if (calYear == null) {
			if (other.calYear != null)
				return false;
		} else if (!calYear.equals(other.calYear))
			return false;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (days == null) {
			if (other.days != null)
				return false;
		} else if (!days.equals(other.days))
			return false;
		if (deleted == null) {
			if (other.deleted != null)
				return false;
		} else if (!deleted.equals(other.deleted))
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (updatedAt == null) {
			if (other.updatedAt != null)
				return false;
		} else if (!updatedAt.equals(other.updatedAt))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CalendarInfo [id=" + id + ", cal_year=" + calYear + ", cal_term=" + calTerm + ", days=" + days
				+ ", start_time=" + startTime + ", end_time=" + endTime + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + ", deleted=" + deleted + "]";
	}
	
}