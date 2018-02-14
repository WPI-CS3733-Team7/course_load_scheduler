package org.dselent.course_load_scheduler.client.model;

public class RequestType extends Model
{
	// attributes
	
	private Integer id;
	private String request_type;

	// methods

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getRequestType()
	{
		return request_type;
	}

	public void setRequestType(String request_type)
	{
		this.request_type = request_type;
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((request_type == null) ? 0 : request_type.hashCode());
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
		if (!(obj instanceof RequestType))
		{
			return false;
		}
		RequestType other = (RequestType) obj;
		
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
		if (request_type == null)
		{
			if (other.request_type != null)
			{
				return false;
			}
		}
		else if (!request_type.equals(other.request_type))
		{
			return false;
		}
		return true;
		
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("RequestType [id=");
		builder.append(id);
		builder.append(", request_type=");
		builder.append(request_type);
		builder.append("]");
		return builder.toString();
	}
	
	
}