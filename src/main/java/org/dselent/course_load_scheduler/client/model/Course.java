package org.dselent.course_load_scheduler.client.model;

public class Course extends Model
{
	// attributes

    private Integer id;
    private String course_name;
    private String course_number;
    private String frequency;
    private Boolean deleted;

    // methods
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return course_name;
    }

    public void setCourseName(String course_name) {
        this.course_name = course_name;
    }

    public String getCourseNumber() {
        return course_number;
    }

    public void setCourseNumber(String course_number) {
        this.course_number = course_number;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((course_name == null) ? 0 : course_name.hashCode());
        result = prime * result + ((course_number == null) ? 0 : course_number.hashCode());
        result = prime * result + ((frequency == null) ? 0 : frequency.hashCode());
        result = prime * result + ((deleted == null) ? 0 : deleted.hashCode());
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
        if (!(obj instanceof Course))
        {
            return false;
        }
        Course other = (Course) obj;
        if (course_name == null)
        {
            if (other.course_name != null)
            {
                return false;
            }
        }
        else if (!course_name.equals(other.course_name))
        {
            return false;
        }
        if (course_number == null)
        {
            if (other.course_number != null)
            {
                return false;
            }
        }
        else if (!course_number.equals(other.course_number))
        {
            return false;
        }
        if (frequency == null)
        {
            if (other.course_number != null)
            {
                return false;
            }
        }
        else if (!course_number.equals(other.course_number))
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
        if (deleted == null) {
            if (other.deleted != null)
                return false;
        }
        else if (!deleted.equals(other.deleted))
        {
            return false;
        }
        return true;
    }


    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Courses [id=");
        builder.append(id);
        builder.append(", courseName=");
        builder.append(course_name);
        builder.append(", courseNumber=");
        builder.append(course_number);
        builder.append(", Frequency=");
        builder.append(frequency);
        builder.append(", deleted=");
        builder.append(deleted);
        builder.append("]");
        return builder.toString();
    }

	@Override
	public String displayText() {
		if(course_name.length()>15)
			return course_number + " " + course_name.substring(0, 12) + "...";
		else
			return course_number + " " + course_name;
	}

}
