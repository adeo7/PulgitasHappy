package com.example.PulgitasHappy.Dto;

public class ApiResponseDto<T> {
	
private String message;
	
	private Boolean Status;
	
	private T data;
	
	public ApiResponseDto() {
		
	}
	
	public ApiResponseDto(String message, Boolean status, T data) {
		this.message = message;
		Status = status;
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getStatus() {
		return Status;
	}

	public void setStatus(Boolean status) {
		Status = status;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
	
}
