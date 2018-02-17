package org.dselent.course_load_scheduler.client.model;


public class Request extends Model
{
	// attributes

    private Integer id;
    private Integer requester_id;
    private String request_type;
    private String request_details;
    private Integer reply_type_id;
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

    public Integer getRequesterId()
    {
        return requester_id;
    }

    public void setRequesterId(Integer requester_id)
    {
        this.requester_id = requester_id;
    }

    public String getRequestType()
    {
        return request_type;
    }

    public void setRequestType(String request_type)
    {
        this.request_type = request_type;
    }

    public String getRequestDetails()
    {
        return request_details;
    }

    public void setRequestDetails(String request_details)
    {
        this.request_details = request_details;
    }

    public Integer getReplyTypeId()
    {
        return reply_type_id;
    }

    public void setReplyTypeId(Integer reply_type_id)
    {
        this.reply_type_id = reply_type_id;
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
        result = prime * result + ((request_type == null) ? 0 : request_type.hashCode());
        result = prime * result + ((reply_type_id == null) ? 0 : reply_type_id.hashCode());
        result = prime * result + ((request_details == null) ? 0 : request_details.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((requester_id == null) ? 0 : requester_id.hashCode());
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
        if (!(obj instanceof Request))
        {
            return false;
        }
        Request other = (Request) obj;
        if (requester_id == null)
        {
            if (other.requester_id != null)
            {
                return false;
            }
        }
        else if (!requester_id.equals(other.requester_id))
        {
            return false;
        }
        if (request_details == null)
        {
            if (other.request_details != null)
            {
                return false;
            }
        }
        else if (!request_details.equals(other.request_details))
        {
            return false;
        }
        if (reply_type_id == null)
        {
            if (other.reply_type_id != null)
            {
                return false;
            }
        }
        else if (!reply_type_id.equals(other.reply_type_id))
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
        builder.append("Users [id=");
        builder.append(id);
        builder.append(", RequesterID=");
        builder.append(requester_id);
        builder.append(", RequestType=");
        builder.append(request_type);
        builder.append(", RequestDetails=");
        builder.append(request_details);
        builder.append(", ReplyTypeID=");
        builder.append(reply_type_id);
        builder.append(", deleted=");
        builder.append(deleted);
        builder.append("]");
        return builder.toString();
    }

	@Override
	public String displayText() {
		if(request_details.length()>20)
			return request_details.substring(0,17)+"...";
		else
			return request_details;
	}
}

