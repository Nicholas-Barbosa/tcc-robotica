package com.puc.tcc.dto;

import java.time.ZonedDateTime;
import java.util.Set;

import javax.json.bind.annotation.JsonbPropertyOrder;

@JsonbPropertyOrder({ "status", "reason", "responsedAt" })
public class GenericResponse {

	private int status;
	private String reason;
	private ZonedDateTime responsedAt;
	private Set<GenericResponseAttribute> attributes;
	private String classDescription;

	public GenericResponse(int status, String reason, Set<GenericResponseAttribute> attributes) {
		super();
		this.status = status;
		this.reason = reason;
		this.attributes = attributes;
		this.responsedAt = ZonedDateTime.now();
		this.classDescription = "This class is a generic class to provide json response in a convenient way.Created by Nicholas Barbosa";
	}

	public int getStatus() {
		return status;
	}

	public String getReason() {
		return reason;
	}

	public Set<GenericResponseAttribute> getAttributes() {
		return attributes;
	}

	public ZonedDateTime getResponsedAt() {
		return responsedAt;
	}

	public String getClassDescription() {
		return classDescription;
	}

	@JsonbPropertyOrder({ "key", "value" })
	public static class GenericResponseAttribute {

		private String key;
		private Object value;

		public GenericResponseAttribute(String key, Object value) {
			super();
			this.key = key;
			this.value = value;
		}

		public String getKey() {
			return key;
		}

		public Object getValue() {
			return value;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((key == null) ? 0 : key.hashCode());
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
			GenericResponseAttribute other = (GenericResponseAttribute) obj;
			if (key == null) {
				if (other.key != null)
					return false;
			} else if (!key.equals(other.key))
				return false;
			return true;
		}

	}
}
