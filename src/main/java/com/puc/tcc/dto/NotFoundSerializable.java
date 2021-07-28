package com.puc.tcc.dto;

import java.time.LocalDateTime;

import javax.json.bind.annotation.JsonbProperty;

public class NotFoundSerializable {

	private String message;
	private int status;
	private LocalDateTime createdAt;

	public static NotFoundSerializable of(String message) {
		return new NotFoundSerializable(message);
	}

	public NotFoundSerializable(String message) {
		super();
		this.message = message;
		this.status = 404;
		this.createdAt = LocalDateTime.now();
	}

	public String getMessage() {
		return message;
	}

	@JsonbProperty("http_status")
	public int getStatus() {
		return status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

}
