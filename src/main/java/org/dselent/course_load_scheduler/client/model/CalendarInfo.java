package org.dselent.course_load_scheduler.client.model;

import java.util.Date;

public class CalendarInfo extends Model
{
	// attributes
	
	private Integer id;
	private Integer cal_year;
	private String cal_term;
	private String days;
	private Integer start_time;
	private Integer end_time;
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
		return cal_year;
	}

	public void setCalYear(Integer cal_year) {
		this.cal_year = cal_year;
	}

	public String getCalTerm() {
		return cal_term;
	}

	public void setCalTerm(String cal_term) {
		this.cal_term = cal_term;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public Integer getStartTime() {
		return start_time;
	}

	public void setStartTime(Integer start_time) {
		this.start_time = start_time;
	}

	public Integer getEndTime() {
		return end_time;
	}

	public void setEndTime(Integer end_time) {
		this.end_time = end_time;
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
		result = prime * result + ((cal_term == null) ? 0 : cal_term.hashCode());
		result = prime * result + ((cal_year == null) ? 0 : cal_year.hashCode());
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((days == null) ? 0 : days.hashCode());
		result = prime * result + ((deleted == null) ? 0 : deleted.hashCode());
		result = prime * result + ((end_time == null) ? 0 : end_time.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((start_time == null) ? 0 : start_time.hashCode());
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
		if (cal_term == null) {
			if (other.cal_term != null)
				return false;
		} else if (!cal_term.equals(other.cal_term))
			return false;
		if (cal_year == null) {
			if (other.cal_year != null)
				return false;
		} else if (!cal_year.equals(other.cal_year))
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
		if (end_time == null) {
			if (other.end_time != null)
				return false;
		} else if (!end_time.equals(other.end_time))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (start_time == null) {
			if (other.start_time != null)
				return false;
		} else if (!start_time.equals(other.start_time))
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
		return "CalendarInfo [id=" + id + ", cal_year=" + cal_year + ", cal_term=" + cal_term + ", days=" + days
				+ ", start_time=" + start_time + ", end_time=" + end_time + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + ", deleted=" + deleted + "]";
	}
	
}